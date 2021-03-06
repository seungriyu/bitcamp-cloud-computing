package bitcamp.pms.controller.json;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;

//@CrossOrigin
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;
    
    
    // protected -> public 규칙은 공개되어야함
    // 프론트 컨트롤러에 요청 >> 이 메서드 요청하라고
  //CrossOrigin: 다른 모든 클라이언트에게 요청을 허락한다!!!!!
    //@CrossOrigin
    @RequestMapping("/list")
    public Object list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size) throws Exception

    {
        if (page < 1)
            page = 1;
        if (size < 1 || size > 20)
            size = 3;

        List<Member> list = memberService.list(page,size);
        HashMap<String, Object> data = new HashMap<>();
        data.put("list", list);
        //서블릿 리퀘스트에 정보가 들어감
        data.put("page",page);
        data.put("size",size);
        data.put("totalPage",memberService.getTotalPage(size));
        
        return data;
    }

    // @RequestMapping(value="/member/add" , method=RequestMethod.GET)
    @GetMapping("/form")
    public void form() {
        // url이 void면 현재 값을 리턴
    }

    // @RequestMapping(value="/member/add" , method=RequestMethod.POST)
    @PostMapping("/add")
    public Object add(Member member) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        memberService.add(member);
           result.put("status", "success");
           
       
        return result;

    }

    @RequestMapping("/delete")
    public Object delete(String id) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if (memberService.delete(id) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 아이디가 없섭니다");
        } else {
            result.put("status", "success");
           
        }
        return result;

    }

    @RequestMapping("/update")
    public Object update(Member member) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        if (memberService.update(member) == 0) {
            result.put("status", "fail");
            result.put("error", "해당 아이디가 없섭니다");
        } else {
            result.put("status", "success");
           
        }
        return result;

    }

    @RequestMapping("/view/{id}")
    public Object view(@PathVariable String id) throws Exception {
        HashMap<String, Object> data = new HashMap<>();
        data.put("member", memberService.get(id));
        return data;

    }
}
