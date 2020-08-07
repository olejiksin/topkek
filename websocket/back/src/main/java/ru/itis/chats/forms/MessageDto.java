package ru.itis.chats.forms;

import lombok.Data;

@Data
public class MessageDto {
    private String from;
    private String text;
    private String token;
}
