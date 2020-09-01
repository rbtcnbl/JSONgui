package com.msr.utils.json.generator.json;

import com.google.gson.*;

import java.util.*;

public class JsonBuilder {

    public static void main(String[] args) {

        Gson gson = new Gson();
        List<Categories> categories = new LinkedList<>();
        categories.add(new Categories("1003"));
        categories.add(new Categories("1004"));

        LinkedHashMap<String, String> booleanuzsfos = new LinkedHashMap<>();
        booleanuzsfos.put("value", "true");

        Children children1 = new Children(generateUUID(), "P5Y7M", categories, new BooleanUzsfos(booleanuzsfos));
        Children children2 = new Children(generateUUID(), "P10Y7M", categories);

        List<Children> childrens = new LinkedList<>();
        childrens.add(children1);
        childrens.add(children2);


        Families families = new Families(childrens);

        Citizen citizen = new Citizen(generateUUID(), families);
        Person person = new Person("Проверка если X4, X7, X8 true",
                citizen, "true");
        String json = gson.toJson(person);
        System.out.println(json);
    }

    static UUID generateUUID() {
        return UUID.randomUUID();
    }

}



