package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command (name = "gendiff", description = "Compares two configuration files and shows a difference.")
public class App {
    @Option (names = {"-h", "--help"}, description = "Show this help message and exit.")
    private boolean helpRequested = false;
    @Option(names = {"-V", "--version"}, description = "Print version information and exit.")
    boolean version;

    public static void main(String[] args) {
        new CommandLine(new App()).usage(System.out);
    }
}
