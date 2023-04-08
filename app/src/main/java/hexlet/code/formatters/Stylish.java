package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<String, Object>> dataDiff) {
        StringBuilder outputInStylishFormat = new StringBuilder("{\n");

        for (Map<String, Object> difference: dataDiff) {
            if (difference.get("condition").toString().equals("modified")) {
                outputInStylishFormat.append("  ").append("- ").append(difference.get("key")).append(": ")
                        .append(difference.get("old value")).append("\n").append("  ").append("+ ")
                        .append(difference.get("key")).append(": ").append(difference.get("new value")).append("\n");
            } else if (difference.get("condition").equals("deleted")) {
                outputInStylishFormat.append("  ").append("- ").append(difference.get("key")).append(": ")
                        .append(difference.get("old value")).append("\n");
            } else if (difference.get("condition").equals("added")) {
                outputInStylishFormat.append("  ").append("+ ").append(difference.get("key")).append(": ")
                        .append(difference.get("new value")).append("\n");
            } else {
                outputInStylishFormat.append("    ").append(difference.get("key")).append(": ")
                        .append(difference.get("old value")).append("\n");
            }
        }
        outputInStylishFormat.append("}");
        return outputInStylishFormat.toString();
    }

}
