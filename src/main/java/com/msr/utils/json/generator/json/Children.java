package com.msr.utils.json.generator.json;


import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Children {
    private UUID guid;
    private String age;
    private List<Categories> categories;
    private Map<String, Value> booleanUzsfos;


    public Children(UUID guid, String age, List<Categories> categories, Map<String, Value> booleanUzsfos) {
        this.guid = guid;
        this.age = age;
        this.categories = categories;
        this.booleanUzsfos = booleanUzsfos;
    }

    public Children(UUID guid, String age, List<Categories> categories) {
        this.guid = guid;
        this.age = age;
        this.categories = categories;
    }

    public Map<String, Value> getBooleanUzsfos() {
        return booleanUzsfos;
    }

    public void setBooleanUzsfos(Map<String, Value> booleanUzsfos) {
        this.booleanUzsfos = booleanUzsfos;
    }

    public List<Categories> getCategories() {
        return categories;
    }

    public void setCategories(List<Categories> categories) {
        this.categories = categories;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }


}
