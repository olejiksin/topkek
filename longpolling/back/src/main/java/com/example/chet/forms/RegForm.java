package com.example.chet.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Component
@Lazy
public class RegForm {
    private String usverName;
    private String password;
    private String email;

}
