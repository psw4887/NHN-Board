package com.nhnacademy.controller.board;

import com.nhnacademy.controller.Command;
import com.nhnacademy.data.Board;
import com.nhnacademy.repository.BoardRepository;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterBoardPostController implements Command {
    BoardRepository repo;

    public MasterBoardPostController(BoardRepository repo) {
        this.repo = repo;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String result = "redirect:/masterBoard.do";
        String button = "button";
        Board board;
        if (!(req.getSession(false).getAttribute("ss_id").equals("Admin"))) {
            if ((req.getParameter(button)).equals("Post")) {
                postBoard(req);
            } else if ((req.getParameter(button)).equals("Modify")) {
                userModifyBoard(req);
            } else if ((req.getParameter(button)).equals("Delete")) {
                userDeleteBoard(req);
            } else if ((req.getParameter(button)).equals("Find")) {
                board = findBoard(req);
                req.getServletContext().setAttribute("findThis", board);
                return "redirect:/board.do";
            }
        }
        else {
            if ((req.getParameter(button)).equals("Post")) {
                postBoard(req);
            } else if ((req.getParameter(button)).equals("Modify")) {
                modifyBoard(req);
            } else if ((req.getParameter(button)).equals("Delete")) {
                deleteBoard(req);
            } else if ((req.getParameter(button)).equals("Find")) {
                board = findBoard(req);
                req.getServletContext().setAttribute("findThis", board);
                return "redirect:/board.do";
            }
        }
        return result;
    }

    private void userModifyBoard(HttpServletRequest req) {
        if(req.getSession(false).getAttribute("ss_id").equals(repo.getBoard(
            Long.parseLong(req.getParameter("beforeId"))).getUserId())) {
            Board board = repo.getBoard(Long.parseLong(req.getParameter("beforeId")));
            board.setTitle(req.getParameter("title"));
            board.setContent(req.getParameter("context"));
            repo.modify(board);
        }
    }

    private void userDeleteBoard(HttpServletRequest req) {
        if(req.getSession(false).getAttribute("ss_id").equals(repo.getBoard(
            Long.parseLong(req.getParameter("removeId"))).getUserId())) {
            repo.remove(Long.parseLong(req.getParameter("removeId")));
        }
    }


    private void postBoard(HttpServletRequest req) {
        Board board = new Board();
        LocalDateTime now = LocalDateTime.now();
        board.setTitle(req.getParameter("title"));
        board.setContent(req.getParameter("context"));
        board.setUserId((String)req.getSession().getAttribute("ss_id"));
        board.setWriteTime(now);
        repo.register(board);
    }
    private void modifyBoard(HttpServletRequest req) {
        Board board = repo.getBoard(Long.parseLong(req.getParameter("beforeId")));
        board.setTitle(req.getParameter("title"));
        board.setContent(req.getParameter("context"));
        repo.modify(board);
    }
    private void deleteBoard(HttpServletRequest req) {
        repo.remove(Long.parseLong(req.getParameter("removeId")));
    }
    private Board findBoard(HttpServletRequest req) {
        return repo.getBoard(Long.parseLong(req.getParameter("findBoard")));
    }
}
