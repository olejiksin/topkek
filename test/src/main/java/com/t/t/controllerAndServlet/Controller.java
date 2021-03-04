package com.t.t.controllerAndServlet;

import com.t.t.models.Board;
import com.t.t.models.BoardSquare;
import com.t.t.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.t.t.specs.PositionConverter;

@RestController
@RequestMapping("rest")
public class Controller {

    @Autowired
    private CountService countService;

    @Autowired
    private PositionConverter positionConverter;

    @RequestMapping(method = RequestMethod.GET, value = "count")
    public ResponseEntity<?> restCount(@RequestParam("start") String start, @RequestParam("end") String end,
                                       @RequestParam("width") String width, @RequestParam("height") String height) {
        try {
            Board board = new Board(Integer.parseInt(width), Integer.parseInt(height));
            BoardSquare startPos = positionConverter.convertStringToBoardSquare(start);
            BoardSquare endPos = positionConverter.convertStringToBoardSquare(end);
            if (startPos.getX() > board.getWidth() || startPos.getY() > board.getHeight() || endPos.getX() > board.getWidth() || endPos.getY() > board.getHeight()) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok().body(countService.countDistance(startPos, endPos, board));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
