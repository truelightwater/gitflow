package bankProject.service;

import bankProject.data.Parser;
import bankProject.model.BankTransaction;
import bankProject.service.BankService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankAnalyzer {

    private static final String RESOURCE = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/";

    public void analyze(String fileName, Parser parser) {

        // 파일 입출력
        Path path = Paths.get(RESOURCE + fileName);
        List<String> lines = null;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 데이터 파싱
        List<BankTransaction> bankTransactions = parser.parseLineFrom(lines);

        // 입출금 총합
        BankService bankService = new BankService(bankTransactions);

        // 결과
        bankService.totalAmount();
        bankService.IncomeAmount();
        bankService.ExpenseAmount();
        bankService.MonthlyAmount(Month.JANUARY);
        bankService.CategoryAmount("커피");
        bankService.MonthlyCountAmount(Month.FEBRUARY);
        bankService.TopThreeExpenseAmount();
        bankService.TopExpenseAmount();

    }

}
