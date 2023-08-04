package main.chapter_02;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class OverSpecificBankStatementValidator {

    private String description;
    private String date;
    private String amount;

    public OverSpecificBankStatementValidator(String description, String date, String amount) {
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    // 과도하게 세밀한 예외
//    public boolean validate() throws DescriptionTooLongException, InvalidDateFormat, DateInTheFutureException, InvaidAmountException {
//        if (this.description.length() > 100) {
//            throw new DescriptionTooLongException();
//        }
//
//        final LocalDate parseDate;
//        try {
//            parseDate = LocalDate.parse(this.date);
//        } catch (DateTimeException e) {
//            throw new InvalidDateFormat();
//        }
//
//        if (parseDate.isAfter(LocalDate.now())) throw new DateInTheFutureException();
//
//        try {
//            Double.parseDouble(this.amount);
//        } catch (NumberFormatException e) {
//            throw new InvalidAmountException();
//        }
//        return true;
//    }

    // 모든 곳에 IllegalArgument 예외 사용
//    public boolean validate() {
//
//        if (this.description.length() > 100) {
//            throw new IllegalArgumentException("The description is too long");
//        }
//
//        final LocalDate parseDate;
//        try {
//            parseDate = LocalDate.parse(this.date);
//        } catch (Exception e) {
//            throw new IllegalArgumentException("Invalid format for date", e);
//        }
//        if (parseDate.isAfter(LocalDate.now())) throw new IllegalArgumentException("date cannot be in the future");
//
//        try {
//            Double.parseDouble(this.amount);
//        } catch (NumberFormatException e) {
//            throw new IllegalArgumentException("Invalid format for amount", e);
//        }
//
//        return true;
//    }

    // 노티피케이션 패턴
    public Notification validate() {

        final Notification notification = new Notification();
        if (this.description.length() > 100) {
            notification.addError("The description is too long");
        }

        final LocalDate parseDate;
        try {
            parseDate = LocalDate.parse(this.date);
            if (parseDate.isAfter(LocalDate.now())) {
                notification.addError("date cannot be in the future");
            }
        } catch (DateTimeParseException e) {
            notification.addError("Invalid format for date");
        }

        final double amount;
        try {
            amount = Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            notification.addError("Invalid format for amount");
        }

        return notification;
    }
}
