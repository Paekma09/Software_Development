package test.java.chapter02;

import main.java.chapter_02.BankStatementCSVParser;
import main.java.chapter_02.BankStatementParser;

import main.java.chapter_02.BankTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCSVParser();

    // Assert.fail 예제
//    @Test
//    public void shouldParseOneCorrectLine() throws Exception {
//        Assert.fail("Not yet implemented");   // 메서드 실행 결과를 실패로 만듦, 테스트 코드를 구현하기 전에 플레이스홀더로 유용하게 활용 가능
//    }

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());  //두 값이 같은지 테스트
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);   //두 float 이나 double 이 delta 범위 내에서 같은지 테스트
        Assert.assertEquals(expected.getDescription(), result.getDescription());
        // Assert.assertNotNull(object) ---> 객체가 null 이 아닌지 테스트
    }
}
