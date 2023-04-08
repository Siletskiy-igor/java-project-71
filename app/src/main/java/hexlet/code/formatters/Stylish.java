package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<String, Object>> dataDiff) {
        StringBuilder result = new StringBuilder("{\n");

        for (Map<String, Object> difference: dataDiff) {
            if (difference.get("condition").toString().equals("modified")) {
                result.append("  ").append("- ").append(difference.get("key")).append(": ")
                        .append(difference.get("old value")).append("\n").append("  ").append("+ ")
                        .append(difference.get("key")).append(": ").append(difference.get("new value")).append("\n");
            } else if (difference.get("condition").equals("deleted")) {
                result.append("  ").append("- ").append(difference.get("key")).append(": ")
                        .append(difference.get("old value")).append("\n");
            } else if (difference.get("condition").equals("added")) {
                result.append("  ").append("+ ").append(difference.get("key")).append(": ")
                        .append(difference.get("new value")).append("\n");
            } else {
                result.append("    ").append(difference.get("key")).append(": ")
                        .append(difference.get("old value")).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }

}
