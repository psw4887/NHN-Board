package com.nhnacademy.repository;

import com.nhnacademy.data.Board;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BoardDataLoad implements BoardRepository {

    private final Map<Long, Board> boardMemory = new ConcurrentHashMap<>();
    private long count = 0;

    @Override
    public long register(Board board) {
        board.setId(count);
        count++;
        boardMemory.put(board.getId(), board);
        return board.getId();
    }

    @Override
    public void modify(Board board) {
        if (!boardMemory.containsKey(board.getId())) {
            throw new IllegalStateException();
        }
        boardMemory.remove(board.getId());
        boardMemory.put(board.getId(), board);
    }

    @Override
    public Board remove(long id) {
        boardMemory.remove(id);
        for (var i=id;i<boardMemory.size();i++) {
            if(boardMemory.get(i+1) != null) {
                boardMemory.get(i+1).setId(i);
                boardMemory.put(i, boardMemory.get(i + 1));
                boardMemory.remove(i+1);
            }
        }
        count--;
        return null;
    }

    @Override
    public Board getBoard(long id) {
        return boardMemory.get(id);
    }

    @Override
    public List<Board> getBoards() {
        return new ArrayList<>(boardMemory.values());
    }
}
