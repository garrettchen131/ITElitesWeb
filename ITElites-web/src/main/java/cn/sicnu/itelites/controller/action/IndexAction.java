package cn.sicnu.itelites.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexAction {

    @GetMapping(".html")
    private String getIndex() {
        return "index";
    }
}
