package cn.sicnu.itelites;

import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.util.GenerateUtil;
import org.junit.Test;
import cn.sicnu.itelites.util.MsgUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class UtilTest extends BaseTest {

    @Test
    public void testSendMsg() {
        boolean ret = MsgUtil.send("666666", "15388327166");
        assertEquals(true, ret);
    }

    @Test
    public void testGenerateUtil() {
        Map<String, String> params = new HashMap<>();
        params.put("applicantNum", "2017110104");
        params.put("teamOne", "1");
        Applicant applicant = null;
        try {
             applicant = GenerateUtil.GenerateClass(params, Applicant.class);
            System.out.println(applicant.getApplicantNum());
            System.out.println(applicant.getTeamOne().getTeamId());
            System.out.println(applicant.getTeamOne().getTeamName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        assertEquals(2017110104, (long)applicant.getApplicantNum());
    }
}
