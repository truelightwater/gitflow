package bankProject.notification;

import bankProject.notification.exceptions.InvalidAmountException;
import bankProject.notification.exceptions.InvalidDateFormat;
import bankProject.notification.exceptions.InfoToolongException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class OverlyBankStatementValidator {
    private String amount;
    private String date;
    private String info;

    public OverlyBankStatementValidator(String amount, String date, String info) {
        this.amount = Objects.requireNonNull(amount);
        this.date = Objects.requireNonNull(date);
        this.info = Objects.requireNonNull(info);
    }

    public boolean validate() throws InfoToolongException, InvalidDateFormat, InvalidAmountException {

        if (this.info.length() > 100) {
            throw new InfoToolongException();
        }

        final LocalDate parseDate;
        try {
            parseDate = LocalDate.parse(this.date);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormat();
        }

        try {
            Integer.parseInt(this.amount);
        } catch (NumberFormatException e) {
            throw new InvalidAmountException();
        }

        return true;
    }
}
