package cn.sicnu.itelites.controller.api;


import cn.sicnu.itelites.dto.execution.TeamExecution;
import cn.sicnu.itelites.entity.Team;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.ITeamService;
import cn.sicnu.itelites.util.CodeUtil;
import cn.sicnu.itelites.util.GenerateUtil;
import cn.sicnu.itelites.view.RestData;
import cn.sicnu.itelites.view.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Controller
@RequestMapping("/team")
public class TeamApi {
    @Autowired
    private ITeamService teamService;

    @GetMapping("/get.do")
    private View getTeam() {
        return new RestData(teamService.getAllTeam().getValueList());
    }

    @PostMapping("/add.do")
    private View addTeam(@RequestBody Map<String,String> params, HttpServletRequest request) {

        Team team = null;
        try {
            team = GenerateUtil.GenerateClass(params,Team.class);
        } catch (Exception e) {
            return new RestError("未知的出错原因!"); //此处进行验证过后不会出错
        }

        TeamExecution execution = null;
        try {
            execution = teamService.addTeam(team);
            if (execution.getCount() != 1 && execution.getState() != 0) {
                return new RestError(execution);
            }
        } catch (OperationException e) {
            return new RestError(e.getMessage());
        } catch (RuntimeException e) {
            return new RestError(e.getMessage());
        }
        return new RestData(execution);
    }

//    private View changeTeam(@RequestBody Team team) {
//
//    }
}
