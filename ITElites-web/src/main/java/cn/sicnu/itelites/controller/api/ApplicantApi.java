package cn.sicnu.itelites.controller.api;

import cn.sicnu.itelites.dto.execution.ApplicantExecution;
import cn.sicnu.itelites.dto.execution.MsgCodeExecution;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.exception.ValidationException;
import cn.sicnu.itelites.service.IApplicantService;
import cn.sicnu.itelites.service.IMsgCodeService;
import cn.sicnu.itelites.util.CheckUtil;
import cn.sicnu.itelites.util.CodeUtil;
import cn.sicnu.itelites.util.GenerateUtil;
import cn.sicnu.itelites.view.RestData;
import cn.sicnu.itelites.view.RestError;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;


@Controller
@RequestMapping("/applicant")
public class ApplicantApi {

    @Autowired
    private IApplicantService applicantService;

    @Autowired
    private IMsgCodeService msgCodeService;

    @PostMapping("/add.do")
    private View addApplicant(@RequestBody Map<String,String> params, HttpServletRequest request) {

        Applicant applicant = null;
        try {
            applicant = GenerateUtil.GenerateClass(params, Applicant.class);
        }catch (ValidationException e){
            return new RestError(e.getMessage());
        } catch (Exception e) {
            return new RestError("未知的出错原因!"); //此处进行验证过后不会出错
        }

        ApplicantExecution applicantExecution = null;
        try {
            applicantExecution = applicantService.addApplicant(applicant);
            if (applicantExecution.getState() != 0) {
                return new RestError(applicantExecution);
            }
        } catch (OperationException e) {
            return new RestError(e);
        } catch (DataAccessException e) {
            return new RestError("此报名人学号或电话号码被使用，请检查后在填写，或联系相关部门");
        } catch (RuntimeException e) {
            return new RestError(e);
        }
        return new RestData(applicantExecution);
    }
}
