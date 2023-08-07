package chapter06;

import main.chapter_06.KeyGenerator;

public class TestData {
    static final String USER_ID = "paekma09";
    static final String OTHER_USER_ID = "chubss";
    static final String NOT_A_USER = "KJ";

    static final byte[] SALT = KeyGenerator.newSalt();
    static final String PASSWORD = "ahc5ez";
    static final byte[] PASSWORD_BYTES = KeyGenerator.hash(PASSWORD, SALT);

}
