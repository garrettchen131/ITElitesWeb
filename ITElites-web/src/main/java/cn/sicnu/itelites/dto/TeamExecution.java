package cn.sicnu.itelites.dto;

import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.TeamStateEnum;

import java.util.List;

public class TeamExecution {
    private int state;
    private String stateInfo;
    private int count;
    private Team team;
    private List<Team> teamList;


    public TeamExecution(TeamStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public TeamExecution(TeamStateEnum stateEnum, Team team) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.team = team;
        this.count = 1;
    }

    public TeamExecution(TeamStateEnum stateEnum, List<Team> teamList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        if (teamList.size() == 1) {
            this.team = teamList.get(0);
            this.count = 1;
        }else {
            this.teamList = teamList;
            this.count = teamList.size();
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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
