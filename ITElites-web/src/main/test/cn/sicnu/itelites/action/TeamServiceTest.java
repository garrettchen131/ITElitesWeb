package cn.sicnu.itelites.action;

import cn.sicnu.itelites.BaseTest;
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
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("testService");
        teamDTO.setTeamDesc("11111");
        boolean ret = teamService.addTeam(teamDTO);
        assertEquals(true, ret);
    }

    @Test
    public void queryAllTest() {
        List<TeamDTO> list = null;
        try {
            list = teamService.getAllTeam();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        assertEquals(1,list.size());
    }
    @Test
    public void queryByIdTest() {
        TeamDTO teamDTO = null;
        try {
            teamDTO = teamService.getTeamById(1);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        assertEquals("testService",teamDTO.getTeamName());
    }
    @Test
    public void queryByNameTest() {
        TeamDTO teamDTO = teamService.getTeamByName("testService");
        int id = teamDTO.getTeamId();
        assertEquals(1,id);
    }
}
