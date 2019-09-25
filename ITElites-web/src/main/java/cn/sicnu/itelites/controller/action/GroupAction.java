package cn.sicnu.itelites.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/group")
public class GroupAction {

    @GetMapping("/add.html")
    private String groupHtml()
    {
        return "test/html/group";
    }
}
