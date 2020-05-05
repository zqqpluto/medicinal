package cn.pluto.medicinal.dao;

import cn.pluto.medicinal.pojo.GovInfo;
import cn.pluto.medicinal.pojo.GovInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GovInfoMapper {
    long countByExample(GovInfoExample example);

    int deleteByExample(GovInfoExample example);

    int deleteByPrimaryKey(String govId);

    int insert(GovInfo record);

    int insertSelective(GovInfo record);

    List<GovInfo> selectByExample(GovInfoExample example);

    GovInfo selectByPrimaryKey(String govId);

    int updateByExampleSelective(@Param("record") GovInfo record, @Param("example") GovInfoExample example);

    int updateByExample(@Param("record") GovInfo record, @Param("example") GovInfoExample example);

    int updateByPrimaryKeySelective(GovInfo record);

    int updateByPrimaryKey(GovInfo record);
}