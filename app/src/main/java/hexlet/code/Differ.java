package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {

        String content1 = getContent(filePath1);
        String content2 = getContent(filePath2);

        Map<String, Object> data1 = parce(content1);
        Map<String, Object> data2 = parce(content2);

        StringBuilder stringBuilder = new StringBuilder("{\n");
        for (Map.Entry<String, Object> e: data1.entrySet()) {
            String data1Key = e.getKey();
            Object data1Value = e.getValue();
            if (data2.containsKey(data1Key) && data2.get(data1Key).equals(data1Value)) {
                stringBuilder.append("  ").append(data1Key).append(": ").append(data1Value).append("\n");
            } else if (!data2.containsKey(data1Key)) {
                stringBuilder.append("- ").append(data1Key).append(": ").append(data1Value).append("\n");
            } else if (data2.containsKey(data1Key) && !data2.get(data1Key).equals(data1Value)) {
                stringBuilder.append("- ")
                        .append(data1Key).append(": ")
                        .append(data1Value).append("\n")
                        .append("+ ")
                        .append(data1Key)
                        .append(": ")
                        .append(data2.get(data1Key))
                        .append("\n");
            }
        }
        for (String e: data2.keySet()) {
            if (!data1.containsKey(e)) {
                stringBuilder.append("+ ").append(e).append(": ").append(data2.get(e)).append("\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();

    }
    public static String getContent(String possiblePath) throws Exception {

        Path originalPath = Paths.get(possiblePath);
        Path absolutePath = originalPath.toAbsolutePath().normalize();

        if (!Files.exists(absolutePath)) {
            throw new Exception("File '" + absolutePath + "' does not exist");
        }

        return Files.readString(absolutePath);
    }


    public static TreeMap<String, Object> parce(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<>() { });
    }


}
