package cn.sicnu.itelites.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/team")
public class TeamAction {

    @GetMapping("/add.html")
    private String teamHtml() {
        return "test/html/team";
    }
}
