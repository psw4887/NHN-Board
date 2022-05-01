package com.nhnacademy.controller.usemanager;

import com.nhnacademy.controller.Command;
import com.nhnacademy.repository.UserRepository;
import java.io.FileNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserManagerGetController implements Command {
    private final UserRepository userData;

    public UserManagerGetController(UserRepository user) {
        this.userData = user;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws FileNotFoundException {
        req.getServletContext().setAttribute("userList", userData.getUsers());
        return "/User/userManage.jsp";
    }
}
