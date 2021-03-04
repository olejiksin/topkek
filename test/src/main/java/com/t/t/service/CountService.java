package com.t.t.service;

import com.t.t.models.Board;
import com.t.t.models.BoardSquare;

public interface CountService {
    int countDistance(BoardSquare startPosition, BoardSquare endPosition, Board board);
}
