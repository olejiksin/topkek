package com.example.test.Model;

import lombok.*;

import javax.persistence.*;

@Table(name = "test")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id" , referencedColumnName = "id")
    private User user;
}
