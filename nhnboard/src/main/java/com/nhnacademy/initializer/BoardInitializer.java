package com.nhnacademy.initializer;

import com.nhnacademy.repository.UserDataLoad;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.annotation.HandlesTypes;
import lombok.extern.slf4j.Slf4j;

@HandlesTypes({
    javax.servlet.http.HttpServlet.class,
    javax.servlet.Filter.class,
    javax.servlet.ServletContextListener.class,
    javax.servlet.http.HttpSessionListener.class
})
@Slf4j
public class BoardInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext ctx) {
        ctx.setAttribute("userRepository", new UserDataLoad());
        ctx.setAttribute("lang", "en");
    }
}
