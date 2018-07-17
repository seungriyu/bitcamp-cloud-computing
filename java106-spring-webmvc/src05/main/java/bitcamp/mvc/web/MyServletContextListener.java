package bitcamp.mvc.web;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener{
    
    //톰캣 서버가 시작하거나 종료할 때 알림을 받고 싶을 때, 
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized()......");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed().......");
    }
    
}
