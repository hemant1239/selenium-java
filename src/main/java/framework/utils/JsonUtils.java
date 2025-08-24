package framework.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public class JsonUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static JsonNode getJsonNodeFromResource(String resourcePath) {
        try (InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(resourcePath)) {
            if (is == null) throw new FileNotFoundException(resourcePath);
            return new ObjectMapper().readTree(is);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
