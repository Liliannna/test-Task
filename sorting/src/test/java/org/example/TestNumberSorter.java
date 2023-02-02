package org.example;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestNumberSorter {
    private final String out = "out.txt";
    private final String in1 = "text1.txt";
    private final String in2 = "text2.txt";

    @Test
    public void testAscendingSort() {
        List<String> list = new ArrayList<>();
        list.add(out);
        list.add(in1);
        list.add(in2);
        int[] array1 = {2, 4, 5, 9, 12};
        int[] array2 = {6, 10, 24, 45};
        List<Integer> result = new ArrayList<>(Arrays.asList(2, 4, 5, 6, 9, 10, 12, 24, 45));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(in1));
            for (int elem : array1) {
                writer.write(Integer.toString(elem));
                writer.newLine();
            }
            writer.close();
            writer = new BufferedWriter(new FileWriter(in2));
            for (int elem : array2) {
                writer.write(Integer.toString(elem));
                writer.newLine();
            }
            writer.close();
            NumberSorter.ascendingSort(list);
            List<Integer> readFile = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(out));
            String line;
            while ((line = br.readLine()) != null) {
                readFile.add(Integer.valueOf(line));
            }
            br.close();
            assertEquals(result, readFile);
            Files.delete(Path.of(out));
            Files.delete(Path.of(in1));
            Files.delete(Path.of(in2));
        } catch (IOException ex) {
            fail();
        }
    }

    @Test
    public void testDescendingSort() {
        List<String> list = new ArrayList<>();
        list.add(out);
        list.add(in1);
        list.add(in2);
        int[] array1 = {45, 30, 17, 8, 3};
        int[] array2 = {89, 46, 31, 13, 2};
        List<Integer> result = new ArrayList<>(Arrays.asList(89, 46, 45, 31, 30, 17, 13, 8, 3, 2));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(in1));
            for (int elem : array1) {
                writer.write(Integer.toString(elem));
                writer.newLine();
            }
            writer.close();
            writer = new BufferedWriter(new FileWriter(in2));
            for (int elem : array2) {
                writer.write(Integer.toString(elem));
                writer.newLine();
            }
            writer.close();
            NumberSorter.descendingSort(list);
            List<Integer> readFile = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(out));
            String line;
            while ((line = br.readLine()) != null) {
                readFile.add(Integer.valueOf(line));
            }
            br.close();
            assertEquals(result, readFile);
            Files.delete(Path.of(out));
            Files.delete(Path.of(in1));
            Files.delete(Path.of(in2));
        } catch (IOException ex) {
            fail();
        }
    }
}
