package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parce(String content, String filetype) throws Exception {
        ObjectMapper objectMapper = null;

        if (filetype.equals(".json")) {
            objectMapper = new ObjectMapper();
        } else if (filetype.equals(".yml")) {
            objectMapper = new ObjectMapper(new YAMLFactory());
        } else {
            throw new Exception("unknown format");
        }
        return objectMapper.readValue(content, new TypeReference<>() { });
    }
}
