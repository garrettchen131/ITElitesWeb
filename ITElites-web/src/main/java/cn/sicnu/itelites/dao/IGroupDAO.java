package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.entity.Group;

import java.util.List;
import java.util.Map;

public interface IGroupDAO {

    public List<Group> queryGroup(Map<String,Object> params);

    public int insertGroup(Group group);

    public int updateGroup(Group group);


}
