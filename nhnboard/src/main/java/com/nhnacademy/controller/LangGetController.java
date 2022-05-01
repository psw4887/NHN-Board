package com.nhnacademy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LangGetController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        if((req.getServletContext().getAttribute("lang")).equals("en")) {
            req.getServletContext().setAttribute("lang", "ko");
            return "redirect:/";
        }
        req.getServletContext().setAttribute("lang", "en");
        return "redirect:/";
    }
}
