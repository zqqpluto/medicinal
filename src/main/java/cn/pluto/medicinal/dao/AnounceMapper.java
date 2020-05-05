package cn.pluto.medicinal.dao;

import cn.pluto.medicinal.pojo.Anounce;
import cn.pluto.medicinal.pojo.AnounceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnounceMapper {
    long countByExample(AnounceExample example);

    int deleteByExample(AnounceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Anounce record);

    int insertSelective(Anounce record);

    List<Anounce> selectByExampleWithBLOBs(AnounceExample example);

    List<Anounce> selectByExample(AnounceExample example);

    Anounce selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Anounce record, @Param("example") AnounceExample example);

    int updateByExampleWithBLOBs(@Param("record") Anounce record, @Param("example") AnounceExample example);

    int updateByExample(@Param("record") Anounce record, @Param("example") AnounceExample example);

    int updateByPrimaryKeySelective(Anounce record);

    int updateByPrimaryKeyWithBLOBs(Anounce record);

    int updateByPrimaryKey(Anounce record);
}