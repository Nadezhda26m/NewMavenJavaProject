package ru.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Имя", "Фамилия", 30);
        Person person2 = new Person("Имя", "Фамилия", 30);
        Person person3 = new Person("Имя2", "Фамилия", 40);

        System.out.println(person);
        System.out.println(person2);
        System.out.println(person3);

        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person3.hashCode());

        System.out.println(person.equals(person2));
        System.out.println(person.equals(person3));

        String fileJson = getFilePath("person.json");

        try {
            SerialPersonJson.serialJson(person, fileJson);
            Person person1 = SerialPersonJson.deSerialJson(fileJson);
            System.out.println(person1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String getFilePath(String fileName) {
        String separator = System.getProperty("file.separator");
        StringBuilder sb = new StringBuilder();
        sb.append("src").append(separator);
        sb.append("main").append(separator);
        sb.append("java").append(separator);
        sb.append("ru").append(separator);
        sb.append("example").append(separator);
        sb.append(fileName);

        return sb.toString();
    }
}

/*
(toString)
Person[Имя,Фамилия,30]
Person[Имя,Фамилия,30]
Person[Имя2,Фамилия,40]

(hashCode)
-912646107
-912646094
1895424428

(equals)
true
false

(Json: {"firstName":"Имя","lastName":"Фамилия","age":30})
Person[Имя,Фамилия,30]
 */
