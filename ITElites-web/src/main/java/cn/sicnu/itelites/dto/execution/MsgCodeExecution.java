package cn.sicnu.itelites.dto.execution;

import cn.sicnu.itelites.dto.BaseExecution;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.enums.ApplicantStateEnum;
import cn.sicnu.itelites.enums.MsgCodeStateEnum;

import java.util.List;

public class MsgCodeExecution extends BaseExecution<String> {

    public MsgCodeExecution(MsgCodeStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

}
