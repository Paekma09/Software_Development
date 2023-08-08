package main.chapter_06.examples;

import main.chapter_06.ReceiverEndPoint;
import main.chapter_06.Twoot;

public class PrintingEndPoint implements ReceiverEndPoint {
    @Override
    public void onTwoot(Twoot twoot) {
        System.out.println(twoot.getSenderId() + ": " + twoot.getContent());
    }
}
