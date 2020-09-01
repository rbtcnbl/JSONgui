package com.msr.utils.json.generator.json;

import java.util.UUID;

public class Citizen {
    public UUID guid;
    public Families families;

    Citizen() {
    }

    Citizen(UUID guid, Families families) {
        this.guid = guid;
        this.families = families;
    }


}
