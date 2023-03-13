package bankProject.service;

import bankProject.model.BankTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {

    private List<BankTransaction> bankTransactions;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public BankService(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public int totalAmount() {
        Integer total = bankTransactions.stream()
                .map(BankTransaction::getAmount)
                .reduce(0, Integer::sum);

        // 총 입출금
        log.info(String.valueOf(total));

        return total;
    }

    public void IncomeAmount() {

        Integer income = bankTransactions.stream()
                .filter(amount -> amount.getAmount() > 0)
                .map(BankTransaction::getAmount)
                .reduce(0, Integer::sum);

        // 총 수입
        log.info(String.valueOf(income));

    }

    public void ExpenseAmount() {
        Integer expense = bankTransactions.stream()
                .filter(amount -> amount.getAmount() < 0)
                .map(BankTransaction::getAmount)
                .reduce(0, Integer::sum);

        // 총 지출
        log.info(String.valueOf(expense));
    }

    public int MonthlyAmount(Month month) {

        Integer monthlyTotal = bankTransactions.stream()
                .filter(monthlyAmount -> monthlyAmount.getDate().getMonth() == month)
                .map(BankTransaction::getAmount)
                .reduce(0, Integer::sum);

        // 각 개월마다의 총합
        log.info(String.valueOf(monthlyTotal));
        return monthlyTotal;
    }

    public int CategoryAmount(String msg) {

        Integer categoryTotal = bankTransactions.stream()
                .filter(infoAmount -> infoAmount.getInfo().equals(msg))
                .map(BankTransaction::getAmount)
                .reduce(0, Integer::sum);

        // 카테고리별 총 입출금
        log.info(String.valueOf(categoryTotal));

        return categoryTotal;
    }

    public long MonthlyCountAmount(Month month) {

        long monthlyCountTotal = bankTransactions.stream()
                .filter(monthlyCount -> monthlyCount.getDate().getMonth() == month)
                .map(BankTransaction::getId).count();

        // 각 개월마다의 입출금 횟수
        log.info(String.valueOf(monthlyCountTotal));

        return monthlyCountTotal;
    }

    public List<String> TopThreeExpenseAmount() {
        List<String> result = bankTransactions.stream()
                .filter(amount -> amount.getAmount() < 0)
                .sorted(Comparator.comparing(BankTransaction::getAmount))
                .map(BankTransaction::getInfo)
                .limit(3)
                .collect(Collectors.toList());

        // 지출이 높은 상위 3위
        log.info(result.toString());

        return result;
    }

    public List<String> TopExpenseAmount() {

        List<String> result = bankTransactions.stream()
                .filter(amount -> amount.getAmount() < 0)
                .sorted(Comparator.comparing(BankTransaction::getAmount))
                .map(BankTransaction::getInfo)
                .limit(1)
                .collect(Collectors.toList());

        // 지출이 가장 많은 항목
        log.info(result.toString());

        return result;
    }
}
