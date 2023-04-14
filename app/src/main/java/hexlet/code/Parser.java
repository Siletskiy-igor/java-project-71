package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.TreeMap;

public class Parser {
    public static TreeMap<String, Object> parse(String content, String format) throws Exception {
        ObjectMapper objectMapper = null;

        switch (format) {
            case "json":
                objectMapper = new ObjectMapper();
                break;
            case "yml":
                objectMapper = new ObjectMapper(new YAMLFactory());
                break;
            case "yaml":
                objectMapper = new ObjectMapper(new YAMLFactory());
                break;

            default: throw new Exception("Unknown format" + format);
        }
        return objectMapper.readValue(content, new TypeReference<>() { });
    }
}
