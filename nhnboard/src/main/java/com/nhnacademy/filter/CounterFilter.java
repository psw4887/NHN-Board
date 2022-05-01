package com.nhnacademy.filter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter(filterName = "counterFilter", value = {"/boardService", "/adminService"})
public class CounterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        ServletContext servletContext = servletRequest.getServletContext();

        String fileName = servletContext.getInitParameter("count");
        String line=null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            line = br.readLine();
            int count = Integer.parseInt(line);
            count++;
            if (((HttpServletRequest)servletRequest).getMethod().equals("POST")){
                count--;
            }
            log.error(String.valueOf(count));
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.write(String.valueOf(count));
            }
        } catch (IOException e) {
            log.error("", e);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
