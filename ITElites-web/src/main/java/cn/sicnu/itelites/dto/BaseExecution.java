package cn.sicnu.itelites.dto;

import cn.sicnu.itelites.entity.Group;

import java.util.List;

public class BaseExecution<T> {
    protected int state;
    protected String stateInfo;
    protected int count;
    protected T value;
    protected List<T> valueList;

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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<T> getValueList() {
        return valueList;
    }

    public void setValueList(List<T> valueList) {
        this.valueList = valueList;
    }
}
