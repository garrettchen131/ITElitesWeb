package cn.sicnu.itelites.service;

import cn.sicnu.itelites.dto.execution.ApplicantExecution;
import cn.sicnu.itelites.entity.Applicant;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

public interface IApplicantService {

    @Transactional
    public ApplicantExecution addApplicant(Applicant applicant) throws DataAccessException;

    public ApplicantExecution queryApplicant(Map<String, Object> params);
}
