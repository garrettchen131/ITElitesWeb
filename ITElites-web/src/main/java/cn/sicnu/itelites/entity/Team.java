package cn.sicnu.itelites.entity;

import java.io.Serializable;
import java.util.Date;

public class Team implements Serializable {
    private Integer teamId;     //数据库自动生成的ID主键
    private String teamName;    //大组名称
    private Date createTime;    //创建时间
    private Date lastEditTime;  //最后修改时间
    private String teamDesc;    //大组信息描述

    public Team() {
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public String getTeamDesc() {
        return teamDesc;
    }

    public void setTeamDesc(String teamDesc) {
        this.teamDesc = teamDesc;
    }
}
