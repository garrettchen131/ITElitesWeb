package cn.sicnu.itelites.controller.api;

import cn.sicnu.itelites.dto.execution.ApplicantExecution;
import cn.sicnu.itelites.dto.execution.MsgCodeExecution;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.IApplicantService;
import cn.sicnu.itelites.service.IMsgCodeService;
import cn.sicnu.itelites.util.CodeUtil;
import cn.sicnu.itelites.util.GenerateUtil;
import cn.sicnu.itelites.view.RestData;
import cn.sicnu.itelites.view.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@Controller
@RequestMapping("/applicant")
public class ApplicantApi {

    @Autowired
    private IApplicantService applicantService;

    @Autowired
    private IMsgCodeService msgCodeService;

    @PostMapping("/add.do")
    private View addApplicant(@RequestBody Applicant applicant, HttpServletRequest request) {
        if (!CodeUtil.checkVerifyCode(request)){
            return new RestError("请填写正确的验证码!");
        }

//        Applicant applicant = null;
//        try {
//            applicant = GenerateUtil.GenerateClass(params, Applicant.class);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }

        ApplicantExecution applicantExecution = null;
        try {
            applicantExecution = applicantService.addApplicant(applicant);
            if (applicantExecution.getState() != 0) {
                return new RestError(applicantExecution);
            }
        }catch (OperationException e){
            return new RestError(e);
        }catch (RuntimeException e){
            return new RestError(e);
        }
        return new RestData(applicantExecution);
    }
}
