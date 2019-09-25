package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.BaseTest;
import cn.sicnu.itelites.entity.Group;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GroupDaoTest extends BaseTest {
    @Autowired
    private IGroupDAO groupDAO;

    @Test
    public void testAdd() {
        Group group = new Group();
        group.setGroupName("test2");
        group.setGroupDesc("test2");
        group.setCreateTime(new Date());
        group.setLastEditTime(new Date());
        int effectedNum = groupDAO.insertGroup(group);
        assertEquals(1, effectedNum);
    }

    @Test
    public void testChange() {
        Group group = new Group();
        group.setGroupId(1);
        group.setGroupName("test111");
        group.setLastEditTime(new Date());
        group.setGroupDesc("tt");
        int effectedNum = groupDAO.updateGroup(group);
        assertEquals(1,effectedNum);
    }

    @Test
    public void testQuery() {
        Map<String, Object> params = new HashMap<>();
        //params.put("id", 1);

        List<Group> list = groupDAO.queryGroup(params);
        //System.out.println(list.get(0).getGroupName());
        list.forEach(e->{
            System.out.println(e.getGroupName());
        });
        assertEquals(2,list.size());
    }
}
