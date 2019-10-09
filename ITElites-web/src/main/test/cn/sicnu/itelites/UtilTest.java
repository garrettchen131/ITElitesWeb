package cn.sicnu.itelites;

import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.exception.ValidationException;
import cn.sicnu.itelites.util.GenerateUtil;
import org.junit.Test;
import cn.sicnu.itelites.util.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class UtilTest extends BaseTest {
    @Autowired
    private MessageSource messageSource;

    @Test
    public void testSendMsg() {
        boolean ret = MsgUtil.send("666666", "15388327166");
        assertEquals(true, ret);
    }

    @Test
    public void testGenerateUtil() {

        System.out.println(messageSource.toString());
        String value = messageSource.getMessage("Applicant.applicantNum", null, "没有", Locale.ENGLISH);
        System.out.println(value);
//        Map<String, String> params = new HashMap<>();
//        params.put("applicantNum", "2017110104");
//        params.put("teamOne", "1");
//        Applicant applicant = null;
//        try {
//            applicant = GenerateUtil.GenerateClass(params, Applicant.class);
//            System.out.println(applicant.getApplicantNum());
//            System.out.println(applicant.getTeamOne().getTeamId());
//            System.out.println(applicant.getTeamOne().getTeamName());
//        } catch (ValidationException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        assertEquals(2017110104, (long)applicant.getApplicantNum());
    }
}
