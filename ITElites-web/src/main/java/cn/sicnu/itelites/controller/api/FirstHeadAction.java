package cn.sicnu.itelites.controller.api;


import cn.sicnu.itelites.service.IFirstHeadService;
import cn.sicnu.itelites.view.RestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;


@Controller
@RequestMapping("*.do")
public class FirstHeadAction {
    @Autowired
    private IFirstHeadService firstHeadService;

    @GetMapping("/gethead")
    private View getFirstHead() {
        return new RestData(firstHeadService.getAllFirstHead());
    }
}
