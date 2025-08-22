package framework.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode getJsonNode(String filePath) {
        try {
            return mapper.readTree(new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }
}
