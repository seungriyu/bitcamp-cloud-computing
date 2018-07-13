package bitcamp.pms.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    
    
    public static void main(String[] args) throws Exception{
      //Spring IoC 컨테이너 객체 생성하기
      //ClassPath
      ClassPathXmlApplicationContext iocContainer = 
              new ClassPathXmlApplicationContext("bitcamp/pms/test/application-context.xml");
      
      System.out.println(iocContainer.getBeanDefinitionCount()); //객체 몇개인지 확인하기
      System.out.println("---------------------------------");
      String[] names =iocContainer.getBeanDefinitionNames();
      for(String name : names) {
          System.out.println(iocContainer.getBean(name).getClass().getName());
      }
      
    }
    
   
    
}
