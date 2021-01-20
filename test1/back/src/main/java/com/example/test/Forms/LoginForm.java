package com.example.test.Forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Component
public class LoginForm {
    private String name;
    private String password;
}
