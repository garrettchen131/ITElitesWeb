package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.entity.Group;

import java.util.List;

public interface IGroupDAO {

    public List<Group> queryGroup();

    public Group queryGroupById(int id);

    public int insertGroup(Group group);

    public int updateGroup(Group group);
}
