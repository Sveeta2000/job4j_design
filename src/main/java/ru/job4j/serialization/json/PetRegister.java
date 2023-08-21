package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

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

        JSONObject jsonOwner = new JSONObject("{\"ownerName\":\"Svetlana\",\"phone\":\"89141234567\",\"ownerID\":12345}");
        JSONArray jsonVaccines = new JSONArray(Arrays.asList("Vaccine A", "V-B"));
        JSONObject jsonCat = new JSONObject();
        jsonCat.put("petName", cat.getPetName());
        jsonCat.put("isGirl", cat.isGirl());
        jsonCat.put("age", cat.getAge());
        jsonCat.put("owner", jsonOwner);
        jsonCat.put("vaccines", jsonVaccines);
        System.out.println(jsonCat);
        System.out.println(new JSONObject(cat));
    }
}
