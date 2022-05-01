package com.nhnacademy.controller.login;

import com.nhnacademy.controller.Command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutGetController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "/Login/logout.jsp";
    }
}
