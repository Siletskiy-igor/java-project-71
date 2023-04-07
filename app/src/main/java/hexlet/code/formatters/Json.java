package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

public class Json {
    public static String json(List<Map<String, Object>> dataDiff) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writeValueAsString(dataDiff);
    }
}
