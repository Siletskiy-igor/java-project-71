package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getFomatter(List<Map<String, Object>> dataDiff, String formatName) {
        if (formatName.equals("plain")) {
            return Plain.plain(dataDiff);
        } else {
            return Stylish.stylish(dataDiff);
        }
    }

}
