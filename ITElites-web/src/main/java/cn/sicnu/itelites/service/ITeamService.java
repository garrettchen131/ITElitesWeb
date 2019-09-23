package cn.sicnu.itelites.service;

import cn.sicnu.itelites.dto.TeamExecution;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.exception.OperationException;
import org.springframework.transaction.annotation.Transactional;


public interface ITeamService {
    @Transactional
    public TeamExecution addTeam(Team team) throws OperationException;

    @Transactional
    public TeamExecution changeTeam(Team team) throws OperationException;

    @Transactional(readOnly = true)
    public TeamExecution getAllTeam() throws OperationException;

    @Transactional(readOnly = true)
    public TeamExecution getTeamById(int id) throws OperationException;

    @Transactional(readOnly = true)
    public TeamExecution getTeamByName(String name) throws OperationException;
}
