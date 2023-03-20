package bankProject.service;

import bankProject.export.SummaryStatistics;
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

    // 총 입금, 출금 내역
    public int totalAmount() {
        int total = bankTransactions.stream()
                                     .mapToInt(BankTransaction::getAmount)
                                     .sum();

        log.info(String.valueOf(total));

        return total;
    }

    // 총 수입 내역
    public void incomeAmount() {
        int income = bankTransactions.stream()
                                     .filter(amount -> amount.getAmount() > 0)
                                     .mapToInt(BankTransaction::getAmount)
                                     .sum();

        log.info(String.valueOf(income));

    }

    // 총 지출 내역
    public void expenseAmount() {
        int expense = bankTransactions.stream()
                .filter(amount -> amount.getAmount() < 0)
                .mapToInt(BankTransaction::getAmount)
                .sum();

        log.info(String.valueOf(expense));
    }

    // 각 개월마다의 총합
    public int monthlyAmount(Month month) {

        if (month == null) {
            throw new NullPointerException("month should not be null");
        }

        int monthlyTotal = bankTransactions.stream()
                                            .filter(monthlyAmount -> monthlyAmount.getDate().getMonth() == month)
                                            .mapToInt(BankTransaction::getAmount)
                                            .sum();
        log.info(String.valueOf(monthlyTotal));

        return monthlyTotal;
    }

    // 각 개월의 수익금
    public int monthlyIncome(Month month) {
        if (month == null) {
            throw new NullPointerException("month should not be null");
        }

        int monthlyIncomeAmount = bankTransactions.stream()
                .filter(monthIncomeAmount -> monthIncomeAmount.getDate().getMonth() == month)
                .mapToInt(BankTransaction::getAmount)
                .filter(amount -> amount > 0)
                .sum();

        log.info(String.valueOf(monthlyIncomeAmount));

        return monthlyIncomeAmount;
    }

    // 각 개월의 지출금
    public int monthlyExpense(Month month) {
        if (month == null) {
            throw new NullPointerException("month should not be null");
        }

        int monthlyExpenseAmount = bankTransactions.stream()
                .filter(monthIncomeAmount -> monthIncomeAmount.getDate().getMonth() == month)
                .mapToInt(BankTransaction::getAmount)
                .filter(amount -> amount < 0)
                .sum();

        log.info(String.valueOf(monthlyExpenseAmount));

        return monthlyExpenseAmount;
    }

    // 카테고리별 총 입출금
    public int categoryAmount(String msg) {

        Integer categoryTotal = bankTransactions.stream()
                .filter(infoAmount -> infoAmount.getInfo().equals(msg))
                .map(BankTransaction::getAmount)
                .reduce(0, Integer::sum);

        log.info(String.valueOf(categoryTotal));

        return categoryTotal;
    }

    // 각 개월마다의 입출금 횟수
    public long monthlyCountAmount(Month month) {

        long monthlyCountTotal = bankTransactions.stream()
                .filter(monthlyCount -> monthlyCount.getDate().getMonth() == month)
                .map(BankTransaction::getId).count();

        log.info(String.valueOf(monthlyCountTotal));

        return monthlyCountTotal;
    }

    // 지출이 높은 상위 3건
    public List<String> topThreeExpenseAmount() {
        List<String> result = bankTransactions.stream()
                .filter(amount -> amount.getAmount() < 0)
                .sorted(Comparator.comparing(BankTransaction::getAmount))
                .map(BankTransaction::getInfo)
                .limit(3)
                .collect(Collectors.toList());

        log.info(result.toString());

        return result;
    }

    // 지출이 가장 많은 항목
    public List<String> topExpenseAmount() {

        List<String> result = bankTransactions.stream()
                .filter(amount -> amount.getAmount() < 0)
                .sorted(Comparator.comparing(BankTransaction::getAmount))
                .map(BankTransaction::getInfo)
                .limit(1)
                .collect(Collectors.toList());

        log.info(result.toString());

        return result;
    }

    // 특정 개월의 금액 이상의 은행거래
    public List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter) {

        List<BankTransaction> result = new ArrayList<>();

        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }

        log.info(result.toString());

        return result;
    }

    // 기본적인 통계내용 요약
    public SummaryStatistics summaryTransaction() {

        final IntSummaryStatistics intSummaryStatistics = bankTransactions.stream()
                .mapToInt(BankTransaction::getAmount)
                .summaryStatistics();


        log.info(String.valueOf(intSummaryStatistics.getSum()));
        log.info(String.valueOf(intSummaryStatistics.getMax()));
        log.info(String.valueOf(intSummaryStatistics.getMin()));
        log.info(String.valueOf(intSummaryStatistics.getAverage()));



        return new SummaryStatistics(intSummaryStatistics.getSum(),
                intSummaryStatistics.getMax(),
                intSummaryStatistics.getMin(),
                intSummaryStatistics.getAverage());
    }




}
