package cn.sicnu.itelites.dto;

import cn.sicnu.itelites.entity.Group;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.TeamStateEnum;

import java.util.List;

public class GroupExecution {
    private int state;
    private String stateInfo;
    private int count;
    private List<Group> groupList;


    public GroupExecution(TeamStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public GroupExecution(TeamStateEnum stateEnum, List<Group> groupList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.groupList = groupList;
        this.count = groupList.size();
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

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }
}
