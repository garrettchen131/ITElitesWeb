package cn.sicnu.itelites.entity;

import java.io.Serializable;
import java.util.Date;

public class SecondHead implements Serializable
{
    private Integer secondHeadId;
    private String secondHeadName;
    private String secondHeadUrl;
    private Integer firstHeadId;
    private Date createTime;
    private Integer valid;
    private String description;
    private Integer priority;


    public SecondHead()
    {
    }

    public String getSecondHeadUrl()
    {
        return secondHeadUrl;
    }

    public void setSecondHeadUrl(String secondHeadUrl)
    {
        this.secondHeadUrl = secondHeadUrl;
    }

    public Integer getPriority()
    {
        return priority;
    }

    public Integer getSecondHeadId()
    {
        return secondHeadId;
    }

    public void setSecondHeadId(Integer secondHeadId)
    {
        this.secondHeadId = secondHeadId;
    }

    public String getSecondHeadName()
    {
        return secondHeadName;
    }

    public void setSecondHeadName(String secondHeadName)
    {
        this.secondHeadName = secondHeadName;
    }

    public Integer getFirstHeadId()
    {
        return firstHeadId;
    }

    public void setFirstHeadId(Integer firstHeadId)
    {
        this.firstHeadId = firstHeadId;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Integer getValid()
    {
        return valid;
    }

    public void setValid(Integer valid)
    {
        this.valid = valid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setPriority(Integer priority)
    {
        this.priority = priority;
    }
}
