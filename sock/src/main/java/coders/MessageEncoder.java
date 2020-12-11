package coders;

import com.google.gson.Gson;
import entities.Message;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

//adapter for encoding/decoding
public class MessageEncoder implements Encoder.Text<Message> {
    private static Gson gson = new Gson();


    @Override
    public String encode(Message message) throws EncodeException {
        return gson.toJson(message);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
