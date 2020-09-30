package com.msr.utils.json.generator.json;

import java.util.List;

public class RequestPerson {

    private String checkCode;
    private String ruleType;
    private String ruleText;
    private Citizen citizen;

    public RequestPerson(String checkCode, String ruleType, String ruleText, Citizen citizen) {
        this.checkCode = checkCode;
        this.ruleType = ruleType;
        this.ruleText = ruleText;
        this.citizen = citizen;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    //    public static String checkCodeGenerate(List<Categories> categories){
//        String checkcode = null;
//        if(categories != null && !categories.isEmpty()){
//            for(Categories c : categories){
//                checkcode = checkcode + c.getCode();
//            }
//        }
//        return null;
//    }
}

/*
 * checkCode 0-12
 * ruleType "BENEFIT","CATEGORY"
 * ruleText RESULT=EVAL{[],X1}\nX1=EVAL{[],(X2+!X3)}\nX2=HAS_CAT{'1002'}\nX3=EXISTS{[K1],X4}\nK1=C1001_FAMILY{}\nX4=EVAL{[],X5*X6*X7}\nX5=HAS_CAT{'1001'}\nX6=SAME_BEN{}\nX7=AGE_RANGE{'[P6Y6M..P16Y)'}
 */
