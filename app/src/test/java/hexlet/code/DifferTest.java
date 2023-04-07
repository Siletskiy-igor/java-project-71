package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void differStylishTest() throws Exception {
        String expected = "{\n" + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none"
                + "\n}";
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json"));
    }

    @Test
    public void differPlainTest() throws Exception {
        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json", "plain"));
    }

    @Test
    public void differJsonTest() throws Exception {
        String expected = "["
                + "{\"condition\":\"not changed\","
                + "\"old value\":[\"a\",\"b\",\"c\"],"
                + "\"new value\":[\"a\",\"b\",\"c\"],"
                + "\"key\":\"chars1\"},"
                + "{\"condition\":\"modified\","
                + "\"old value\":[\"d\",\"e\",\"f\"],"
                + "\"new value\":false,"
                + "\"key\":\"chars2\"},"
                + "{\"condition\":\"modified\","
                + "\"old value\":false,"
                + "\"new value\":true,"
                + "\"key\":\"checked\"},"
                + "{\"condition\":\"modified\","
                + "\"old value\":null,"
                + "\"new value\":[\"value1\",\"value2\"],"
                + "\"key\":\"default\"},"
                + "{\"condition\":\"modified\","
                + "\"old value\":45,"
                + "\"new value\":null,"
                + "\"key\":\"id\"},"
                + "{\"condition\":\"deleted\","
                + "\"old value\":\"value1\","
                + "\"key\":\"key1\"},"
                + "{\"condition\":\"added\","
                + "\"new value\":\"value2\","
                + "\"key\":\"key2\"},"
                + "{\"condition\":\"not changed\","
                + "\"old value\":[1,2,3,4],"
                + "\"new value\":[1,2,3,4],"
                + "\"key\":\"numbers1\"},"
                + "{\"condition\":\"modified\","
                + "\"old value\":[2,3,4,5],"
                + "\"new value\":[22,33,44,55],"
                + "\"key\":\"numbers2\"},"
                + "{\"condition\":\"deleted\","
                + "\"old value\":[3,4,5],"
                + "\"key\":\"numbers3\"},"
                + "{\"condition\":\"added\","
                + "\"new value\":[4,5,6],"
                + "\"key\":\"numbers4\"},"
                + "{\"condition\":\"added\","
                + "\"new value\":{\"nestedKey\":\"value\",\"isNested\":true},"
                + "\"key\":\"obj1\"},"
                + "{\"condition\":\"modified\","
                + "\"old value\":\"Some value\","
                + "\"new value\":\"Another value\","
                + "\"key\":\"setting1\"},"
                + "{\"condition\":\"modified\","
                + "\"old value\":200,"
                + "\"new value\":300,"
                + "\"key\":\"setting2\"},"
                + "{\"condition\":\"modified\","
                + "\"old value\":true,"
                + "\"new value\":\"none\","
                + "\"key\":\"setting3\"}"
                + "]";
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json", "json"));
    }
}
