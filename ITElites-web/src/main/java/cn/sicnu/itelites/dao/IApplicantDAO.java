package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.entity.Applicant;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IApplicantDAO {

    public List<Applicant> queryApplicant(Map<String, Object> params);

    public int insertApplicant(Applicant applicant) throws SQLException;

    public int changeApplicant(Applicant applicant) throws SQLException;

}
