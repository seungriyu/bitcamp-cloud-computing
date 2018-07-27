package bitcamp.pms.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;

    // protected -> public 규칙은 공개되어야함
    // 프론트 컨트롤러에 요청 >> 이 메서드 요청하라고
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size,
            Model model) throws Exception

    {
        if (page < 1)
            page = 1;
        if (size < 1 || size > 20)
            size = 3;

        List<Member> list = memberService.list(page,size);
        model.addAttribute("list", list);
        //서블릿 리퀘스트에 정보가 들어감
        model.addAttribute("page",page);
        model.addAttribute("size",size);
        model.addAttribute("totalPage",memberService.getTotalPage(size));
        return "member/list";
    }

    // @RequestMapping(value="/member/add" , method=RequestMethod.GET)
    @GetMapping("/form")
    public void form() {
        // url이 void면 현재 값을 리턴
    }

    // @RequestMapping(value="/member/add" , method=RequestMethod.POST)
    @PostMapping("/add")
    public String add(Member member) throws Exception {

        memberService.add(member);
        return "redirect:list";

    }

    @RequestMapping("/delete")
    public String delete(String id) throws Exception {

        memberService.delete(id);
        return "redirect:list";

    }

    @RequestMapping("/update")
    public String update(Member member) throws Exception {
        
        if (memberService.update(member) == 0) {
            // 어디로 갈지 결정
            return "member/updatefail";

        } else {
            return "redirect:list";
        }

    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) throws Exception {
        
        Member member = memberService.get(id);
        model.addAttribute("member", member);

        return "member/view";

    }
}
