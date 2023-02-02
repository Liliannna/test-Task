package org.example;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestStringSorter {
    private final String out = "out.txt";
    private final String in1 = "text1.txt";
    private final String in2 = "text2.txt";

    @Test
    public void testAscendingSort() {
        List<String> list = new ArrayList<>();
        list.add(out);
        list.add(in1);
        list.add(in2);
        String[] array1 = {"a", "r", "t", "x"};
        String[] array2 = {"b", "c", "k", "y"};
        List<String> result = new ArrayList<>(Arrays.asList("a", "b", "c", "k", "r", "t", "x", "y"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(in1));
            for (String elem : array1) {
                writer.write(elem);
                writer.newLine();
            }
            writer.close();
            writer = new BufferedWriter(new FileWriter(in2));
            for (String elem : array2) {
                writer.write(elem);
                writer.newLine();
            }
            writer.close();
            StringSorter.ascendingSort(list);
            List<String> readFile = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(out));
            String line;
            while ((line = br.readLine()) != null) {
                readFile.add(line);
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
        String[] array1 = {"x", "t", "r", "a"};
        String[] array2 = {"y", "k", "c", "b"};
        List<String> result = new ArrayList<>(Arrays.asList("y", "x", "t", "r", "k", "c", "b", "a"));
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(in1));
            for (String elem : array1) {
                writer.write(elem);
                writer.newLine();
            }
            writer.close();
            writer = new BufferedWriter(new FileWriter(in2));
            for (String elem : array2) {
                writer.write(elem);
                writer.newLine();
            }
            writer.close();
            StringSorter.descendingSort(list);
            List<String> readFile = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(out));
            String line;
            while ((line = br.readLine()) != null) {
                readFile.add(line);
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
