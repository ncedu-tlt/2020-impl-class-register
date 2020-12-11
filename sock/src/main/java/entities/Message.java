package entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private String name; //who
    private String text; //what
}
