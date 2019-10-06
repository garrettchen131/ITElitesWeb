package cn.sicnu.itelites.dao;

import cn.sicnu.itelites.entity.Team;

import java.util.List;
import java.util.Map;

/**
 * 表tb_team所对应的Dao层操作
 */
public interface ITeamDAO {
    /**
     * 向tb_team表中插入一个大组信息
     * @param team 所插入大组的对象，此对象中不应包含ID
     * @return 返回影响的行数
     */
    public int insertTeam(Team team);

    /**
     * 在tb_team表中更新一条信息
     * @param team 所更新的大组对象，此对象中必须包含ID
     * @return 返回影响的行数
     */
    public int updateTeam(Team team);

    /**
     * 从表中查询
     * @param params 当params为null时，表示查询全部
     *               当params有teamId的Key时，表示查询指定ID的Team
     *               当params有teamName的key时，表示查询指定Name的Team
     * @return  以List的形式返回查询结果
     */
    public List<Team> queryTeam(Map<String,Object> params);

}
