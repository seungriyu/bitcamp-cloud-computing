package bitcamp.assignment.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HelloController {
    @RequestMapping("/hello")
    public void Hello(Model model) {
        model.addAttribute("name","홍길동");
    }
}
