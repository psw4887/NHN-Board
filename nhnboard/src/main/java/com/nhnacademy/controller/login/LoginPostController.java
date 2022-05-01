package com.nhnacademy.controller.login;

import com.nhnacademy.controller.Command;
import com.nhnacademy.repository.UserRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginPostController implements Command {

    private UserRepository repo;

    public LoginPostController(UserRepository repo) {
        this.repo = repo;
    }
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        int count = 0;
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        if(repo.getUser(id) != null) {
            if ((repo.getUser(id).getPassword()).equals(pwd)) {
                HttpSession session = req.getSession();
                session.setAttribute("ss_id", id);
                log.error(String.valueOf(count));
                count++;
                return "redirect:/login.do";
            }
        }
        return "redirect:/Login/loginForm.jsp";
    }
}
