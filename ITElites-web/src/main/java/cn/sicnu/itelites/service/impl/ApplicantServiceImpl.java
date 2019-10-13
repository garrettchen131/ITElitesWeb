package cn.sicnu.itelites.service.impl;

import cn.sicnu.itelites.dao.IApplicantDAO;
import cn.sicnu.itelites.dto.execution.ApplicantExecution;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.enums.ApplicantStateEnum;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.IApplicantService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ApplicantServiceImpl implements IApplicantService {

    @Autowired
    private IApplicantDAO applicantDAO;

    @Override
    public ApplicantExecution addApplicant(Applicant applicant) throws OperationException, DataAccessException {
        if (applicant == null) {
            return new ApplicantExecution(ApplicantStateEnum.NULL_APPLICANT);
        }
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("applicantNum", applicant.getApplicantNum());
        ApplicantExecution queryExecution = this.queryApplicant(queryParams);
        if (queryExecution.getCount() != 0) {
            return new ApplicantExecution(ApplicantStateEnum.REPEAT_NUM);
        }
        //TODO 正则验证phone和qq（这里可以使用读取一个正则表达式的配置文件进行验证实现，可能需要单独写一个验证的工具类）
        //TODO phone验证成功后，后续可能用到腾讯云或阿里云提供的短信服务SDK进行phone验证，让phone成为注册用户最可靠的信息，可靠性高于学号（忽略没有手机号的学生）
        applicant.setCreateTime(new Date());
        applicant.setLastEditTime(new Date());
        try {
            int effective = applicantDAO.insertApplicant(applicant);
            if (effective < 1) throw new OperationException(-1, "添加失败");
        }catch (RuntimeException e) {
            throw e;
        }catch (MySQLIntegrityConstraintViolationException e){
            throw new OperationException(-1, "添加失败,出现重复数据,请检查后填写");
        } catch (SQLException e){
            throw new OperationException(-1, "添加失败");
        }
        return new ApplicantExecution(ApplicantStateEnum.ADD_SUCCESS, applicant);
    }

    @Override
    public ApplicantExecution queryApplicant(Map<String, Object> params) {
        return new ApplicantExecution(ApplicantStateEnum.GET_SUCCESS,this.applicantDAO.queryApplicant(params));
    }

}
