package cn.sicnu.itelites.entity;

import cn.sicnu.itelites.Annotation.ValidationFlied;

import java.io.Serializable;
import java.util.Date;

public class Applicant implements Serializable {
    @ValidationFlied(key = "Applicant.applicantId")
    private Integer applicantId;  //数据库自动生成的学生ID主键

    @ValidationFlied(notNull = true,key = "Applicant.applicantNum")
    private Long applicantNum;    //学号

    @ValidationFlied(notNull = true,key = "Applicant.applicantName")
    private String applicantName; //学生姓名

    @ValidationFlied(notNull = true,key = "Applicant.phone")
    private String phone;       //电话号码

    @ValidationFlied(notNull = true,key = "Applicant.qq")
    private String qq;          //学生QQ
    private Date createTime;    //创建时间
    private Date lastEditTime;  //最后修改时间
    private Team teamPass;      //通过的大组

    @ValidationFlied(notNull = true,key = "Applicant.teamOne")
    private Team teamOne;       //大组第一志愿

    @ValidationFlied(notNull = true,key = "Applicant.teamTwo")
    private Team teamTwo;       //大组第二志愿
    private String teamReason;  //填写加入IT培优的感受
    private Integer validate;   //当前状态（-1、未通过，0、等待中，1、通过）
    private Group groupPass;    //通过的小组
    private Group groupOne;     //小组第一志愿
    private Group groupTwo;     //小组第二志愿
    private String groupReason;  //填写你所选择小组的感受？？？

    public Applicant() {
    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public Long getApplicantNum() {
        return applicantNum;
    }

    public void setApplicantNum(Long applicantNum) {
        this.applicantNum = applicantNum;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
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

    public String getTeamReason() {
        return teamReason;
    }

    public void setTeamReason(String teamReason) {
        this.teamReason = teamReason;
    }

    public String getGroupReason() {
        return groupReason;
    }

    public void setGroupReason(String groupReason) {
        this.groupReason = groupReason;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
