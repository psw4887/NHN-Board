package com.nhnacademy.controller.usemanager;

import com.nhnacademy.controller.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.repository.UserRepository;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserManagerPostController implements Command {
    UserRepository repo;

    public UserManagerPostController(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String result = "redirect:/user.do";
        String button = "button";
        if (req.getParameter(button).equals("Add")) {
            addUser(req);
            return result;
        } else if (req.getParameter(button).equals("Modify")) {
            modifyUser(req);
            return result;
        } else if (req.getParameter(button).equals("Delete")) {
            deleteUser(req);
            return result;
        } else if (req.getParameter(button).equals("Find")) {
            User user = findUser(req);
            ServletContext serv = req.getServletContext();
            serv.setAttribute("findUser", user);
            return result;
        }
        return "/User/userManage.jsp";
    }

    private void addUser(HttpServletRequest req) {
        repo.add(
            new User(req.getParameter("addName"), req.getParameter("addId"),
                req.getParameter("addPwd"), null));
    }

    private void modifyUser(HttpServletRequest req) {
        User user = repo.getUser(req.getParameter("beforeId"));
        repo.remove(req.getParameter("beforeId"));
        user.setId(req.getParameter("afterId"));
        user.setPassword(req.getParameter("afterPwd"));
        repo.modify(user);
    }

    private void deleteUser(HttpServletRequest req) {
        repo.remove(req.getParameter("removeId"));
    }

    private User findUser(HttpServletRequest req) {
        return repo.getUser(req.getParameter("findId"));
    }
}
