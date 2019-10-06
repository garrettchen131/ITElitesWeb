package cn.sicnu.itelites.controller.api;

import cn.sicnu.itelites.dto.execution.MsgCodeExecution;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.service.IMsgCodeService;
import cn.sicnu.itelites.util.CodeUtil;
import cn.sicnu.itelites.view.RestData;
import cn.sicnu.itelites.view.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/msg")
public class MsgCodeApi {

    @Autowired
    private IMsgCodeService msgCodeService;

    @PostMapping("/send.do")
    private View sendMsgCode(@RequestBody Applicant applicant, HttpServletRequest request) {
        if (!CodeUtil.checkVerifyCode(request)){
            return new RestError("请填写正确的验证码!");
        }
        //TODO 此处需要正则验证电话号码与学号，并且待考虑放在Controller层中还是Service层中，怎么放的问题？
        if (applicant.getPhone() == null)
        {
            return new RestError("电话号码错误");
        }
        MsgCodeExecution execution = msgCodeService.send(request);
        if (execution.getState() == 0) {
            return new RestData(execution);
        }
        return new RestError(execution);
    }
}
