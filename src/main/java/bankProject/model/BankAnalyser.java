package bankProject.model;

import bankProject.data.csvParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankAnalyser {

    private static final String RESOURCE = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";

    public static int calculateTotalAmount(List<BankTransaction> bankTransactions) {
        int total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    public static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
        List<BankTransaction> bankTransactionInMonth = new ArrayList<>();

        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionInMonth.add(bankTransaction);
            }
        }

        return bankTransactionInMonth;
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(RESOURCE);
        List<String> lines = Files.readAllLines(path);

        csvParser csvParser = new csvParser();
        List<BankTransaction> bankTransactions = csvParser.parseLineFormCSV(lines);

        System.out.println(calculateTotalAmount(bankTransactions));
        System.out.println(selectInMonth(bankTransactions, Month.JANUARY));


    }
}
