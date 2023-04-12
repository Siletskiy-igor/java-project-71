package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        String filetype1 = getFiletype(filePath1);
        String filetype2 = getFiletype(filePath2);
        String content1 = getContent(filePath1);
        String content2 = getContent(filePath2);
        Map<String, Object> data1 = Parser.parse(content1, filetype1);
        Map<String, Object> data2 = Parser.parse(content2, filetype2);
        List<Map<String, Object>> dataDiff = DifferenceData.getDifferenceData(data1, data2);

        return Formatter.getFomatter(dataDiff, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String getContent(String possiblePath) throws Exception {
        Path originalPath = Paths.get(possiblePath);
        Path absolutePath = originalPath.toAbsolutePath().normalize();

        if (!Files.exists(absolutePath)) {
            throw new Exception("File '" + absolutePath + " does not exist");
        }
        return Files.readString(absolutePath);
    }

    public static String getFiletype(String filepath) {
        return filepath.substring(filepath.indexOf(".") + 1);
    }


}
