package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DifferenceData {
    public static List<Map<String, Object>> getDifferenceData(Map<String, Object> data1, Map<String, Object> data2)  {
        List<Map<String, Object>> dataDiff = new ArrayList<>();
        Set<String> combiningSetsOfKeys = new TreeSet<>(data1.keySet());

        combiningSetsOfKeys.addAll(data2.keySet());

        for (String key: combiningSetsOfKeys) {
            Map<String, Object> currentMap = new HashMap<>();

            if ((data1.containsKey(key) && data2.containsKey(key)) && !Objects.equals(data1.get(key), data2.get(key))) {
                currentMap.put("key", key);
                currentMap.put("old value", data1.get(key));
                currentMap.put("new value", data2.get(key));
                currentMap.put("condition", "modified");
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                currentMap.put("key", key);
                currentMap.put("old value", data1.get(key));
                currentMap.put("condition", "deleted");
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                currentMap.put("key", key);
                currentMap.put("new value", data2.get(key));
                currentMap.put("condition", "added");
            } else {
                currentMap.put("key", key);
                currentMap.put("old value", data1.get(key));
                currentMap.put("condition", "not changed");
            }
            dataDiff.add(currentMap);
        }
        return dataDiff;
    }
}
