package com.example.test.DTO;

import com.example.test.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDto {
    private List<MessageDto> messageDtoList;
    private List<String> onlineUserList;
}
