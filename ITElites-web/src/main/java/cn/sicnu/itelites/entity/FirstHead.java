package cn.sicnu.itelites.entity;

import java.io.Serializable;
import java.util.Date;

public class FirstHead implements Serializable
{

    private Integer firstHeadId;
    private String firstHeadName;
    private String firstHeadUrl;
    private Date createTime;
    private Integer valid;
    private Integer priority;

    public FirstHead()
    {
    }

    public String getFirstHeadUrl()
    {
        return firstHeadUrl;
    }

    public void setFirstHeadUrl(String firstHeadUrl)
    {
        this.firstHeadUrl = firstHeadUrl;
    }

    public Integer getFirstHeadId()
    {
        return firstHeadId;
    }

    public void setFirstHeadId(Integer firstHeadId)
    {
        this.firstHeadId = firstHeadId;
    }

    public String getFirstHeadName()
    {
        return firstHeadName;
    }

    public void setFirstHeadName(String firstHeadName)
    {
        this.firstHeadName = firstHeadName;
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

    public Integer getPriority()
    {
        return priority;
    }

    public void setPriority(Integer priority)
    {
        this.priority = priority;
    }
}
