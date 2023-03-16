package bankProject.service;

import bankProject.data.Parser;
import bankProject.export.Exporter;
import bankProject.export.SummaryStatistics;
import bankProject.model.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankAnalyzer {

    private static final String RESOURCE = "/Users/kuosamo/Documents/STUDY/gitflow/src/main/resources/";

    public void analyze(String fileName, Parser parser, Exporter exporter) throws IOException {

        // 파일 입출력
        Path path = Paths.get(RESOURCE + fileName);
        List<String> lines = null;
        lines = Files.readAllLines(path);

        // 데이터 파싱
        List<BankTransaction> bankTransactions = parser.parseLineFrom(lines);

        // 입출금 처리 로직
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

        /* 별도의 클래스를 만들지 않고, 람다 표현식으로 이름없이 인터페이스 구현 객체를 코드 블록형태로 전달 */
        bankService.findTransactions(bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() > 500000);

        SummaryStatistics summaryStatistics = bankService.summaryTransaction();

        System.out.println(exporter.export(summaryStatistics));

    }

}
