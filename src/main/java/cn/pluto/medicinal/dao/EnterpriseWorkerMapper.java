package cn.pluto.medicinal.dao;

import cn.pluto.medicinal.pojo.EnterpriseWorker;
import cn.pluto.medicinal.pojo.EnterpriseWorkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseWorkerMapper {
    long countByExample(EnterpriseWorkerExample example);

    int deleteByExample(EnterpriseWorkerExample example);

    int deleteByPrimaryKey(String id);

    int insert(EnterpriseWorker record);

    int insertSelective(EnterpriseWorker record);

    List<EnterpriseWorker> selectByExample(EnterpriseWorkerExample example);

    EnterpriseWorker selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EnterpriseWorker record, @Param("example") EnterpriseWorkerExample example);

    int updateByExample(@Param("record") EnterpriseWorker record, @Param("example") EnterpriseWorkerExample example);

    int updateByPrimaryKeySelective(EnterpriseWorker record);

    int updateByPrimaryKey(EnterpriseWorker record);
}