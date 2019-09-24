package cn.sicnu.itelites.action;

import cn.sicnu.itelites.BaseTest;
import cn.sicnu.itelites.dto.execution.GroupExecution;
import cn.sicnu.itelites.entity.Group;
import cn.sicnu.itelites.service.IGroupService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class GroupServiceTest extends BaseTest {

    @Autowired
    private IGroupService groupService;

    @Test
    public void addTest()
    {
        Group group = new Group();
        group.setTeamId(2);
        group.setGroupName("视频组");
        group.setGroupDesc("拍照啦！");
        try {
            GroupExecution execution = groupService.addGroup(group);
            assertEquals(0, execution.getState());
            assertEquals(2, (int)group.getGroupId());
            assertEquals(1, execution.getCount());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeTest()
    {
        Group group = new Group();
        group.setGroupId(1);
        group.setGroupName("Java");
        group.setGroupDesc("learn java and more");
        try {
            GroupExecution execution = groupService.change(group);
            assertEquals(0, execution.getState());
            assertEquals(1, execution.getCount());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllTest()
    {
        try {
            GroupExecution execution = groupService.getAll();
            assertEquals(0, execution.getState());
            assertEquals(2, execution.getCount());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGroupByIdTest()
    {
        try {
            GroupExecution execution = groupService.getGroupById(1);
            assertEquals(0, execution.getState());
            assertEquals("Java", execution.getValue().getGroupName());
            assertEquals(3, (int)execution.getValue().getTeamId());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getGroupByNameTest()
    {
        try {
            GroupExecution execution = groupService.getGroupByName("Java");
            assertEquals(0, execution.getState());
            assertEquals(1, (int)execution.getValue().getGroupId());
            assertEquals(3, (int)execution.getValue().getTeamId());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
