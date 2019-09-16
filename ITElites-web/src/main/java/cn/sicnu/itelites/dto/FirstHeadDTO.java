package cn.sicnu.itelites.dto;

public class FirstHeadDTO
{
    private Integer id;
    private String name;
    private String url;
    private Integer priority;

    public FirstHeadDTO()
    {
    }

    public FirstHeadDTO(Integer id, String name, String url, Integer priority)
    {
        this.id = id;
        this.name = name;
        this.url = url;
        this.priority = priority;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
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
