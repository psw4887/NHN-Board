package com.nhnacademy.controller.board;

import com.nhnacademy.controller.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterBoardGetController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/Board/masterBoard.jsp";
    }
}
