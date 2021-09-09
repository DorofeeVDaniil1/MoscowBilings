package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream stream = new FileInputStream("d:/mb.csv");
        int length  = stream.available();

        byte [] data = new byte[length];
        stream.read(data);

        String text = new String(data);
        ArrayList<String[]> lineWords = new ArrayList<>();


       String [] lines =  text.split("\n");

       for (String line : lines){
           String [] words = line.split(",");
           lineWords.add(words);

       }
//       for (String[] words : lineWords){
//           if (words[9].equals("1999")){
//
//
//           for(String word:words){
//               System.out.print(word);
//               System.out.print("|__|");
//           }
//           System.out.println("-----------------------------");
//       }
//       }

        //Последовательно перебираем записи о домах и если запись нашлась ьто мы увеличиваем количтво домов построенных в этом году
        TreeMap<String,Integer> map = new TreeMap<>();
        for (String[] words : lineWords){
            if (map.containsKey(words[9])){
                 Integer k = map.get(words[9]);
                 k++;
                 map.put(words[9],k);
            }else {
                map.put(words[9],1);
            }
       }
//        //Сколько домов было построено в этом году
//        System.out.println(map.get("2002"));

       for (String key : map.keySet()){
           System.out.println("Год: "+ key+ " Количетсво: "+ map.get(key));
       }


    }
}
