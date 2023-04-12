package hexlet.code.formatters;

import java.util.List;
import java.util.Map;
public class Plain {
    public static String plain(List<Map<String, Object>> dataDiff) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> difference: dataDiff) {
            if (difference.get("condition").equals("modified")) {
                result.append("Property ").append("'").append(difference.get("key"))
                        .append("'").append(" was updated. From ").append(valueSelection(difference.get("old value")))
                        .append(" to ").append(valueSelection(difference.get("new value"))).append("\n");
            } else if (difference.get("condition").equals("deleted")) {
                result.append("Property ").append("'").append(difference.get("key")).append("'")
                        .append(" was removed").append("\n");
            } else if (difference.get("condition").equals("added")) {
                result.append("Property ").append("'").append(difference.get("key")).append("'")
                        .append(" was added with value: ").append(valueSelection(difference.get("new value")))
                        .append("\n");
            } else {
                result.append("");
            }
        }
        return result.toString().trim();
    }

    public static String valueSelection(Object value) {
        if (value == null) {
            return "null";
        }

        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        return value.toString();
    }
}
