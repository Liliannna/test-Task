package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String pattern = ("([^s]+(.txt)$)");

        if(args[0].equals("-help") || args[0].equals("-h")){
            System.out.println("режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию");
            System.out.println("тип данных (-s или -i), обязательный");
            System.out.println("имя выходного файла, обязательное");
            System.out.println("остальные параметры – имена входных файлов, не менее одного");
        } else
        if((args[0].equals("-i") && args[1].equals("-a") && args[2].matches(pattern) && args[3].matches(pattern)) || (args[0].equals("-a") && args[1].equals("-i") && args[2].matches(pattern) && args[3].matches(pattern)) || (args[0].equals("-i") && args[1].matches(pattern) && args[2].matches(pattern))){
            //System.out.println("Сортировка чисел по возрастанию");
            List<String> files = new ArrayList<>();
            for (String elem : args) {
                if(elem.matches(pattern)){
                    files.add(elem);
                }
            }
            NumberSorter.ascendingSort(files);
        } else
        if((args[0].equals("-i") && args[1].equals("-d") && args[2].matches(pattern) && args[3].matches(pattern)) || (args[0].equals("-d") && args[1].equals("-i") && args[2].matches(pattern) && args[3].matches(pattern))){
            //System.out.println("Сортировка чисел по убыванию");
            List<String> files = new ArrayList<>();
            for (String elem : args) {
                if(elem.matches(pattern)){
                    files.add(elem);
                }
            }
            NumberSorter.descendingSort(files);
        } else
        if((args[0].equals("-s") && args[1].equals("-a") && args[2].matches(pattern) && args[3].matches(pattern)) || (args[0].equals("-a") && args[1].equals("-s") && args[2].matches(pattern) && args[3].matches(pattern)) || (args[0].equals("-s") && args[1].matches(pattern) && args[2].matches(pattern))){
            //System.out.println("Сортировка строк по возрастанию");
            List<String> files = new ArrayList<>();
            for (String elem : args) {
                if(elem.matches(pattern)){
                    files.add(elem);
                }
            }
            StringSorter.ascendingSort(files);
        } else
        if((args[0].equals("-s") && args[1].equals("-d") && args[2].matches(pattern) && args[3].matches(pattern)) || (args[0].equals("-d") && args[1].equals("-s") && args[2].matches(pattern) && args[3].matches(pattern))){
            //System.out.println("Сортировка строк по убыванию");
            List<String> files = new ArrayList<>();
            for (String elem : args) {
                if(elem.matches(pattern)){
                    files.add(elem);
                }
            }
            StringSorter.descendingSort(files);
        } else System.out.println("Неверный аргумент! Используйте команду \"help\" для вызова справки");
    }
}