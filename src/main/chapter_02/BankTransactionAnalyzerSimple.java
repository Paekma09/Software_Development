package main.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    // 모든 거래 내역의 합 계산하기 (main 매소드)
//    public static void main(String[] args) throws IOException { // CSV 파일을 응용프로그램의 명령줄 인수로 전달해 로딩한다.
//        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");   // Path 클래스는 파일 시스템의 경로
//        final List<String> lines = Files.readAllLines(path);    // 행 목록을 반환 (파일의 모든 행은 가져온다)
//        double total = 0d;
//        for (final String line : lines) {
//            final String[] columns = line.split(",");   // 콤마로 열 분리
//            final double amount = Double.parseDouble(columns[1]);   // 금액 추출
//            total += amount;    // 금액을 double 로 파싱
//        }
//
//        System.out.println("The total for all transactions is " + total);
//    }

    // 1월 입출근 내역 합계 계산하기 (main 메소드)
    public static void main(String[] args) throws IOException { // CSV 파일을 응용프로그램의 명령줄 인수로 전달해 로딩한다.
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");   // Path 클래스는 파일 시스템의 경로
        final List<String> lines = Files.readAllLines(path);    // 행 목록을 반환 (파일의 모든 행은 가져온다)
        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");   // CSV 데이트 포맷 형태 선언
        for (final String line : lines) {
            final String[] columns = line.split(",");   // 콤마로 열 분리
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);   // 금액 추출
                total += amount;    // 금액을 double 로 파싱
            }
        }

        System.out.println("The total for all transactions in January is " + total);
    }
}
