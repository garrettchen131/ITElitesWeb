package cn.sicnu.itelites.controller.api;

import cn.sicnu.itelites.dto.execution.ApplicantExecution;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.exception.ValidationException;
import cn.sicnu.itelites.service.IApplicantService;
import cn.sicnu.itelites.util.GenerateUtil;
import cn.sicnu.itelites.view.RestData;
import cn.sicnu.itelites.view.RestError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
@RequestMapping("/applicant")
public class ApplicantApi {

    Logger logger = LoggerFactory.getLogger(ApplicantApi.class);

    @Autowired
    private IApplicantService applicantService;

    @PostMapping("/add.do")
    private View addApplicant(@RequestBody Map<String,String> params, HttpServletRequest request) {
        logger.info("IP : " + request.getRemoteAddr() + "  Num : " + params.get("applicantNum"));
        Applicant applicant = null;
        try {
            applicant = GenerateUtil.GenerateClass(params, Applicant.class);
        }catch (ValidationException e){
            logger.error("Generate-" + "Name : "+params.get("applicantName") + "  Num : " + params.get("applicantNum") + e.getMessage());
            return new RestError(e.getMessage());
        } catch (Exception e) {
            logger.error("Generate-" + "Name : "+params.get("applicantName") + "  Num : " + params.get("applicantNum") + e.getMessage());
            return new RestError("未知的出错原因!"); //此处进行验证过后不会出错
        }

        ApplicantExecution applicantExecution = null;
        try {
            applicantExecution = applicantService.addApplicant(applicant);
            if (applicantExecution.getState() != 0) {
                logger.debug("Service-" + "Name : "+params.get("applicantName") + "  Num : " + params.get("applicantNum"));
                return new RestError(applicantExecution);
            }
        } catch (OperationException e) {
            logger.error("Service-" + "Name : "+params.get("applicantName") + "  Num : " + params.get("applicantNum") + e.getMessage());
            return new RestError(e);
        } catch (DataAccessException e) {
            logger.error("Service-" + "Name : "+params.get("applicantName") + "  Num : " + params.get("applicantNum") + e.getMessage());
            return new RestError("此报名人学号或电话号码被使用，请检查后在填写，或联系相关部门");
        } catch (RuntimeException e) {
            logger.error("Service-" + "Name : "+params.get("applicantName") + "  Num : " + params.get("applicantNum") + e.getMessage());
            return new RestError(e);
        }
        return new RestData(applicantExecution);
    }
}
