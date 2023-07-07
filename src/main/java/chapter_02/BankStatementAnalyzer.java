package main.java.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

// BankStatementProcessor 클래스를 이용해 입출금 내역 목록 처리
public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
//    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {

        final Path path = Paths.get(RESOURCES + fileName);
        final  List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

//    public static void main(String[] args) throws IOException {
//
//        final String fileName = "bank-data-simple.csv";
//        final Path path = Paths.get(RESOURCES + fileName);
//        final List<String> lines = Files.readAllLines(path);
//
//        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
//        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
//
//        collectSummary(bankStatementProcessor);
//    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());

        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
