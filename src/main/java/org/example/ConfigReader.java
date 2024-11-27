package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    public static FireSimulationConfig readConfig(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(); // Utilise Jackson pour lire le fichier JSON
        return objectMapper.readValue(new File(filePath), FireSimulationConfig.class);
    }
}