package cn.sicnu.itelites.service.impl;

import cn.sicnu.itelites.dao.IGroupDAO;
import cn.sicnu.itelites.dto.execution.GroupExecution;
import cn.sicnu.itelites.entity.Group;
import cn.sicnu.itelites.enums.GroupStateEnum;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    private IGroupDAO groupDAO;

    @Override
    public GroupExecution addGroup(Group group) throws OperationException {
        if (group == null) {
            return new GroupExecution(GroupStateEnum.NULL_GROUP);
        }
        if (group.getTeamId() == null || group.getTeamId() < 1) {
            return new GroupExecution(GroupStateEnum.NULL_TEAM_ID);
        }
        group.setCreateTime(new Date());
        group.setLastEditTime(new Date());
        try{
            int effectNum = groupDAO.insertGroup(group);
            if (effectNum <= 0) throw new OperationException(GroupStateEnum.ADD_FAIL.getState(),GroupStateEnum.ADD_FAIL.getStateInfo());
        }catch (RuntimeException e) {
            throw e;
        }
        return new GroupExecution(GroupStateEnum.ADD_SUCCESS,group);
    }

    @Override
    public GroupExecution change(Group group) {
        if (group == null) return new GroupExecution(GroupStateEnum.NULL_GROUP);
        int groupId = group.getGroupId();
        Map<String, Object> params = new HashMap<>();
        params.put("GroupId", groupId);
        try {
            List<Group> list = groupDAO.queryGroup(params);
            if (list.size() == 0){
                return new GroupExecution(GroupStateEnum.NULL_GROUP);
            }else {
                try {
                    group.setLastEditTime(new Date());
                    int effectNum = groupDAO.updateGroup(group);
                    if (effectNum <= 0) throw new OperationException(GroupStateEnum.CHANGE_FAIL.getState(), GroupStateEnum.CHANGE_FAIL.getStateInfo());
                }catch (RuntimeException e){
                    throw e;
                }
            }
        }catch (RuntimeException e){
            throw e;
        }
        return new GroupExecution(GroupStateEnum.CHANGE_SUCCESS,group);
    }

    @Override
    public GroupExecution getAll() {
        return new GroupExecution(GroupStateEnum.GET_SUCCESS,groupDAO.queryGroup(null));
    }

    @Override
    public GroupExecution getGroupById(int id) {
        if (id < 1) return new GroupExecution(GroupStateEnum.INVALID_ID);
        Map<String, Object> params = new HashMap<>();
        params.put("groupId", id);
        return new GroupExecution(GroupStateEnum.GET_SUCCESS,groupDAO.queryGroup(params));
    }

    @Override
    public GroupExecution getGroupByName(String name) {
        if (name == null || "".equals(name)) return new GroupExecution(GroupStateEnum.INVALID_NAME);
        Map<String, Object> params = new HashMap<>();
        params.put("groupName", name);
        return new GroupExecution(GroupStateEnum.GET_SUCCESS,groupDAO.queryGroup(params));
    }
}
