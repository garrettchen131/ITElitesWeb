package cn.sicnu.itelites.enums;

public enum TeamStateEnum {

    ADD_SUCCESS(0, "添加成功"),ADD_FAIL(-1,"添加失败"),NULL_TEAM(404,"空值"),
    CHANGE_SUCCESS(0,"修改成功"),CHANGE_FAIL(-2,"修改失败"),GET_SUCCESS(0,"查询成功"),
    INVALID_ID(-5,"无效的ID"),INVALID_NAME(-5,"无效的NAME");

    private int state;
    private String stateInfo;

    private TeamStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static TeamStateEnum stateOf(int state) {
        for (TeamStateEnum stateEnum : values()) {
            if (stateEnum.state == state) {
                return stateEnum;
            }
        }
        return null;
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
}
