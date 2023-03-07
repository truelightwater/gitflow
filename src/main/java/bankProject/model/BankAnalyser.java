package bankProject.model;

import bankProject.data.Parser;
import bankProject.data.TsvParser;
import bankProject.service.BankService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankAnalyser {

    private static final String RESOURCE = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/";

    public static void main(String[] args) throws IOException {

        // 파일 입출력
        Path path = Paths.get(RESOURCE + "bank-simple-data.tsv");
        List<String> lines = Files.readAllLines(path);

        // 데이터 파싱 : csvParser
//        CsvParser csvParser = new CsvParser();
//        List<BankTransaction> bankTransactions = csvParser.parseLineFrom(lines);
//        BankService bankService = new BankService(bankTransactions);
//
//        bankService.calculateTotalAmount();

        // 데이터 파싱 : tsvParser
        Parser parser = new TsvParser();
        List<BankTransaction> bankTransactions = parser.parseLineFrom(lines);
        BankService bankService = new BankService(bankTransactions);

        bankService.calculateTotalAmount();
    }

}
