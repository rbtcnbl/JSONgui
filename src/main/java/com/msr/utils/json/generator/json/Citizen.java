package com.msr.utils.json.generator.json;

import java.util.List;
import java.util.UUID;

public class Citizen {
    private UUID guid;
    private List<Families> families;


    public Citizen(UUID guid, List<Families> families) {
        this.guid = guid;
        this.families = families;
    }

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public List<Families> getFamilies() {
        return families;
    }

    public void setFamilies(List<Families> families) {
        this.families = families;
    }
}
