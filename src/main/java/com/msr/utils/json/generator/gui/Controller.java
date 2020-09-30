package com.msr.utils.json.generator.gui;


import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.msr.utils.json.generator.json.*;
import com.msr.utils.json.generator.request.Request;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller implements Initializable {
    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private final List<Children> members = new LinkedList<>();
    private final List<Families> families = new LinkedList<>();
    private String json;
    private String textRule;
    private List<Categories> cat;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textComment;

    @FXML
    private TextField ageChild;

    @FXML
    private TextField categories;

    @FXML
    private TextField uzsfoCode;

    @FXML
    private TextField uzsfoValue;

    @FXML
    private TextField result;

    @FXML
    private Button addChild;

    @FXML
    private Button createJSON;

    @FXML
    private Button sendResponse;

    @FXML
    private TextField ruleText;

    @FXML
    private CheckBox benefitCheck;

    @FXML
    private CheckBox categoryCheck;

    @FXML
    private TextField ruleType;


    @FXML
    private String selectRuleType() {
        if (benefitCheck.isSelected()) {
            return "BENEFIT";
        } else if (categoryCheck.isSelected()) {
            return "CATEGORY";
        } else
            return null;
    }


    @FXML
    private CharSequence enterTextRule() {
        if (ruleText.getText() != null && !ruleText.getText().isEmpty()) {
            CharSequence mas = ruleText.getCharacters();
            textRule = mas.toString().replace("\\n", "\n");
            return mas;
        } else {
            return null;
        }
    }


    @FXML
    private List<Categories> enterCategories() {
        List<Categories> benefit_cat = new LinkedList<>();
        if (categories.getText() != null && !categories.getText().isEmpty()) {
            String[] size = categories.getText().replaceAll("\\s+", "").split(",", -1);
            for (int i = 0; i < size.length; i++) {
                benefit_cat.add(new Categories(size[i]));
            }
        }
        cat = benefit_cat;
        return benefit_cat;
    }


    private String enterTextField(TextField textField) {
        if (textField.getText() != null && !textField.getText().isEmpty()) {
            return textField.getText();
        } else {
            return null;
        }
    }


    @FXML
    private void addPerson() {
        if (enterTextField(uzsfoValue) != null && enterTextField(uzsfoValue) != null) {
            Map<String, Value> booleanUzsfos = new LinkedHashMap<>();
            booleanUzsfos.put(enterTextField(uzsfoValue), new Value(enterTextField(uzsfoCode)));
            Children children = new Children(UUID.randomUUID(), enterTextField(ageChild), enterCategories(), booleanUzsfos);
            members.add(children);
            clearChild();

        } else {
            Children children = new Children(UUID.randomUUID(), enterTextField(ageChild), enterCategories());
            members.add(children);
            clearChild();
        }
        log.info("Персона добавлена");
    }


    private void clearChild() {
        uzsfoValue.clear();
        uzsfoCode.clear();
        ageChild.clear();
        categories.clear();
    }


    @FXML
    private void generateJSON() {
        Gson gson = new Gson();

        Families fam = new Families(enterTextField(ruleType), members);
        families.add(fam);

        TestCasePerson testCasePerson = new TestCasePerson(enterTextField(textComment), new Citizen(UUID.randomUUID(), families), enterTextField(result));
        String test_json = gson.toJson(testCasePerson);
        enterTextRule();

        RequestPerson requestPerson = new RequestPerson("1001893798437", selectRuleType(), textRule, new Citizen(UUID.randomUUID(), families));
        json = gson.toJson(requestPerson);

        try (Writer writer = new FileWriter(cat.get(0) + "_test_case_request.json")) {
            gson = new GsonBuilder().create();
            gson.toJson(test_json.replaceAll("\"", ""), writer);
        } catch (Exception exception) {
            log.info(String.valueOf(exception));
        }

        log.info(test_json);
        log.info(json);
    }

    @FXML
    private void sendResponse() {

        try {
            new Request().sendRequest(json);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
