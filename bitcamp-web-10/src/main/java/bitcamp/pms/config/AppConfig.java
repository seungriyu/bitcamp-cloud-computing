package bitcamp.pms.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig() 호출됨");    
       
    }
    
    /*
    //스프링 IoC가 보관해야할
    //메서도 호출한다음에 메서드 값 저장해!, 저장할때 이름은 지정하지 않았으니까 
    @Bean("sqlSessionFactory") 
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        System.out.println("AppConfig.getSqlSessionFactory() 호출됨!");
        String resource = "bitcamp/pms/config/mybatis-config.xml";
        //FileInputStream in = new FileInputStream(c/ddd/ddd/ddd) >> 원래는 이렇게 하는데
          //Resources : 자바클래스에서 경로를 찾아줌 , InputStream 생성시켜줌 
          InputStream inputStream = 
                  Resources.getResourceAsStream(resource);
          return new SqlSessionFactoryBuilder().build(inputStream);
    }
    */
    
}
