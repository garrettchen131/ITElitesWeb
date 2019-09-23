package cn.sicnu.itelites.entity;

import java.io.Serializable;

public class StudentRegister implements Serializable {
    private Integer studentId;
    private Long studentNum;
    private String studentName;
    private String phone;
    private String qq;
    private Team teamPass;
    private Team teamOne;
    private Team teamTwo;
    private Integer validate;
    private Group groupPass;
    private Group groupOne;
    private Group groupTwo;

    public StudentRegister() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Long getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Long studentNum) {
        this.studentNum = studentNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Team getTeamPass() {
        return teamPass;
    }

    public void setTeamPass(Team teamPass) {
        this.teamPass = teamPass;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public Integer getValidate() {
        return validate;
    }

    public void setValidate(Integer validate) {
        this.validate = validate;
    }

    public Group getGroupPass() {
        return groupPass;
    }

    public void setGroupPass(Group groupPass) {
        this.groupPass = groupPass;
    }

    public Group getGroupOne() {
        return groupOne;
    }

    public void setGroupOne(Group groupOne) {
        this.groupOne = groupOne;
    }

    public Group getGroupTwo() {
        return groupTwo;
    }

    public void setGroupTwo(Group groupTwo) {
        this.groupTwo = groupTwo;
    }
}
