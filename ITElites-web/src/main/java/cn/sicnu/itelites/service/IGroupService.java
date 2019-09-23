package cn.sicnu.itelites.service;

import cn.sicnu.itelites.dto.GroupExecution;
import cn.sicnu.itelites.entity.Group;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IGroupService {
    @Transactional
    public boolean addGroup(Group group);

    @Transactional
    public boolean change(Group group);

    @Transactional(readOnly = true)
    public GroupExecution getAll();

    @Transactional(readOnly = true)
    public GroupExecution getGroupById(int id);

    @Transactional(readOnly = true)
    public GroupExecution getGroupByName(String name);
}
