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
    public void differStylishTest() throws Exception {
        String expected = resultStylish;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json"));
    }

    @Test
    public void differPlainTest() throws Exception {
        String expected = resultPlain;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json", "plain"));
    }

    @Test
    public void differJsonTest() throws Exception {
        String expected = resultJson;
        assertEquals(expected, Differ.generate("src/test/resources/filepath1.json",
                "src/test/resources/filepath2.json", "json"));
    }
}
