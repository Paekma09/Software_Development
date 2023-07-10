package main.java.chapter_02;

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
