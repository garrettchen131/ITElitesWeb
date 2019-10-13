package cn.sicnu.itelites.dto.execution;

import cn.sicnu.itelites.dto.BaseExecution;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.ApplicantStateEnum;
import cn.sicnu.itelites.enums.TeamStateEnum;

import java.util.List;

public class ApplicantExecution extends BaseExecution<Applicant> {

    public ApplicantExecution(ApplicantStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public ApplicantExecution(ApplicantStateEnum stateEnum, Applicant applicant) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.value = applicant;
        this.count = 1;
    }

    public ApplicantExecution(ApplicantStateEnum stateEnum, List<Applicant> applicantList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        if (applicantList != null) {
            this.valueList = applicantList;
            this.count = applicantList.size();
            if (this.count != 0) {
                this.value = valueList.get(0);
            }
        }
    }
}
