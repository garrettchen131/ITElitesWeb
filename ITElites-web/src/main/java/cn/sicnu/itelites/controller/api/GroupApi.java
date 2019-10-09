package cn.sicnu.itelites.controller.api;

import cn.sicnu.itelites.dto.execution.GroupExecution;
import cn.sicnu.itelites.entity.Group;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.IGroupService;
import cn.sicnu.itelites.service.ITeamService;
import cn.sicnu.itelites.util.CodeUtil;
import cn.sicnu.itelites.util.GenerateUtil;
import cn.sicnu.itelites.view.RestData;
import cn.sicnu.itelites.view.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Controller
@RequestMapping("/group")
public class GroupApi {

    @Autowired
    private IGroupService groupService;

    @Autowired
    private ITeamService teamService;

    @GetMapping("/get.do")
    private View getGroup(){
        return new RestData(groupService.getAll().getValueList());
    }

    @PostMapping("/add.do")
    private View addGroup(@RequestBody Map<String,String> params, HttpServletRequest request){

        Group group = null;
        try {
            group = GenerateUtil.GenerateClass(params,Group.class);
        } catch (Exception e) {
            return new RestError("未知的出错原因!"); //此处进行验证过后不会出错
        }

        if (group.getTeamId() == null){
            return new RestError("请选择需要添加的大组");
        }
        if (teamService.getTeamById(group.getTeamId()).getState() != 0)
        {
            return new RestError("无此大组");
        }
        GroupExecution execution = null;
        try{
            execution = groupService.addGroup(group);
            if (execution.getState() != 0 && execution.getCount() != 1){
                return new RestError(execution);
            }
        }catch (OperationException e){
            return new RestError(e);
        }catch (RuntimeException e){
            return new RestError(e);
        }
        return new RestData(execution);
    }
}
