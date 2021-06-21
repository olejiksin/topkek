package kurs.dto;


import kurs.models.Roles;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

    private String name;
    private String surname;
    private String phonenumber;
    private Roles role;
    private String email;
    private Integer balance;
}
