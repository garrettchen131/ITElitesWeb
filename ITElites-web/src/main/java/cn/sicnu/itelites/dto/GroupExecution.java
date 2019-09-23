package cn.sicnu.itelites.dto;

import cn.sicnu.itelites.entity.Group;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.GroupStateEnum;
import cn.sicnu.itelites.enums.TeamStateEnum;

import java.util.List;

public class GroupExecution {
    private int state;
    private String stateInfo;
    private int count;
    private Group group;
    private List<Group> groupList;


    public GroupExecution(GroupStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.count = 0;
    }

    public GroupExecution(GroupStateEnum stateEnum, Group group) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.group = group;
        this.count = 1;
    }

    public GroupExecution(GroupStateEnum stateEnum, List<Group> groupList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        if (groupList.size() == 1) {
            this.group = groupList.get(0);
            this.count = 1;
        }
        else {
            this.groupList = groupList;
            this.count = groupList.size();
        }
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
