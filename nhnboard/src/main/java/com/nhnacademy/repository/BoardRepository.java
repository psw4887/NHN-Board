package com.nhnacademy.repository;

import com.nhnacademy.data.Board;
import java.util.List;

public interface BoardRepository {
    long register(Board board);
    void modify(Board board);
    Board remove(long id);

    Board getBoard(long id);
    List<Board> getBoards();
}
