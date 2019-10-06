package cn.sicnu.itelites.enums;

public enum ApplicantStateEnum {

    ADD_SUCCESS(0, "添加成功"),ADD_FAIL(-1,"添加失败"),
    CHANGE_SUCCESS(0,"修改成功"),CHANGE_FAIL(-2,"修改失败"),
    GET_SUCCESS(0, "查询成功"),NULL_APPLICANT(-1,"无申请人"),
    INCOMPLETE(-3, "不完整的信息")
    ;


    private int state;
    private String stateInfo;

    private ApplicantStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ApplicantStateEnum stateOf(int state) {
        for (ApplicantStateEnum stateEnum : values()) {
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
