package cn.sicnu.itelites.enums;

public enum GroupStateEnum {

    ADD_SUCCESS(0, "添加成功"), ADD_FAIL(-1, "添加失败"), NULL_GROUP(404, "空值"),
    CHANGE_SUCCESS(0, "修改成功"), CHANGE_FAIL(-2, "修改失败"),GET_SUCCESS(0, "查询成功"), NULL_TEAM_ID(-3, "大组空值"),
    NULL_TEAM(-5, "无此大组"),INVALID_ID(-5,"无效的ID"),INVALID_NAME(-5,"无效的NAME")
    ;

    private int state;
    private String stateInfo;

    private GroupStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static GroupStateEnum stateOf(int state) {
        for (GroupStateEnum stateEnum : values()) {
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
