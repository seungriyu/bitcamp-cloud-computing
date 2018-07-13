package bitcamp.pms.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberListController {
    
    MemberDao memberDao;
    
    //Autowired 작성해도 자동으로 주입 X
    //<property name="memberDao" ref="memberDao"><!-- set생략하고 맨앞 소문자로 , ref :bean id이름--></property>
    
    @Autowired 
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public String toString() {
        return "MemberListController [memberDao=" + memberDao + "]";
    }
    
    
}
