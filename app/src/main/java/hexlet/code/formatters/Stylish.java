package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
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
