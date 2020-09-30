package com.msr.utils.json.generator.request;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class Request {
    Gson gson = new Gson();
    private static final Logger log = LoggerFactory.getLogger(Request.class);
    public void sendRequest(String json) throws Exception {
        String url = "http://erl-dev-app-01.msr.lan:8080/uzsfo-validity-processor-test/processor/check";
        URL object = new URL(url);
        byte[] postData = json.getBytes(Charset.forName("UTF-8"));
        int postDataLength = postData.length;
        HttpURLConnection con = (HttpURLConnection) object.openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Length", Integer.toString(postDataLength) );
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setDoInput(true);
        DataOutputStream wr = new DataOutputStream (
                con.getOutputStream());
        wr.writeBytes(json);
        wr.close();



//display what returns the POST request

        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            String response = sb.toString();
            try (Writer writer = new FileWriter("1001_test_case_response.json")) {
                gson = new GsonBuilder().create();
                gson.toJson(response.replaceAll("\"", ""), writer);
                log.info("Ответ получен: ");
                log.info("" + response);
            } catch (Exception exception) {
                log.info(String.valueOf(exception));
            }
        } else {
            //вывод подробного описания ошибки
            InputStream errorstream = con.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(errorstream));
            String response ="";
            String nachricht;
            while ((nachricht = br.readLine()) != null){
                response += nachricht;
            }
            log.error(con.getResponseCode() + "  " + con.getResponseMessage() + " " + response);

        }
    }
}
