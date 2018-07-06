package bitcamp.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bitcamp.pms.dao.MemberDao;


@WebListener
public class ContextLoaderListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        System.out.println("ContextLoaderListener 실행");
        MemberDao memberDao = new MemberDao(
                "jdbc:mysql://13.209.76.8:3306/studydb",
                "study","1111");
        
        //서블릿이 사용가능 하도록 해야함
        ServletContext sc = sce.getServletContext();
        
        //ServletContext에 저장된 생태
        sc.setAttribute("memberDao", memberDao);
        
        //톰캣 서버에 등록해야함 >> @WebListener
        
        
    }
}
