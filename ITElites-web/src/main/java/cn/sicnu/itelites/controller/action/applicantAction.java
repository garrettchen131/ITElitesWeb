package cn.sicnu.itelites.controller.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applicant")
public class applicantAction {

    @GetMapping("/add.html")
    public String applicantHtml() {
        return "test/html/applicant";
    }
}
