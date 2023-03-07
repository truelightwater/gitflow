package bankProject.service;

import bankProject.model.BankTransaction;
import java.util.List;

public class BankService {

    private List<BankTransaction> bankTransactions;

    public BankService(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public int calculateTotalAmount() {
        int total = 0;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        System.out.println(total);

        return total;
    }


}
