package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StringSorter {
    public static void ascendingSort(List<String> files) {
        //System.out.println("сортировка строк по-возрастанию");
        String outputFileName = files.get(0);
        files.remove(0);
        String[] result = reader(files.get(0));
        files.remove(0);
        for (String elem : files) {
            String[] array1 = reader(elem);
            result = mergeAscendingSort(result, array1);
        }
        writer(outputFileName, result);
    }

    public static void descendingSort(List<String> files) {
        //System.out.println("сортировка строк по-убыванию");
        String outputFileName = files.get(0);
        files.remove(0);
        String[] result = reader(files.get(0));
        files.remove(0);
        for (String elem : files) {
            String[] array1 = reader(elem);
            result = mergeDescendingSort(result, array1);
        }
        writer(outputFileName, result);
    }

    private static String[] reader(String nameFile) {
        List<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + nameFile + " не найден");
        } catch (IOException e) {
            System.out.println("Файл " + nameFile + " поврежден либо содержит не корректные данные");
        }

        return list.toArray(new String[0]);
    }

    private static void writer(String nameFile, String[] result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile))) {
            for (String elem : result) {
                writer.write(elem);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] mergeDescendingSort(String[] array1, String[] array2) {
        String[] result = new String[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) > 0) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i < array1.length) {
            result[k] = array1[i];
            i++;
            k++;
        }

        while (j < array2.length) {
            result[k] = array2[j];
            j++;
            k++;
        }
        return result;
    }

    private static String[] mergeAscendingSort(String[] array1, String[] array2) {
        String[] result = new String[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i].compareTo(array2[j]) < 0) {
                result[k] = array1[i];
                i++;
            } else {
                result[k] = array2[j];
                j++;
            }
            k++;
        }

        while (i < array1.length) {
            result[k] = array1[i];
            i++;
            k++;
        }

        while (j < array2.length) {
            result[k] = array2[j];
            j++;
            k++;
        }
        return result;
    }
}
