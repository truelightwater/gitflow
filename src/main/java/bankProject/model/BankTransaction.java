package bankProject.model;

import java.time.LocalDate;

public class BankTransaction {

    private LocalDate date;
    private String id;
    private int amount;
    private String info;

    public BankTransaction(String id, LocalDate date, int amount, String info) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", info='" + info + '\'' +
                '}';
    }

}
