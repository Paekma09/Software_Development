package main.java.chapter_02;

import java.time.LocalDate;

// 정보 응집 예제
public class BankTransactionDAO {

    public BankTransaction create(final LocalDate date, final double amount, final String description) {
        throw new UnsupportedOperationException();
    }

    public BankTransaction read(final long id) {
        throw new UnsupportedOperationException();
    }

    public BankTransaction update(final long id) {
        throw new UnsupportedOperationException();
    }

    public void delete(final BankTransaction bankTransaction) {
        throw new UnsupportedOperationException();
    }
}
