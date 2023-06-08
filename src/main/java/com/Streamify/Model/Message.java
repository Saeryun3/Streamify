package com.Streamify.Model;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {
    private String senderName;
    private String recieverName;
    private String message;
    private String date;
    private Status status;
}

