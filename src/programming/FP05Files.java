package programming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Files {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("file.txt"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted() //print in alfabetical order
                .forEach(System.out::println);

        // we can go to the root of the project and get all the files which are presente there
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);

    }
}
