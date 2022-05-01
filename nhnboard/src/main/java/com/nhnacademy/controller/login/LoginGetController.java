package com.nhnacademy.controller.login;

import com.nhnacademy.controller.Command;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginGetController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        if(Objects.isNull(session)) {
            return "redirect:/Login/loginForm.jsp";
        }
        if(Objects.nonNull(session.getAttribute("ss_id"))) {
            if (session.getAttribute("ss_id").equals("Admin")) {
                return "/Login/loginAdmin.jsp";
            }
        }
        return "/Login/login.jsp";
    }
}
