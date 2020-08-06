package com.example.chet.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "usvers")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String usvername;
    @Column
    private String hash;
    @Column
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usver", cascade = CascadeType.ALL)
    private List<Message> messages;

    @OneToMany(mappedBy = "usver")
    private List<Token> tokens;

    @Enumerated(value = EnumType.STRING)
    private Role role=Role.USER;
}
