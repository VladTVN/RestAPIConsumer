package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {
    public void main (String[] args) throws JsonProcessingException {
        System.out.println("¬ведите предлодение на русском");
        Scanner scanner = new Scanner(System.in);
        String sentencesForTranslate = scanner.nextLine();

        RestTemplate restTemplate = new RestTemplate();
        String url =  "";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization", "Bearer " + "token");

        Map<String, String> jsonData =  new HashMap<>();
        jsonData.put("folderId", "id");
        jsonData.put("targetLanguageCode", "en");
        jsonData.put("texts","[" + sentencesForTranslate + "]");

        HttpEntity<Map<String,String>> request = new HttpEntity<>(jsonData, httpHeaders);
        YandexResponse yandexResponse = restTemplate.patchForObject(url, request, YandexResponse.class);

//        ObjectMapper mapper = new ObjectMapper();
//
//        JsonNode jsonNode = mapper.readTree(response);

//        System.out.println(jsonNode.get("translations").get(0).get("text"));

        System.out.println(yandexResponse.getTranslations().get(0).getText());
    }
}
