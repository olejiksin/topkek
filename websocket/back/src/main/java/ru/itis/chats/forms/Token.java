package ru.itis.chats.forms;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "token")
public class Token {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String token;



    private LocalDateTime created;

    private LocalDateTime expired;


}