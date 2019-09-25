package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.BaseTest;
import cn.sicnu.itelites.entity.Group;
import cn.sicnu.itelites.entity.Team;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TeamDaoTest extends BaseTest {
    @Autowired
    private ITeamDAO teamDAO;

    @Test
    public void testAdd() {
        Team team = new Team();
        team.setTeamName("team1");
        team.setCreateTime(new Date());
        team.setLastEditTime(new Date());
        int effectedNum = teamDAO.insertTeam(team);
        System.out.println("id ----------------" + team.getTeamId());
        assertEquals(1, effectedNum);
    }

    @Test
    public void testChange() {
        Team team = new Team();
        team.setTeamId(1);
        team.setLastEditTime(new Date());
        team.setTeamDesc("teamDesc");
        int effectedNum = teamDAO.updateTeam(team);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testQuery() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1);
        List<Team> list = teamDAO.queryTeam(params);
        list.forEach(e->{
            System.out.println(e.getTeamName());
        });
        assertEquals(1, list.size());
    }

}
