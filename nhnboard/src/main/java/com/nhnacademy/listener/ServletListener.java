package com.nhnacademy.listener;

import com.nhnacademy.data.User;
import com.nhnacademy.repository.BoardDataLoad;
import com.nhnacademy.repository.UserRepository;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class ServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserRepository repo =
            (UserRepository) sce.getServletContext().getAttribute("userRepository");
        repo.add(new User("관리자", "Admin", "12345", null));
        sce.getServletContext().setAttribute("boardRepository", new BoardDataLoad());
    }
}
