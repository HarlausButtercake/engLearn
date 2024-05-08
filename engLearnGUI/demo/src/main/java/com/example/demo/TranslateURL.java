package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TranslateURL {
    public TranslateURL() {
        
    }

    public String Translate(String para, int mode) {
        String url = "https://api.mymemory.translated.net/get?q=" + URLEncoder.encode(para, StandardCharsets.UTF_8);
        if (mode == 1) {
            url += "&langpair=vi|en";
        } else {
            url += "&langpair=en|vi";
        }
        
        try {
            URL urlActual = new URL(url);
            HttpURLConnection newConnection = (HttpURLConnection) urlActual.openConnection();
            newConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(newConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
            }
            newConnection.disconnect();
            bufferedReader.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.toString());
            JSONObject responseData = (JSONObject) jsonResponse.get("responseData");
            return (String) responseData.get("translatedText");

        } catch (Exception e) {
            System.out.println(e);
            return e.toString();
        }
        
    }
    
}
