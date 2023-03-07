package bankProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OriginalFile {

    private static final String RESOURCES = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";

    public void totalAmount() throws IOException {
        Path path = Paths.get(RESOURCES);
        List<String> lines = Files.readAllLines(path);

        int total =0;
        for (String line : lines) {
            String[] columns = line.split(",");
            int amount = Integer.parseInt(columns[2]);
            total += amount;
        }

        System.out.println(total);
    }

    public void monthlyAmount() throws IOException {
        Path path = Paths.get(RESOURCES);
        List<String> lines = Files.readAllLines(path);
        DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int total =0;
        for (String line : lines) {
            String[] columns = line.split(",");

            LocalDate date = LocalDate.parse(columns[1], DATE_PATTERN);

            if (date.getMonth() == Month.JANUARY) {
                int amount = Integer.parseInt(columns[2]);
                total += amount;
            }
        }

        System.out.println(total);

    }

    public static void main(String[] args) throws IOException {
        OriginalFile readFile = new OriginalFile();
        readFile.monthlyAmount();
        readFile.totalAmount();
    }

}
