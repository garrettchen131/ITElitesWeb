package cn.sicnu.itelites.enums;

public enum MsgCodeStateEnum {

    INVALID_CODE(-1,"无效的验证码"), WRONG_CODE(-2,"错误的验证码"),
    CREATE_SUCCESS(0, "创建成功"), CREATE_FAIL(1, "创建失败"),
    CHECK_SUCCESS(0, "验证成功"), GET_CODE(-5,"请先获取验证码"),
    CHECK_FAIL(-10,"验证失败")
    ;


    private int state;
    private String stateInfo;

    private MsgCodeStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static MsgCodeStateEnum stateOf(int state) {
        for (MsgCodeStateEnum stateEnum : values()) {
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
