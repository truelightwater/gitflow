public class Information {
    private String id;
    private String date;
    private int amount;
    private String info;

    public Information(String id, String date, int amount, String info) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
        return "information{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", info='" + info + '\'' +
                '}';
    }

}
