package com.example.test.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "online_users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private String online;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Message> messages;
}
