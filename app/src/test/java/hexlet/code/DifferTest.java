package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
class DifferTest {
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String getFixtureContent(String fileName) throws IOException {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultStylish = getFixtureContent("stylish_fixture.txt");
        resultPlain = getFixtureContent("plain_fixture.txt");
        resultJson = getFixtureContent("json_fixture.json");
    }


    @Test
    public void differJsonDefaultTest() throws Exception {
        String expected = resultStylish;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json"));
    }

    @Test
    public void differYamlDefaultTest() throws Exception {
        String expected = resultStylish;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.yml",
                "src/test/resources/filepath2.yml"));
    }

    @Test
    public void differYamlStylishTest() throws Exception {
        String expected = resultStylish;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.yml",
                "src/test/resources/filepath2.yml", "stylish"));
    }

    @Test
    public void differJsonStylishTest() throws Exception {
        String expected = resultStylish;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json", "stylish"));
    }

    @Test
    public void differJsonPlainTest() throws Exception {
        String expected = resultPlain;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json", "plain"));
    }

    @Test
    public void differYamlPlainTest() throws Exception {
        String expected = resultPlain;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.yml",
                "src/test/resources/filepath2.yml", "plain"));
    }

    @Test
    public void differJsonJsonTest() throws Exception {
        String expected = resultJson;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json", "json"));
    }

    @Test
    public void differYamlJsonTest() throws Exception {
        String expected = resultJson;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.yml",
                "src/test/resources/filepath2.yml", "json"));
    }


}
