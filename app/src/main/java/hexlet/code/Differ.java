package hexlet.code;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Objects;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws Exception {

        String filetype1 = getFiletype(filePath1);
        String filetype2 = getFiletype(filePath2);

        String content1 = getContent(filePath1);
        String content2 = getContent(filePath2);

        Map<String, Object> data1 = Parser.parce(content1, filetype1);
        Map<String, Object> data2 = Parser.parce(content2, filetype2);

        List<Map<String, Object>> dataDiff = getDataDiff(data1, data2);

        return stylish(dataDiff);
    }
    public static String getContent(String possiblePath) throws Exception {

        Path originalPath = Paths.get(possiblePath);
        Path absolutePath = originalPath.toAbsolutePath().normalize();

        if (!Files.exists(absolutePath)) {
            throw new Exception("File '" + absolutePath + "' does not exist");
        }

        return Files.readString(absolutePath);
    }

    public static String getFiletype(String filepath) {
        return filepath.substring(filepath.indexOf("."));
    }

    public static List<Map<String, Object>> getDataDiff(Map<String, Object> data1, Map<String, Object> data2)  {
        List<Map<String, Object>> dataDiff = new ArrayList<>();
        Set<String> keySet = new TreeSet<>(data1.keySet());
        keySet.addAll(data2.keySet());

        for (String key: keySet) {
            Map<String, Object> currentMap = new HashMap<>();
            if ((data1.containsKey(key) && data2.containsKey(key)) && !Objects.equals(data1.get(key), data2.get(key))) {
                currentMap.put("key", key);
                currentMap.put("old value", data1.get(key));
                currentMap.put("new value", data2.get(key));
                currentMap.put("condition", "modified");
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                currentMap.put("key", key);
                currentMap.put("old value", data1.get(key));
                currentMap.put("new value", "");
                currentMap.put("condition", "deleted");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                currentMap.put("key", key);
                currentMap.put("old value", "");
                currentMap.put("new value", data2.get(key));
                currentMap.put("condition", "added");
            } else {
                currentMap.put("key", key);
                currentMap.put("old value", data1.get(key));
                currentMap.put("new value", data2.get(key));
                currentMap.put("condition", "not changed");
            }
            dataDiff.add(currentMap);
        }
        return dataDiff;
    }

    public static String stylish(List<Map<String, Object>> dataDiff) {
        StringBuilder stringBuilder = new StringBuilder("{\n");
        for (Map<String, Object> difference: dataDiff) {
            if (difference.get("condition").toString().equals("modified")) {
                stringBuilder.append("  ")
                        .append("- ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("old value"))
                        .append("\n")
                        .append("  ")
                        .append("+ ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("new value"))
                        .append("\n");
            } else if (difference.get("condition").equals("deleted")) {
                stringBuilder.append("  ")
                        .append("- ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("old value"))
                        .append("\n");
            } else if (difference.get("condition").equals("added")) {
                stringBuilder.append("  ")
                        .append("+ ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("new value"))
                        .append("\n");
            } else {
                stringBuilder.append("    ")
                        .append(difference.get("key"))
                        .append(": ")
                        .append(difference.get("old value"))
                        .append("\n");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }


}
