package cn.sicnu.itelites.entity;

import java.io.Serializable;
import java.util.Date;

public class Team implements Serializable {
    private Integer teamId;
    private String teamName;
    private Date createTime;
    private Date lastEditTime;
    private String teamDesc;

    public Team() {
    }

    public Team(TeamDTO teamDTO) {
        this.setTeamId(teamDTO.getTeamId());
        this.setTeamDesc(teamDTO.getTeamDesc());
        this.setTeamName(teamDTO.getTeamName());
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
