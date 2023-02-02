package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NumberSorter {

    public static void ascendingSort(List<String> files) {
        //System.out.println("сортировка чисел по-возрастанию");
        String outputFileName = files.get(0);
        files.remove(0);

        int[] result = reader(files.get(0));
        files.remove(0);

        for (String elem : files) {
            int[] array1 = reader(elem);
            result = mergeAscendingSort(result, array1);
        }
        writer(outputFileName, result);
    }

    public static void descendingSort(List<String> files) {
        //System.out.println("сортировка чисел по-убыванию");
        String outputFileName = files.get(0);
        files.remove(0);

        int[] result = reader(files.get(0));
        files.remove(0);

        for (String elem : files) {
            int[] array1 = reader(elem);
            result = mergeDescendingSort(result, array1);
        }
        writer(outputFileName, result);
    }

    private static int[] reader(String nameFile) {
        List<Integer> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nameFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.valueOf(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл " + nameFile + " не найден");
        } catch (NumberFormatException e) {
            System.out.println("Файл " + nameFile + " содержит не корректные данные");
        } catch (IOException e) {
            System.out.println("Файл " + nameFile + " поврежден");
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void writer(String nameFile, int[] result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile))) {
            for (int elem : result) {
                writer.write(Integer.toString(elem));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] mergeDescendingSort(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] > array2[j]) {
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

    private static int[] mergeAscendingSort(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
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
