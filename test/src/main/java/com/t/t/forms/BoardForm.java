package com.t.t.forms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardForm {
    private int width;
    private int height;
    private String start;
    private String end;
}
