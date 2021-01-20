package k.te.kest.dto;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ResumeDTO {
    private String phone;
    private String email;
    private String about;
    private ArrayList<String> skills;
}
