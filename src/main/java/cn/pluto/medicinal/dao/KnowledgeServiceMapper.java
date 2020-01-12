package cn.pluto.medicinal.dao;

import cn.pluto.medicinal.pojo.KnowledgeService;
import cn.pluto.medicinal.pojo.KnowledgeServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeServiceMapper {
    long countByExample(KnowledgeServiceExample example);

    int deleteByExample(KnowledgeServiceExample example);

    int deleteByPrimaryKey(Integer ksid);

    int insert(KnowledgeService record);

    int insertSelective(KnowledgeService record);

    List<KnowledgeService> selectByExample(KnowledgeServiceExample example);

    KnowledgeService selectByPrimaryKey(Integer ksid);

    int updateByExampleSelective(@Param("record") KnowledgeService record, @Param("example") KnowledgeServiceExample example);

    int updateByExample(@Param("record") KnowledgeService record, @Param("example") KnowledgeServiceExample example);

    int updateByPrimaryKeySelective(KnowledgeService record);

    int updateByPrimaryKey(KnowledgeService record);
}