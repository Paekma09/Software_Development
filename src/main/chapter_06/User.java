package main.chapter_06;

import main.chapter_05.Facts;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String id;
    private final byte[] password;
    private final byte[] salt;
    private final Set<User> followers = new HashSet<>();
    private final Set<String> following = new HashSet<>();

    private ReceiverEndPoint receiverEndPoint;

    public User(final String id, final byte[] password, final byte[] salt) {
        this.id = id;
        this.password = password;
        this.salt = salt;
    }

    public String getId() {
        return id;
    }

    public byte[] getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }
}
