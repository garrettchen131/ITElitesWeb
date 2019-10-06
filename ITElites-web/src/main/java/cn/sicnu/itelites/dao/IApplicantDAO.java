package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.entity.Applicant;

import java.util.List;
import java.util.Map;

public interface IApplicantDAO {

    public List<Applicant> queryApplicant(Map<String, Object> params);

    public int insertApplicant(Applicant applicant);

    public int changeApplicant(Applicant applicant);

}
