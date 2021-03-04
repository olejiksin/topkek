package com.t.t.specs;

import com.t.t.models.BoardSquare;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PositionConverter {

    private final char firstChar = 'A';

    public BoardSquare convertStringToBoardSquare(String position) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(position);
        int y = 0;
        if (matcher.find()) {
            //смещение на -1 для сопоствления с позициями в матрице
            y = Integer.parseInt(position.substring(matcher.end()))-1;
        }
        int x = position.charAt(0) - firstChar ;
        return new BoardSquare(x, y);
    }
}
