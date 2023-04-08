package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

@Command (name = "gendiff", description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @CommandLine.Parameters(index = "0",
            description = "path to first file",
            paramLabel = "filepath1")
    private String file1;

    @CommandLine.Parameters(index = "1",
            description = "path to second file",
            paramLabel = "filepath2")
    private String file2;

    @Option(names = {"-V", "--version"},
            versionHelp = true,
            description = "display version info")
    private boolean versionInfoRequested;

    @Option(names = {"-h", "--help"},
            usageHelp = true,
            description = "display this @|fg(blue) help|@ message")
    private boolean usageHelpRequested;

    @Option(names = {"-f", "--format"},
            description = "output format: stylish, plain, json [default: ${DEFAULT-VALUE}]",
            defaultValue = "stylish",
            paramLabel = "format")
    private String format;

    @Override
    public  Integer call() throws Exception {
        System.out.println(Differ.generate(file1, file2, format));
        return 0;
    }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
