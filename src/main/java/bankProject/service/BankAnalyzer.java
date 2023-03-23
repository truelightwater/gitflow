package bankProject.service;

import bankProject.data.Parser;
import bankProject.export.Exporter;
import bankProject.export.SummaryStatistics;
import bankProject.model.BankTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankAnalyzer {

    File relativePath = new File("./src/main/resources");
    private final Logger log = LoggerFactory.getLogger(getClass());

    public void analyze(String fileName, Parser parser, Exporter exporter) {

        // 파일 입출력
        Path path = Paths.get(relativePath + fileName);
        List<String> lines = null;

        try {
            lines = Files.readAllLines(path);
        } catch (FileNotFoundException | AccessDeniedException exception) {
            log.error("파일을 찾을 수 없거나 액세스 권한이 없습니다.", exception);
        } catch (IOException e) {
            log.error("파일을 읽을 수 없습니다. ", e);
            throw new RuntimeException(e);
        }

        // 데이터 파싱
        List<BankTransaction> bankTransactions = parser.parseLineFrom(lines);

        // 입출금 처리 로직
        BankService bankService = new BankService(bankTransactions);

        // 결과
        bankService.totalAmount();
        bankService.incomeAmount();
        bankService.expenseAmount();
        bankService.monthlyAmount(Month.JANUARY);
        bankService.monthlyIncome(Month.FEBRUARY);
        bankService.monthlyExpense(Month.FEBRUARY);
        bankService.categoryAmount("커피");
        bankService.monthlyCountAmount(Month.FEBRUARY);
        bankService.topThreeExpenseAmount(3);
        bankService.topExpenseAmount();


        /* 별도의 클래스를 만들지 않고, 람다 표현식으로 이름없이 인터페이스 구현 객체를 코드 블록형태로 전달 */
        bankService.findTransactions(bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() > 500000);

        SummaryStatistics summaryStatistics = bankService.summaryTransaction();

        System.out.println("Html 내보내기 : ");
        System.out.println(exporter.export(summaryStatistics));

    }

}
