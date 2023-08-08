package chapter06;

import main.chapter_06.ReceiverEndPoint;
import main.chapter_06.Twoot;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class MockReceiverEndPoint implements ReceiverEndPoint {
    private final List<Twoot> receiverTwoots = new ArrayList<>();

    @Override
    public void onTwoot(final Twoot twoot) {
            receiverTwoots.add(twoot);
    }

    public void verifyOnTwoot(final Twoot twoot) {
        assertThat(receiverTwoots, contains(twoot));
    }
}
