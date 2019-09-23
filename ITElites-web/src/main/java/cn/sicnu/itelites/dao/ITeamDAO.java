package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.entity.Team;

import java.util.List;
import java.util.Map;

public interface ITeamDAO {
    public int insertTeam(Team team);

    public int updateTeam(Team team);

    public List<Team> queryTeam(Map<String,Object> params);

}
