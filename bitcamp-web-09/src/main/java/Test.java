import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.javassist.bytecode.annotation.Annotation;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.Repository;
import bitcamp.pms.context.ApplicationContext;


public class Test {
    
    //객체를 저장할때 이름을 쓸것이기 때문에 HashMap으로 설정
    public static void main(String[] args) throws Exception{
//        System.out.println(url.toString());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.isDirectory());
//        String[] files = file.list();
//        for(String filename : files) {
//            System.out.println(filename);
//        }
//        findClass(file , "bitcamp.pms");
//        
//        //의존성 주입
//        injectDependency();
        ApplicationContext iocContainer = new ApplicationContext("bitcamp.pms");
        Object obj = iocContainer.getBean("/member/list");
        
        System.out.println(obj.getClass().getName());
    }
    
   
    
}
