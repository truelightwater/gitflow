package bankProjectTest;

import bankProject.data.CsvParser;
import bankProject.data.Parser;
import bankProject.model.BankTransaction;
import bankProject.service.BankService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BankServiceTest {

    BankService readFile() throws IOException {
        Parser parser = new CsvParser();
        File relativePath = new File("./src/main/resources/bank-simple-data.csv");
        Path path = Paths.get(relativePath.toURI());
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = parser.parseLineFrom(lines);
        BankService bankService = new BankService(bankTransactions);

        return bankService;
    }

    @Test
    void totalAmountTest() throws IOException {
        BankService bankService = readFile();

        String[] strArr3 = {"식료품", "커피", "서점"};
        String[] strArr1 = {"식료품"};
        List<String> result3 = new ArrayList<>(Arrays.asList(strArr3));
        List<String> result1 = new ArrayList<>(Arrays.asList(strArr1));

        assertThat(bankService.totalAmount()).isEqualTo(6081000);
        assertThat(bankService.incomeAmount()).isEqualTo(6240000);
        assertThat(bankService.expenseAmount()).isEqualTo(-159000);
        assertThat(bankService.monthlyAmount(Month.JANUARY)).isEqualTo(-117000);
        assertThat(bankService.monthlyIncome(Month.FEBRUARY)).isEqualTo(6240000);
        assertThat(bankService.monthlyExpense(Month.FEBRUARY)).isEqualTo(-37000);
        assertThat(bankService.categoryAmount("커피")).isEqualTo(-34000);
        assertThat(bankService.monthlyCountAmount(Month.FEBRUARY)).isEqualTo(6);
        assertThat(bankService.topExpenseAmount(3)).isEqualTo(result1);

    }

}
