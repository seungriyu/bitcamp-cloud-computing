package bitcamp.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bitcamp.pms.dao.MemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
    
    public void contextInitialized (ServletContextEvent sce) {
        System.out.println("실행");
        MemberDao memberDao = new MemberDao(
                "jdbc:mysql://13.209.76.8:3306/studydb",
                "study","1111");
        
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("memberDao", memberDao);
        
    }
    
}
