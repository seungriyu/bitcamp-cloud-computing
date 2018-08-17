package bitcamp.assignment.web.json;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.assignment.domain.Member;
import bitcamp.assignment.service.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired MemberService memberService;
    
//    @RequestMapping(value="signUp" , method=RequestMethod.POST)
    @PostMapping("signIn")
    public Object signIn(String email, 
                        String password,
                        boolean saveEmail,
                        HttpSession session) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            System.out.println(email);
            System.out.println(password);
//            System.out.println(saveEmail);
            Member loginUser = memberService.getMember(email, password);
            System.out.println(loginUser);
            
            if(loginUser == null) 
                throw new Exception("로그인 실패");
            
            //세션에 유저 저장
            session.setAttribute("loginUser", loginUser);
            result.put("status", "success");
            
//            System.out.println(loginUser);
            
        }catch(Exception e) {
            result.put("status", "fail");
            result.put("message",e.getMessage());
        }
        
        return result;
    }
}
