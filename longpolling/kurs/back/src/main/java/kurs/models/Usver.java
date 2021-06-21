package kurs.models;


import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usver")
@Data
public class Usver {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String phonenumber;
    @Column
    private String email;
    @Column
    private String login;
    @Column
    private String hash;

    @Column
    private Integer balance;

}
