package chapter03;

import main.chapter_02.BankStatementProcessor;
import main.chapter_02.BankTransaction;
import main.chapter_02.BankTransactionFilter;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankStatementProcessorTest {

    @Test
    public void shouldFilterTransactionsInFebruary() {

        final BankTransaction februarySalary = new BankTransaction(LocalDate.of(2019, Month.FEBRUARY, 14), 2_000, "Salary");
        final BankTransaction marchRoyalties = new BankTransaction(LocalDate.of(2019, Month.MARCH, 20), 500, "Royalties");

        final List<BankTransaction> bankTransactions = List.of(februarySalary, marchRoyalties);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

//        final List<BankTransaction> transactions = bankStatementProcessor.findTransaction(new BankTransactionIsInFebruayAndExpensive());

        // 람다 표현식으로 BankTransactionFilter 구현하기
        final List<BankTransaction> transactions = bankStatementProcessor.findTransactions(bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000);
    }

    class BankTransactionIsInFebruayAndExpensive implements BankTransactionFilter {

        @Override
        public boolean test(final BankTransaction bankTransaction) {
            return bankTransaction.getDate().getMonth() == Month.FEBRUARY && bankTransaction.getAmount() >= 1_000;
        }
    }
}
