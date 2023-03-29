package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

@Command (name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private File file1;

    @CommandLine.Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private File file2;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "display version info")
    boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "display this @|fg(blue) help|@ message")
    boolean usageHelpRequested;

    @Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format [default: ${DEFAULT-VALUE}]", paramLabel = "format")
    String format;

    @Override
    public Integer call() throws Exception {
//        byte[] fileContents = Files.readAllBytes(help.toPath());
//        byte[] digest = MessageDigest.getInstance(version).digest(fileContents);
//        System.out.printf("%0" + (digest.length*2) + "x%n", new BigInteger(1, digest));
        return 0;
    }
    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new App());
        commandLine.parseArgs(args);
        if (commandLine.isUsageHelpRequested()) {
            commandLine.usage(System.out);
            return;
        } else if (commandLine.isVersionHelpRequested()) {
            commandLine.printVersionHelp(System.out);
            return;
        }
    }
}
