package main.java.chapter_02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// 파싱 로직을 추출해 한 클래슬로 만듦
public class BankStatementCSVParser implements BankStatementParser{

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

//    private BankTransaction parseFromCSV(final String line) {
//        final String[] columns = line.split(",");
//
//        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
//        final double amount = Double.parseDouble(columns[1]);
//        final String description = columns[2];
//
//        return new BankTransaction(date, amount, description);
//    }
//
//    public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
//        final List<BankTransaction> bankTransactions = new ArrayList<>();
//        for (final String line : lines) {
//            bankTransactions.add(parseFromCSV(line));
//        }
//        return bankTransactions;
//    }

    @Override
    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(",");


        //문법 예외 던지기
//        if (columns.length < EXPECTED_ATTRIBUTES_LENGTH) {
//            throw new CSVSyntaxException();
//        }

        //예외흫 던지는 대신 null 반환하기
//        if (columns.length < EXPECTED_ATTRIBUTES_LENGTH) {
//            return null;
//        }

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}
