package com.nhnacademy.controller.join;

import com.nhnacademy.controller.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class JoinGetController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/Join/join.jsp";
    }
}
