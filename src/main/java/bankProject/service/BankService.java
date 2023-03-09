package bankProject.service;

import bankProject.model.BankTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Month;
import java.util.*;

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

    public String TopExpenseAmount() {
        Map<String, Integer> listMap = new HashMap<>();

        for (BankTransaction bankTransaction : bankTransactions) {
            if (0 > bankTransaction.getAmount()) {
                listMap.put(bankTransaction.getInfo(), null);
            }
        }

        int groceryTotal = 0;
        int storeTotal = 0;
        int bookTotal = 0;
        int coffeeTotal = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            if (0 > bankTransaction.getAmount()) {

                if (bankTransaction.getInfo().equals("식료품")) {

                    groceryTotal += bankTransaction.getAmount();
                    listMap.put(bankTransaction.getInfo(), groceryTotal);

                } else if (bankTransaction.getInfo().equals("편의점")) {
                    storeTotal += bankTransaction.getAmount();
                    listMap.put(bankTransaction.getInfo(), storeTotal);

                } else if (bankTransaction.getInfo().equals("서점")) {
                    bookTotal += bankTransaction.getAmount();
                    listMap.put(bankTransaction.getInfo(), bookTotal);

                } else if (bankTransaction.getInfo().equals("커피")) {
                    coffeeTotal += bankTransaction.getAmount();
                    listMap.put(bankTransaction.getInfo(), coffeeTotal);

                }
            }
        }

        String minKey = null;
        for (String key : listMap.keySet()) {
            if (minKey == null || listMap.get(key) < listMap.get(minKey)) {
                minKey = key;
            }
        }

        log.info(minKey);

        return minKey;
    }
}
