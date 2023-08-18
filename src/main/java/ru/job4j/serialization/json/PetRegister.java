package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PetRegister {

    public static void main(String[] args) {
        final Pet cat = new Pet("Jenny", true, 7,
                new Owner("Svetlana", "89141234567", 12345),
                new String[] {"Vaccine A", "V-B"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(cat));
        final String petJson =
                "{"
                        + "\"petName\":\"Jenny\","
                        + "\"isGirl\":true,"
                        + "\"age\":7,"
                        + "\"owner\":"
                        + "{"
                        + "\"ownerName\":\"Svetlana\","
                        + "\"phone\":\"89141234567\","
                        + "\"ownerID\":12345"
                        + "},"
                        + "\"vaccines\":"
                        + "[\"Vaccine A\",\"V-B\"]"
                        + "}";
        final Pet catFromJson = gson.fromJson(petJson, Pet.class);
        System.out.println(catFromJson);
    }
}
