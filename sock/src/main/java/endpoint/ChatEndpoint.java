package endpoint;

import coders.MessageDecoder;
import coders.MessageEncoder;
import entities.Message;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@ServerEndpoint(value = "/chat", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class})
public class ChatEndpoint {

    private Session session = null;
    private static List<Session> sessionList = new LinkedList<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        sessionList.add(session);
    }

    @OnClose
    public void onColose(Session session) {
        sessionList.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, Message msg) {
        sessionList.forEach(s -> {
            if (s == this.session) {
                return; // don't send if this is our session
            } else {
                try {
                    s.getBasicRemote().sendObject(msg); // send an object
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}





