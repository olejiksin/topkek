package kurs.models;


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
@Table(name = "tokens")
public class Token {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String value;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usver usver;


    private LocalDateTime createdAt;

    private LocalDateTime expiredDateTime;

}
