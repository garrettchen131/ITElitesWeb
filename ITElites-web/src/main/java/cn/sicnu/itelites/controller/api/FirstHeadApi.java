package cn.sicnu.itelites.controller.api;


import cn.sicnu.itelites.service.IFirstHeadService;
import cn.sicnu.itelites.view.RestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;


@Controller
@RequestMapping("/firsthead")
public class FirstHeadApi {
    @Autowired
    private IFirstHeadService firstHeadService;

    @GetMapping("/get.do")
    private View getFirstHead() {
        return new RestData(firstHeadService.getAllFirstHead().getValueList());
    }
}
