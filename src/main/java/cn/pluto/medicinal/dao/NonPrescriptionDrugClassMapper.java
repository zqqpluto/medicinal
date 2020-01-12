package cn.pluto.medicinal.dao;

import cn.pluto.medicinal.pojo.NonPrescriptionDrugClass;
import cn.pluto.medicinal.pojo.NonPrescriptionDrugClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NonPrescriptionDrugClassMapper {
    long countByExample(NonPrescriptionDrugClassExample example);

    int deleteByExample(NonPrescriptionDrugClassExample example);

    int deleteByPrimaryKey(Integer ndcid);

    int insert(NonPrescriptionDrugClass record);

    int insertSelective(NonPrescriptionDrugClass record);

    List<NonPrescriptionDrugClass> selectByExample(NonPrescriptionDrugClassExample example);

    NonPrescriptionDrugClass selectByPrimaryKey(Integer ndcid);

    int updateByExampleSelective(@Param("record") NonPrescriptionDrugClass record, @Param("example") NonPrescriptionDrugClassExample example);

    int updateByExample(@Param("record") NonPrescriptionDrugClass record, @Param("example") NonPrescriptionDrugClassExample example);

    int updateByPrimaryKeySelective(NonPrescriptionDrugClass record);

    int updateByPrimaryKey(NonPrescriptionDrugClass record);
}