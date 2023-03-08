package bankProject.notification;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class BankTransactionValidator {

    private String date;
    private String amount;
    private String info;
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankTransactionValidator(String date, String amount, String info) {
        this.date = date;
        this.amount = amount;
        this.info = info;
    }

    public Notification validate() {

        final Notification notification = new Notification();
        final LocalDate parseDate;

        if (this.info.length() > 100) {
            notification.addError("이 정보는 길이가 너무 많습니다.");
        }

        try {
            parseDate = LocalDate.parse(this.date);

            if (parseDate != LocalDate.parse("dd-MM-yyyy")) {
                notification.addError("날짜 형식이 맞지 않습니다.");
            }
        } catch (DateTimeParseException e) {
            notification.addError("유효하지 않은 날짜 형식입니다.");
        }

        try {
            Integer.parseInt(this.amount);
        } catch (NumberFormatException e) {
            notification.addError("유효하지 않은 숫자입니다.");
        }

        return notification;


    }
}
