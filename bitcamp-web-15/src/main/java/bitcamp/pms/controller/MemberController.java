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

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberDao memberDao;

    // protected -> public 규칙은 공개되어야함
    // 프론트 컨트롤러에 요청 >> 이 메서드 요청하라고
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "3") int size,
            Model model) throws Exception

    {
        // TODO Auto-generated method stub

        HashMap<String, Object> params = new HashMap<>();

        if (page < 1)
            page = 1;
        if (size < 1 || size > 20)
            size = 3;

        // 페이징처리
        // DB에서 가져올 데이터의 페이지 정보
        params.put("startIndex", (page - 1) * size);
        params.put("pageSize", size);
        // 시작인덱스 = page -1 * 3

        List<Member> list = memberDao.selectList(params);
        model.addAttribute("list", list);
        // 에러가 나지 않았을때 뷰를 저장
//            request.setAttribute("view", "/member/list.jsp");
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

        memberDao.insert(member);
        return "redirect:list";

    }

    @RequestMapping("/delete")
    public String delete(String id) throws Exception {

        memberDao.delete(id);
        return "redirect:list";

    }

    @RequestMapping("/update")
    public String update(Member member) throws Exception {

        if (memberDao.update(member) == 0) {
            // 어디로 갈지 결정
            return "member/updatefail";

        } else {
            return "redirect:list";
        }

    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) throws Exception {
        // 조회할 때는 PathVariable을 많이 적용함
        Member member = memberDao.selectOne(id);
        model.addAttribute("member", member);
//        request.setAttribute("view", "/member/view.jsp");
        return "member/view";

    }
}
