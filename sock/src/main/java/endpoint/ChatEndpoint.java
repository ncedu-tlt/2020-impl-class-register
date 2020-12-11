package endpoint;

import coders.MessageDecoder;
import coders.MessageEncoder;
import entities.Message;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@ServerEndpoint(value = "/chat/{user}", encoders = {MessageEncoder.class}, decoders = {MessageDecoder.class})
public class ChatEndpoint {

    private Session session = null;
    private String username = "anon";
    private static List<Session> sessionList = new LinkedList<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("user") String username) {
        this.session = session;
        this.username = username;
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
        msg.setName(this.username);
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





