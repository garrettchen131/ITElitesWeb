package cn.sicnu.itelites.dto.execution;

import cn.sicnu.itelites.dto.BaseExecution;
import cn.sicnu.itelites.entity.Group;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.GroupStateEnum;
import cn.sicnu.itelites.enums.TeamStateEnum;

import java.util.List;

public class GroupExecution extends BaseExecution<Group> {

    public GroupExecution(GroupStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.count = 0;
    }

    public GroupExecution(GroupStateEnum stateEnum, Group group) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.value = group;
        this.count = 1;
    }

    public GroupExecution(GroupStateEnum stateEnum, List<Group> groupList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.value = groupList.get(0);
        this.valueList = groupList;
        this.count = groupList.size();
    }
}
