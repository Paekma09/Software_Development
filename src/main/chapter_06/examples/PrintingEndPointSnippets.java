package main.chapter_06.examples;

import main.chapter_06.ReceiverEndPoint;
import main.chapter_06.Twoot;

public class PrintingEndPointSnippets {
    public static void main(String[] args) {

        // 익명 클래스로 ReceiverEndPoint 구현
        final ReceiverEndPoint anonymousClass = new ReceiverEndPoint() {
            @Override
            public void onTwoot(Twoot twoot) {
                System.out.println(twoot.getSenderId() + ": " + twoot.getContent());
            }
        };

        // 람다 표현식으로 ReceiverEndPoint 구현
        final ReceiverEndPoint lambda =
                twoot -> System.out.println(twoot.getSenderId() + ": " + twoot.getContent());
    }
}
