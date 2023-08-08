package chapter06;

import main.chapter_06.FollowStatus;
import main.chapter_06.ReceiverEndPoint;
import main.chapter_06.SenderEndPoint;
import main.chapter_06.Twootr;
import org.junit.Test;

import java.util.Optional;

import static main.chapter_06.FollowStatus.*;
import static org.junit.Assert.*;

public class TwootrTest {
    private Twootr twootr;
    private SenderEndPoint endPoint;
    private ReceiverEndPoint receiverEndPoint;


    @Test
    public void shouldBeAbleToAuthenticateUser() {
        // 유효 사용자의 로그온 메세지 수신

        // 로그온 메서드는 새 앤트포인트 반환

        // 앤드포인트 유효성을 확인하는 어서션
    }

    @Test
    public void shouldNotAuthenticateUnknownUser() {

    }

    @Test
    public void shouldNotAuthenticateUserWithWrongPassword() {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                TestData.USER_ID, "bad password", receiverEndPoint);

        assertFalse(endPoint.isPresent());
    }

    @Test
    public void shouldFollowValidUser() {
        logon();

        final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);

        assertEquals(SUCCESS, followStatus);
    }

    @Test
    public void shouldNotDuplicateFollowValidUser() {
        logon();

        endPoint.onFollow(TestData.OTHER_USER_ID);

        final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);
        assertEquals(ALREADY_FOLLOWING, followStatus);
    }

    @Test
    public void shouldNotFollowInValidUser() {
        logon();

        final FollowStatus followStatus = endPoint.onFollow(TestData.NOT_A_USER);
        assertEquals(INVALID_USER, followStatus);
    }

    @Test
    public void shouldReceiveTwootsFromFollowedUser() {
        final String id = "1";

        logon();

        endPoint.onFollow(TestData.OTHER_USER_ID);

        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPoint.onSendTwoot(id, TWOOT);

        verify(twootRepository).add(id, TestData.OTHER_USER_ID, TWOOT);
        verify(receiverEndPoint).onTwoot(new Twoot(id, TestData.OTHER_USER_ID, TWOOT, new Position(0)));
    }

    @Test
    public void shouldReceiveeReplayOfTwootsAfterLogoff() {
        final String id = "1";

        userFollowsOtherUser();

        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPoint.onSendTwoot(id, TWOOT);

        logon();

        verify(receiverEndPoint).onTwoot(twootAt(id, POSITION_1));
    }

    private void logon() {
        this.endPoint = logon(TestData.USER_ID, receiverEndPoint);
    }

    private SenderEndPoint logon(final String userId, final ReceiverEndPoint receiverEndPoint) {
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(userId, TestData.PASSWORD, receiverEndPoint);
        assertTrue("Failed to logon", endPoint.isPresent());
        return endPoint.get();
    }
}
