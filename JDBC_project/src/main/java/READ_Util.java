import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class READ_Util {
    private final String csvFile = "C:\\Users\\asecu\\Desktop\\data.csv";
    private String line = "";
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';


    List<String> read() throws IOException {
        Scanner scanner = new Scanner(new File(csvFile));

        List<String> rows = new ArrayList<String>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            rows.add(line);
        }
        scanner.close();
        return rows;
    }

}
