package cn.sicnu.itelites.enums;

public enum FirstHeadStateEnum {

    SUCCESS(0, "成功");

    private int state;
    private String stateInfo;

    private FirstHeadStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static FirstHeadStateEnum stateOf(int state) {
        for (FirstHeadStateEnum stateEnum : values()) {
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
