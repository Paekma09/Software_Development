package main.chapter_05;

@FunctionalInterface
public interface Condition {
    boolean evaluation(Facts facts);
}
