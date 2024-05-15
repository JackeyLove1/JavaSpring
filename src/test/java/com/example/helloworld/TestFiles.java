package com.example.helloworld;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TestFiles {
    public static void main(String[] args) throws IOException {
        List<String> data = getData();
        for (var line : data){
            System.out.println(line);
        }
    }

    private static List<String> getData() {
        List<String> data = null;
        try {
            data = Files.readAllLines(Path.of("data", "p.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
