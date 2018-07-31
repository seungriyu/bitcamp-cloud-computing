package bitcamp.pms.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.dao.MemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener{
    
    public void contextInitialized (ServletContextEvent sce) {
        System.out.println("실행");
//        try {
//            
//            String resource = "bitcamp/pms/config/mybatis-config.xml";
//            InputStream inputStream = Resources.getResourceAsStream(resource);
//            SqlSessionFactory sqlSessionFactory = 
//                    new SqlSessionFactoryBuilder().build(inputStream);
//            MemberDao  memberDao = new MemberDao(sqlSessionFactory);
//            
//            ServletContext sc = sce.getServletContext();
//            System.out.println("1");
//            
//        }catch(Exception e){
//            e.printStackTrace();
//            
//        }
        BoardDao boardDao = new BoardDao(
                "jdbc:mysql://13.209.76.8:3306/studydb",
                "study","1111");
        
        //서블릿이 사용가능 하도록 해야함
        ServletContext sc = sce.getServletContext();
        
        //ServletContext에 저장된 생태
        sc.setAttribute("boardDao", boardDao);
        
        
    }
    
}
