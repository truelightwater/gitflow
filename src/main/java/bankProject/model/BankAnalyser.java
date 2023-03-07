package bankProject.model;

import bankProject.data.csvParser;
import bankProject.service.BankService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankAnalyser {

    private static final String RESOURCE = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/bank-simple-data.csv";

    public static void main(String[] args) throws IOException {

        // 파일 입출력
        Path path = Paths.get(RESOURCE);
        List<String> lines = Files.readAllLines(path);

        // 데이터 파싱 : csvParser
        csvParser csvParser = new csvParser();
        List<BankTransaction> bankTransactions = csvParser.parseLineFormCSV(lines);
        BankService bankService = new BankService(bankTransactions);

        bankService.calculateTotalAmount();
    }

}
