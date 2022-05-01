package com.nhnacademy.controller.join;

import com.nhnacademy.controller.Command;
import com.nhnacademy.data.User;
import com.nhnacademy.repository.UserRepository;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MultipartConfig(
    location = "D:\\NHNAcademy\\4월\\웹어플리케이션\\nhnboard\\src\\main\\resources\\imageData",
    maxFileSize = -1L,
    maxRequestSize = -1L,
    fileSizeThreshold = 1024
)public class JoinPostController implements Command {
    private final UserRepository repo;
    private static final String CONTENT_DISPOSITION = "Content-Disposition";

    private static final String UPLOAD_DIR = "D:\\NHNAcademy\\4월\\웹어플리케이션\\nhnboard\\src\\main\\resources\\imageData";

    public JoinPostController(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        HttpSession session = req.getSession();
        String file = null;
        for (Part part : req.getParts()) {
            String contentDisposition = part.getHeader(CONTENT_DISPOSITION);

            if (contentDisposition.contains("filename=")) {
                log.error(extractFileName(contentDisposition));
                String fileName = extractFileName(contentDisposition);
                file = fileName;
                if (part.getSize() > 0) {
                    part.write(UPLOAD_DIR + File.separator + fileName);
                    part.delete();
                }
            } else {
                String formValue = req.getParameter(part.getName());
                log.error("{}={}", part.getName(), formValue);
            }
        }
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        session.setAttribute("ss_id", id);

        this.repo.add(new User(name, id, pwd, file));

        return "redirect:/join.do";
    }

    private String extractFileName(String contentDisposition) {
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf("=") + 1)
                    .trim().replace("\"", "");
                int index = fileName.lastIndexOf(File.separator);
                return fileName.substring(index + 1);
            }
        }

        return null;
    }
}
