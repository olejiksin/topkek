package ru.itis.chats.model;

import lombok.*;

import javax.persistence.*;
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stomp_mes")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private MessageType type;
    @Column
    private String message;
    @Column
    private String usver;
    @Column
    private Integer room;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
