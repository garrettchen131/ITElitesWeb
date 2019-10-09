package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.BaseTest;
import cn.sicnu.itelites.entity.Applicant;
import cn.sicnu.itelites.entity.Team;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ApplicantDaoTest extends BaseTest {

    @Autowired
    private IApplicantDAO applicantDAO;

    @Test
    public void insertTest()
    {
        Team teamone = new Team();
        teamone.setTeamId(1);

        Team teamtwo = new Team();
        teamtwo.setTeamId(2);

        Applicant applicant = new Applicant();
        applicant.setApplicantName("陈朝金");
        applicant.setApplicantNum(2017110103L);
        applicant.setCreateTime(new Date());
        applicant.setLastEditTime(new Date());
        applicant.setPhone("15388327167");
        applicant.setQq("974212452");
        applicant.setTeamOne(teamtwo);
        applicant.setTeamTwo(teamone);

        int effectiveNum = 0;
        try {
            effectiveNum = applicantDAO.insertApplicant(applicant);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(effectiveNum,1);
    }
}
