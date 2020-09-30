package com.msr.utils.json.generator.json;


import java.util.List;

public class Families {
    private String type;
    private List<Children> members;

    public Families(String type, List<Children> members) {
        this.type = type;
        this.members = members;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Children> getMembers() {
        return members;
    }

    public void setMembers(List<Children> members) {
        this.members = members;
    }
}
