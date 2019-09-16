package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.entity.Team;

import java.util.List;

public interface ITeamDAO {
    public int insertTeam();

    public int updateTeam();

    public List<Team> queryTeam();

    public Team queryTeamById();
}
