package bitcamp.pms.listener;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import bitcamp.pms.dao.MemberDao;


@WebListener
public class ContextLoaderListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        System.out.println("ContextLoaderListener 실행");
        
        try {
            String resource = "bitcamp/pms/config/mybatis-config.xml";
            //FileInputStream in = new FileInputStream(c/ddd/ddd/ddd) >> 원래는 이렇게 하는데
            //Resources : 자바클래스에서 경로를 찾아줌 , InputStream 생성시켜줌 
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            
            
            //MemberDao가 사용할 의존객체를 여기서 만든다.
            //ContextLoaderListener 얘가 dao 만든는 애
            MemberDao memberDao = new MemberDao(sqlSessionFactory);
            
            //서블릿이 사용가능 하도록 해야함
            ServletContext sc = sce.getServletContext();
            
            //ServletContext에 저장된 생태
            sc.setAttribute("memberDao", memberDao);
            
            //톰캣 서버에 등록해야함 >> @WebListener
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
