package bankProject.service;

import bankProject.model.BankTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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

        log.info(String.valueOf(total));


        return total;
    }

    public int IncomeAmount() {
        int total = 0;
        for (int i = 0; i < 10; i++) {

        }

        return total;
    }



}
