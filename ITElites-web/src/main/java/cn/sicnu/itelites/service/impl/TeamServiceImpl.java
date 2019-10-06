package cn.sicnu.itelites.service.impl;

import cn.sicnu.itelites.dao.ITeamDAO;
import cn.sicnu.itelites.dto.execution.TeamExecution;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.enums.TeamStateEnum;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.ITeamService;
import cn.sicnu.itelites.view.RestError;
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
        if (team.getTeamName() == null || "".equals(team.getTeamName())) {
            return new TeamExecution(TeamStateEnum.INVALID_NAME);
        }
        //空值时在拦截器中进行拦截，业务不进行判断
        team.setCreateTime(new Date());
        team.setLastEditTime(new Date());
        int effectNum;
        try{
            effectNum = teamDAO.insertTeam(team);
            if (effectNum <= 0) throw new OperationException(TeamStateEnum.ADD_FAIL.getState(),TeamStateEnum.ADD_FAIL.getStateInfo());   // TODO 这里是抛异常好还是返回对应的状态好？？？
        }catch (RuntimeException e)
        {
            throw e;
        }
        return new TeamExecution(TeamStateEnum.ADD_SUCCESS,team);
    }

    @Override
    public TeamExecution changeTeam(Team team) throws OperationException{
        int id = team.getTeamId();
        Map<String, Object> params = new HashMap<>();
        params.put("teamId", id);
        try {
            List<Team> list = teamDAO.queryTeam(params);
            if (list.size() == 0) {
                return new TeamExecution(TeamStateEnum.NULL_TEAM);  //这里我认为应该采用返回的形式而非抛出异常（2019.9.23）
            }
            else {
                try{
                    int effectNum = teamDAO.updateTeam(team);
                    if (effectNum <= 0) throw new OperationException(TeamStateEnum.CHANGE_FAIL.getState(),TeamStateEnum.CHANGE_FAIL.getStateInfo());
                }catch (RuntimeException e) {
                    throw e;
                }
            }
        } catch (RuntimeException e) {
            throw e;
        }
        return new TeamExecution(TeamStateEnum.CHANGE_SUCCESS,team);
    }

    @Override
    public TeamExecution getAllTeam(){
        return new TeamExecution(TeamStateEnum.GET_SUCCESS,teamDAO.queryTeam(null));
    }

    @Override
    public TeamExecution getTeamById(int id){
        if (id < 1) return new TeamExecution(TeamStateEnum.INVALID_ID);
        Map<String, Object> params = new HashMap<>();
        params.put("teamId", id);
        List<Team> list = teamDAO.queryTeam(params);
        return new TeamExecution(TeamStateEnum.GET_SUCCESS,list);
    }

    @Override
    public TeamExecution getTeamByName(String name){
        if (name == null || "".equals(name)) return new TeamExecution(TeamStateEnum.INVALID_NAME);
        Map<String, Object> params = new HashMap<>();
        params.put("teamName", name);
        return new TeamExecution(TeamStateEnum.GET_SUCCESS,teamDAO.queryTeam(params));
    }

}
