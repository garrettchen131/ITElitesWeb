package cn.sicnu.itelites.action;

import cn.sicnu.itelites.BaseTest;
import cn.sicnu.itelites.dto.TeamExecution;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.service.ITeamService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TeamServiceTest extends BaseTest {
    @Autowired
    private ITeamService teamService;

    @Test
    public void addTest() {
        Team team = new Team();
        team.setTeamName("编程组");
        team.setTeamDesc("learn coding");
        try{
            TeamExecution execution = teamService.addTeam(team);
            assertEquals(1,execution.getCount());
            assertEquals(3,(int)execution.getTeam().getTeamId());
        }catch (RuntimeException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void changeTest() {
        Team team = new Team();
        team.setTeamId(2);
        team.setTeamName("美工组");
        team.setTeamDesc("meigongzu");
        try{
            TeamExecution execution = teamService.changeTeam(team);
            assertEquals(1,execution.getCount());
            assertEquals(2,(int)execution.getTeam().getTeamId());
            assertEquals(0,execution.getState());
        }catch (RuntimeException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllTeamTest() {
        try{
            TeamExecution execution = teamService.getAllTeam();
            assertEquals(3,execution.getCount());
            assertEquals(0,execution.getState());
        }catch (RuntimeException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void getTeamByIdTest() {
        try{
            TeamExecution execution = teamService.getTeamById(3);
            assertEquals(1,execution.getCount());
            assertEquals("编程组",execution.getTeam().getTeamName());
            assertEquals(0,execution.getState());
        }catch (RuntimeException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void getTeamByNameTest() {
        try{
            TeamExecution execution = teamService.getTeamByName("编程组");
            assertEquals(1,execution.getCount());
            assertEquals(3,(int)execution.getTeam().getTeamId());
            assertEquals(0,execution.getState());
        }catch (RuntimeException e)
        {
            e.printStackTrace();
        }
    }

}
