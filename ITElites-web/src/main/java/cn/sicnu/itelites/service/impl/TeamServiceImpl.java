package cn.sicnu.itelites.service.impl;

import cn.sicnu.itelites.dao.ITeamDAO;
import cn.sicnu.itelites.dto.TeamExecution;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.TeamStateEnum;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamServiceImpl implements ITeamService {
    @Autowired
    private ITeamDAO teamDAO;

    @Override
    public TeamExecution addTeam(Team team) throws OperationException{
        if (team == null)
        {
            return new TeamExecution(TeamStateEnum.NULL_TEAM);
        }
        //空值时在拦截器中进行拦截，业务不进行判断
        team.setCreateTime(new Date());
        team.setLastEditTime(new Date());
        int effectNum;
        try{
            effectNum = teamDAO.insertTeam(team);
            if (effectNum <= 0) throw new OperationException(-1,"添加失败");   // TODO 这里是抛异常好还是返回对应的状态好？？？
        }catch (RuntimeException e)
        {
            throw e;
        }
        return new TeamExecution(TeamStateEnum.ADD_SUCCESS);
    }

    @Override
    public TeamExecution changeTeam(Team team) throws OperationException{
        int id = team.getTeamId();
        Map<String, Object> params = new HashMap<>();
        params.put("teamId", id);
        List<Team> list;
        try {
            list = teamDAO.queryTeam(params);
            if (list.size() != 1)
            {
                throw new OperationException(-1, "没有次小组！");
            }
        } catch (RuntimeException e) {
            throw e;
        }
        return new TeamExecution(TeamStateEnum.CHANGE_SUCCESS);
    }

    @Override
    public TeamExecution getAllTeam() throws OperationException{
        return new TeamExecution(TeamStateEnum.GET_SUCCESS,teamDAO.queryTeam(null));
    }

    @Override
    public TeamExecution getTeamById(int id) throws OperationException{
        if (id < 1) throw new OperationException(-1, "ID无效");
        Map<String, Object> params = new HashMap<>();
        params.put("teamId", id);
        List<Team> list = teamDAO.queryTeam(params);
        return new TeamExecution(TeamStateEnum.GET_SUCCESS,list);
    }

    @Override
    public TeamExecution getTeamByName(String name) throws OperationException{
        if (name == null || "".equals(name)) throw new OperationException(-1, "Name无效");
        Map<String, Object> params = new HashMap<>();
        params.put("teamName", name);
        return new TeamExecution(TeamStateEnum.GET_SUCCESS,teamDAO.queryTeam(params));
    }

}
