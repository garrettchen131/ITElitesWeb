package cn.sicnu.itelites.service;

import cn.sicnu.itelites.dto.execution.ApplicantExecution;
import cn.sicnu.itelites.entity.Applicant;
import org.springframework.transaction.annotation.Transactional;

public interface IApplicantService {

    @Transactional
    public ApplicantExecution addApplicant(Applicant applicant);
}
