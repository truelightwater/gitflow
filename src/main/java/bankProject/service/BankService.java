package bankProject.service;

import bankProject.model.BankTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class BankService {

    private List<BankTransaction> bankTransactions;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public BankService(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public int calculateTotalAmount() {
        int total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        // 총 입출금
        log.info(String.valueOf(total));


        List<Integer> collect = bankTransactions.stream()
                .filter(amount -> amount.getAmount() > 0)
                .map(BankTransaction::getAmount)
                .collect(Collectors.toList());

        System.out.println(collect);


        return total;
    }

    public void IncomeExpenseAmount() {

        int income = 0;
        int expense = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (0 < bankTransaction.getAmount()) {
                income += bankTransaction.getAmount();
            } else {
                expense += bankTransaction.getAmount();
            }
        }

        // 총 수입과 총 지출
        log.info(String.valueOf(income));
        log.info(String.valueOf(expense));

    }

    public int MonthlyAmount(Month month) {
        int total = 0;

        for (BankTransaction bankTransaction : bankTransactions) {
            if (month == bankTransaction.getDate().getMonth()) {
                total += bankTransaction.getAmount();
            } else if (month == bankTransaction.getDate().getMonth()) {
                total += bankTransaction.getAmount();
            } else if (month == bankTransaction.getDate().getMonth()) {
                total += bankTransaction.getAmount();
            }
        }

        // 각 개월마다의 총합
        log.info(String.valueOf(total));

        return total;
    }

    public int CategoryAmount(String msg) {
        int total = 0;

        for (BankTransaction bankTransaction : bankTransactions) {

            if (msg.equals(bankTransaction.getInfo())) {
                total += bankTransaction.getAmount();
            }
        }

        // 카테고리별 총 입출금
        log.info(String.valueOf(total));

        return total;
    }

    public int MonthlyCountAmount(Month month) {
        int count = 0;

        for (BankTransaction bankTransaction : bankTransactions) {
            if (month == bankTransaction.getDate().getMonth()) {
                count++;
            }
        }

        // 각 개월마다의 입출금 횟수
        log.info(String.valueOf(count));

        return count;
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
