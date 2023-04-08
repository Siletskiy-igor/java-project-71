package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class Plain {
    public static String plain(List<Map<String, Object>> dataDiff) {
        StringBuilder outputInPlainFormat = new StringBuilder();

        for (Map<String, Object> difference: dataDiff) {
            if (difference.get("condition").equals("modified")) {
                outputInPlainFormat.append("Property ").append("'").append(difference.get("key"))
                        .append("'").append(" was updated. From ").append(valueSelection(difference.get("old value")))
                        .append(" to ").append(valueSelection(difference.get("new value"))).append("\n");
            } else if (difference.get("condition").equals("deleted")) {
                outputInPlainFormat.append("Property ").append("'").append(difference.get("key")).append("'")
                        .append(" was removed").append("\n");
            } else if (difference.get("condition").equals("added")) {
                outputInPlainFormat.append("Property ").append("'").append(difference.get("key")).append("'")
                        .append(" was added with value: ").append(valueSelection(difference.get("new value")))
                        .append("\n");
            } else {
                outputInPlainFormat.append("");
            }
        }
        return outputInPlainFormat.toString().trim();
    }

    public static String valueSelection(Object value) {
        if (value == null) {
            return null;
        } else if (value.getClass() == LinkedHashMap.class
                || value.getClass() == Arrays.class
                || value.getClass() == ArrayList.class) {
            return "[complex value]";
        } else if (value.getClass() == String.class) {
            return "'" + value + "'";
        }
        return value.toString();
    }
}
