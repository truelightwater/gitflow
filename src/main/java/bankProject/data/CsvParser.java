package bankProject.data;

import bankProject.model.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvParser implements Parser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // csvParser 클래스에서만 parseFromCSV 메소드를 활용하기 때문에 접근 제어자는 private 로 지정한다.
    // 한 줄로만 파싱하기 때문에 반복문을 사용해서 list 로 담는다.
    public BankTransaction parseFrom(String line) {
        String[] columns = line.split(",");

        String id = columns[0];
        LocalDate date = LocalDate.parse(columns[1], DATE_PATTERN);
        int amount = Integer.parseInt(columns[2]);
        String info = columns[3];

        return new BankTransaction(id, date, amount, info);
    }


    // 한 줄씩 파싱하고 난 뒤에 list 에 추가한다.
    public List<BankTransaction> parseLineFrom(List<String> lines) {
        List<BankTransaction> bankTransactions = new ArrayList<>();

        for (String line : lines) {
            bankTransactions.add(parseFrom(line));
        }

        return bankTransactions;
    }
}
