package chapter02;

import main.chapter_02.BankTransaction;
import main.chapter_02.BankTransactionFilter;
import org.junit.experimental.categories.Category;

import java.time.Month;
import java.util.List;

// 갓 인터페이스
public interface BankTransactionProcessor {
    double calculateTotalAmount();
    double calculateTotalInMonth(Month month);
    double calculateTotalInJanuary();
    double calculateAverageAmount();
    double calculateAverageForCategory(Category category);
    List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter);
}
