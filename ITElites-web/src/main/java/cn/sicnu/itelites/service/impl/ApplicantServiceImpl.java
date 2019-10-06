package cn.sicnu.itelites.service.impl;

import cn.sicnu.itelites.dao.IApplicantDAO;
import cn.sicnu.itelites.dto.execution.ApplicantExecution;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.enums.ApplicantStateEnum;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.IApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ApplicantServiceImpl implements IApplicantService {

    @Autowired
    private IApplicantDAO applicantDAO;

    @Override
    public ApplicantExecution addApplicant(Applicant applicant) throws OperationException {
        if (applicant == null) {
            return new ApplicantExecution(ApplicantStateEnum.NULL_APPLICANT);
        }
        if (applicant.getApplicantName() == null || "".equals(applicant.getApplicantName()) ||
                applicant.getApplicantNum() == null || applicant.getPhone() == null ||
                "".equals(applicant.getPhone()) || applicant.getQq() == null ||
                "".equals(applicant.getQq())) {
            return new ApplicantExecution(ApplicantStateEnum.INCOMPLETE);
        }
        //TODO 正则验证phone和qq（这里可以使用读取一个正则表达式的配置文件进行验证实现，可能需要单独写一个验证的工具类）
        //TODO phone验证成功后，后续可能用到腾讯云或阿里云提供的短信服务SDK进行phone验证，让phone成为注册用户最可靠的信息，可靠性高于学号（忽略没有手机号的学生）
        applicant.setCreateTime(new Date());
        applicant.setLastEditTime(new Date());
        try {
            int effective = applicantDAO.insertApplicant(applicant);
            if (effective < 1) throw new OperationException(-1, "添加失败");
        } catch (RuntimeException e) {
            throw e;
        }
        return new ApplicantExecution(ApplicantStateEnum.ADD_SUCCESS, applicant);
    }

}
