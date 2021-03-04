package com.t.t.service;

import com.t.t.models.Board;
import com.t.t.models.BoardSquare;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {

    public void rek(int x, int y, int step, int[][] matrix) {
        int dx[] = {-1, 1, -2, -2, 2, 2, 1, -1};
        int dy[] = {2, 2, 1, -1, 1, -1, -2, -2};
        int xx[] = {-1, -1, -1, -1, -1, -1, -1, -1};
        int yy[] = {-1, -1, -1, -1, -1, -1, -1, -1};
        matrix[x][y] = step;
        for (int i = 0; i < 8; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if ((x1 >= 0) && (y1 >= 0) && (x1 < matrix.length) && (y1 < matrix[0].length) && (matrix[x1][y1] == -1)) {
                matrix[x1][y1] = step + 1;
                xx[i] = x1;
                yy[i] = y1;
            }
        }
        for (int i = 0; i < 8; i++) {
            if (xx[i] != -1) {
                rek(xx[i], yy[i], step + 1, matrix);
            }
        }
    }

    @Override
    public int countDistance(BoardSquare startPosition, BoardSquare endPosition, Board bo) {
        int[][] board = new int[bo.getHeight()][bo.getWidth()];
        for (int i = 0; i < bo.getHeight(); i++) {
            for (int j = 0; j < bo.getWidth(); j++) {
                board[i][j] = -1;
            }
        }
        rek(startPosition.getX(), startPosition.getY(), 0, board);
        if (board[endPosition.getX()][endPosition.getY()] != -1) {
            return board[endPosition.getX()][endPosition.getY()];
        }
        return -1;
    }
}
