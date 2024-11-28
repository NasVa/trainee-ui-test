package org.nasva.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nasva.constants.Constant;

import java.util.ArrayList;
import java.util.List;

public class ReferencesReader {
    public static List<String> getKidsDresses(String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = new String(
                    ReferencesReader.class.getClassLoader().getResourceAsStream(fileName).readAllBytes()
            );
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode kidsDressesArray = rootNode.get(Constant.kidsDressesKey);
            List<String> kidsDresses = new ArrayList<>();
            if (kidsDressesArray.isArray()) {
                for (JsonNode dressNode : kidsDressesArray) {
                    kidsDresses.add(dressNode.asText());
                }
            }
            return kidsDresses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}