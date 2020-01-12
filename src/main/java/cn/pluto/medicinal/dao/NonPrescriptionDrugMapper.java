package cn.pluto.medicinal.dao;

import cn.pluto.medicinal.pojo.NonPrescriptionDrug;
import cn.pluto.medicinal.pojo.NonPrescriptionDrugExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NonPrescriptionDrugMapper {
    long countByExample(NonPrescriptionDrugExample example);

    int deleteByExample(NonPrescriptionDrugExample example);

    int deleteByPrimaryKey(Integer nid);

    int insert(NonPrescriptionDrug record);

    int insertSelective(NonPrescriptionDrug record);

    List<NonPrescriptionDrug> selectByExample(NonPrescriptionDrugExample example);

    NonPrescriptionDrug selectByPrimaryKey(Integer nid);

    int updateByExampleSelective(@Param("record") NonPrescriptionDrug record, @Param("example") NonPrescriptionDrugExample example);

    int updateByExample(@Param("record") NonPrescriptionDrug record, @Param("example") NonPrescriptionDrugExample example);

    int updateByPrimaryKeySelective(NonPrescriptionDrug record);

    int updateByPrimaryKey(NonPrescriptionDrug record);
}