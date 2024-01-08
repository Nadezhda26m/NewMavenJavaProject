package ru.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SerialPersonJson {

    static void serialJson(Person person, String file) throws IOException {
        try (BufferedWriter bufWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file)))) {
            Gson gson = new Gson();
            String json = gson.toJson(person);
            bufWriter.write(json);
        }
    }

    static Person deSerialJson(String file) throws IOException {
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufReader = new BufferedReader(fileReader)) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = bufReader.readLine()) != null) {
                sb.append(str);
            }
            Gson gson = new Gson();
            return gson.fromJson(sb.toString(), Person.class);
        }
    }
}
