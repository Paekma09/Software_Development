package main.chapter_06;

import java.util.Optional;

public class Twootr {
    // onLogon 초기 버전 시그니처
    //SenderEndPoint onLogon(String userId, ReceiverEndPoint receiver);


    // 두 번째 onLogon 시그니처
    public Optional<SenderEndPoint> onLogon(String userId, String password, ReceiverEndPoint receiver) {
        return null;
    }

    public Optional<SenderEndPoint> onFollow(User user, String userId) {
        return null;
    }



}
