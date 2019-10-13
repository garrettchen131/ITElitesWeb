package cn.sicnu.itelites.dto.execution;

import cn.sicnu.itelites.dto.BaseExecution;
import cn.sicnu.itelites.entity.FirstHead;
import cn.sicnu.itelites.enums.FirstHeadStateEnum;

import java.util.List;

public class FirstHeadExecution extends BaseExecution<FirstHead> {

    public FirstHeadExecution(FirstHeadStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public FirstHeadExecution(FirstHeadStateEnum stateEnum, FirstHead firstHead) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.value = firstHead;
    }

    public FirstHeadExecution(FirstHeadStateEnum stateEnum, List<FirstHead> firstHeadList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        if (firstHeadList != null) {
            this.valueList = firstHeadList;
            this.count = firstHeadList.size();
            if (this.count != 0) {
                this.value = valueList.get(0);
            }
        }
    }
}
