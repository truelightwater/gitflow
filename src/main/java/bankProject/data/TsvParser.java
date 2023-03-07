package bankProject.data;

import bankProject.model.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TsvParser implements Parser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public BankTransaction parseFrom(String line) {
        String[] columns = line.split("\t");

        String id = columns[0];
        LocalDate date = LocalDate.parse(columns[1], DATE_PATTERN);
        int amount = Integer.parseInt(columns[2]);
        String info = columns[3];

        return new BankTransaction(id, date, amount, info);
    }

    @Override
    public List<BankTransaction> parseLineFrom(List<String> lines) {
        List<BankTransaction> bankTransactions = new ArrayList<>();

        for (String line : lines) {
            bankTransactions.add(parseFrom(line));
        }

        return bankTransactions;
    }
}
