package ru.sbt.mipt.oop.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sbt.mipt.oop.components.Door;
import ru.sbt.mipt.oop.components.Light;
import ru.sbt.mipt.oop.components.Room;
import ru.sbt.mipt.oop.components.SmartHome;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {

        Room kitchen = new Room(Arrays.asList(new Light("1", false), new Light("2", true)),
                Arrays.asList(new Door("1", false)),
                "kitchen");

        Room bathroom = new Room(Arrays.asList(new Light("3", false)),
                Arrays.asList(new Door( "2", false)),
                "bathroom");

        Room bedroom = new Room(Arrays.asList(new Light("4", false), new Light("5", false), new Light("6", false)),
                Arrays.asList(new Door( "3", true)),
                "bedroom");

        Room hall = new Room(Arrays.asList(new Light("7", false), new Light("8", false), new Light("9", false)),
                Arrays.asList(new Door( "4", false)),
                "hall");

        //Alarm alarm = new Alarm( "alarm", 12345);

        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen, bathroom, bedroom, hall));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        Path path = Paths.get("output.js");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }

}
