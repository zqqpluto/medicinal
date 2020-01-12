package cn.pluto.medicinal.dao;

import cn.pluto.medicinal.pojo.KnowledgeClass;
import cn.pluto.medicinal.pojo.KnowledgeClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeClassMapper {
    long countByExample(KnowledgeClassExample example);

    int deleteByExample(KnowledgeClassExample example);

    int deleteByPrimaryKey(Integer kcid);

    int insert(KnowledgeClass record);

    int insertSelective(KnowledgeClass record);

    List<KnowledgeClass> selectByExample(KnowledgeClassExample example);

    KnowledgeClass selectByPrimaryKey(Integer kcid);

    int updateByExampleSelective(@Param("record") KnowledgeClass record, @Param("example") KnowledgeClassExample example);

    int updateByExample(@Param("record") KnowledgeClass record, @Param("example") KnowledgeClassExample example);

    int updateByPrimaryKeySelective(KnowledgeClass record);

    int updateByPrimaryKey(KnowledgeClass record);
}