package cn.sicnu.itelites.dto;

import cn.sicnu.itelites.entity.FirstHead;
import cn.sicnu.itelites.enums.FirstHeadStateEnum;

import java.util.List;

public class FirstHeadExecution {
    private int state;
    private String stateInfo;
    private int count;
    private FirstHead firstHead;
    private List<FirstHead> firstHeadList;


    public FirstHeadExecution(FirstHeadStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public FirstHeadExecution(FirstHeadStateEnum stateEnum, FirstHead firstHead) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.firstHead = firstHead;
    }

    public FirstHeadExecution(FirstHeadStateEnum stateEnum, List<FirstHead> firstHeadList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.firstHeadList = firstHeadList;
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

    public FirstHead getFirstHead() {
        return firstHead;
    }

    public void setFirstHead(FirstHead firstHead) {
        this.firstHead = firstHead;
    }

    public List<FirstHead> getFirstHeadList() {
        return firstHeadList;
    }

    public void setFirstHeadList(List<FirstHead> firstHeadList) {
        this.firstHeadList = firstHeadList;
    }
}
