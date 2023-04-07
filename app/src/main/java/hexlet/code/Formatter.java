package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getFomatter(List<Map<String, Object>> dataDiff, String formatName) throws Exception {
        if (formatName.equals("plain")) {
            return Plain.plain(dataDiff);
        } else if (formatName.equals("json")) {
            return Json.json(dataDiff);
        } else {
            return Stylish.stylish(dataDiff);
        }
    }

}
