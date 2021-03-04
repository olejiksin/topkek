package com.t.t.service.impl;

import com.t.t.models.Board;
import com.t.t.models.BoardSquare;
import com.t.t.service.CountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CountServiceImplTest {

    @Autowired
    private CountService countService;

    @Test
    public void normalBoardTest() {
        int width = 9;
        int height = 8;
        Board board = new Board(width, height);
        BoardSquare start = new BoardSquare(1, 0);
        BoardSquare end = new BoardSquare(0, 2);
        Assert.assertEquals(1, countService.countDistance(start, end, board));
    }

    @Test
    public void smallBoardTest() {
        int width = 3;
        int height = 3;
        Board board = new Board(width, height);
        BoardSquare start = new BoardSquare(0, 0);
        BoardSquare end = new BoardSquare(1, 1);
        Assert.assertEquals(-1, countService.countDistance(start, end, board));
    }

}