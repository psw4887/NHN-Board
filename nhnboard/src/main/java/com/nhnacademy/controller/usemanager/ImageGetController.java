package com.nhnacademy.controller.usemanager;

import com.nhnacademy.controller.Command;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ImageGetController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        ServletOutputStream bout = resp.getOutputStream();
        //파일의 경로
        String imgPath = "D:\\NHNAcademy\\4월\\웹어플리케이션\\nhnboard\\src\\main\\resources\\imageData\\"
            +  File.separator + req.getParameter("content");
        FileInputStream f = new FileInputStream(imgPath);
        int length;
        byte[] buffer = new byte[4096];
        while((length=f.read(buffer)) != -1){
            bout.write(buffer,0,length);
        }
        return "/User/userManage.jsp";
    }
}
