package cn.sicnu.itelites.dto.execution;

import cn.sicnu.itelites.dto.BaseExecution;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.TeamStateEnum;

import java.util.List;

public class TeamExecution extends BaseExecution<Team> {

    public TeamExecution(TeamStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public TeamExecution(TeamStateEnum stateEnum, Team team) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.value = team;
        this.count = 1;
    }

    public TeamExecution(TeamStateEnum stateEnum, List<Team> teamList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        if (teamList != null) {
            this.valueList = teamList;
            this.count = teamList.size();
            if (this.count != 0) {
                this.value = valueList.get(0);
            }
        }
    }
}
