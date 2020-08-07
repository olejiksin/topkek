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
@Table(name = "web_mes")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String message;
    @Column
    private String usver;
}
