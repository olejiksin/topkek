package ru.itis.chats.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
@Getter
@Setter
public class MessageDto {
    private String from;
    private String text;
    private Integer room;
    private Message.MessageType type;
}
