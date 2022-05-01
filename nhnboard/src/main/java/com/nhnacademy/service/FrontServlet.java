package com.nhnacademy.service;

import com.nhnacademy.controller.*;
import com.nhnacademy.controller.board.BoardHomeGetController;
import com.nhnacademy.controller.board.MasterBoardPostController;
import com.nhnacademy.controller.board.MasterBoardGetController;
import com.nhnacademy.controller.join.JoinGetController;
import com.nhnacademy.controller.join.JoinPostController;
import com.nhnacademy.controller.login.LoginGetController;
import com.nhnacademy.controller.login.LoginPostController;
import com.nhnacademy.controller.login.LogoutGetController;
import com.nhnacademy.controller.usemanager.ImageGetController;
import com.nhnacademy.controller.usemanager.UserManagerGetController;
import com.nhnacademy.controller.usemanager.UserManagerPostController;
import com.nhnacademy.repository.BoardRepository;
import com.nhnacademy.repository.UserRepository;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@WebServlet(name="frontServlet", urlPatterns = "*.do")
@Slf4j
@MultipartConfig(
    location = "C:\\Users\\psw48",
    maxFileSize = -1L,
    maxRequestSize = -1L,
    fileSizeThreshold = 1024
)public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try {
            Command command = resolveServlet(req);

            String view = command.execute(req, resp);
            if (view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception ex) {
            log.error("", ex);
            req.setAttribute("exception", ex);
            RequestDispatcher rd = req.getRequestDispatcher("/Error/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveServlet(HttpServletRequest req) {

        Command command = null;
        String servletPath = req.getServletPath();
        String method = req.getMethod();

        UserRepository userRepository =
            (UserRepository) getServletContext().getAttribute("userRepository");
        BoardRepository boardRepository =
            (BoardRepository) getServletContext().getAttribute("boardRepository");
        if ("/login.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LoginGetController();
        } else if ("/login.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new LoginPostController(userRepository);
        } else if ("/join.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new JoinGetController();
        } else if ("/join.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new JoinPostController(userRepository);
        } else if ("/logout.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LogoutGetController();
        } else if ("/user.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new UserManagerGetController(userRepository);
        } else if ("/user.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new UserManagerPostController(userRepository);
        } else if ("/board.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new BoardHomeGetController();
        } else if ("/masterBoard.do".equals(servletPath) && "POST".equalsIgnoreCase(method)) {
            command = new MasterBoardPostController(boardRepository);
        } else if ("/masterBoard.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new MasterBoardGetController();
        } else if ("/lang.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new LangGetController();
        } else if ("/image.do".equals(servletPath) && "GET".equalsIgnoreCase(method)) {
            command = new ImageGetController();
        }
        return command;
    }
}
