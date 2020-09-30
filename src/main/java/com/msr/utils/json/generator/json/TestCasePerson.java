package com.msr.utils.json.generator.json;


public class TestCasePerson {

    private String comment;
    private Citizen citizen;
    private String result;

    public TestCasePerson(String comment, Citizen citizen, String result) {
        this.comment = comment;
        this.citizen = citizen;
        this.result = result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}





