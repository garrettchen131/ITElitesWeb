package cn.sicnu.itelites.dto;

import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.TeamStateEnum;

import java.util.List;

public class TeamExecution {
    private int state;
    private String stateInfo;
    private int count;
    private List<Team> teamList;


    public TeamExecution(TeamStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public TeamExecution(TeamStateEnum stateEnum, List<Team> teamList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.teamList = teamList;
        this.count = teamList.size();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
