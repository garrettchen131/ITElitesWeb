package cn.sicnu.itelites.controller.api;

import cn.sicnu.itelites.dto.execution.GroupExecution;
import cn.sicnu.itelites.entity.Group;
import cn.sicnu.itelites.exception.OperationException;
import cn.sicnu.itelites.service.IGroupService;
import cn.sicnu.itelites.view.RestData;
import cn.sicnu.itelites.view.RestError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/group")
public class GroupApi {

    @Autowired
    private IGroupService groupService;

    @GetMapping("/get.do")
    private View getGroup(){
        return new RestData(groupService.getAll().getValueList());
    }

    @PostMapping("/add.do")
    private View addGroup(@RequestBody Group group){
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
