package com.msr.utils.json.generator.json;


import java.util.List;
import java.util.UUID;

public class Children {
    public UUID guid;
    public String age;
    public List<Categories> categories;
    public BooleanUzsfos booleanUzsfos;

    Children(UUID guid, String age, List<Categories> categories, BooleanUzsfos booleanUzsfos) {
        this.guid = guid;
        this.age = age;
        this.categories = categories;
        this.booleanUzsfos = booleanUzsfos;
    }

    Children(UUID guid, String age, List<Categories> categories) {
        this.guid = guid;
        this.age = age;
        this.categories = categories;
    }

    Children() {
    }


}
