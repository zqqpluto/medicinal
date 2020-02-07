package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.NonPrescriptionDrugMapper;
import cn.pluto.medicinal.pojo.KnowledgeService;
import cn.pluto.medicinal.pojo.NonPrescriptionDrug;
import cn.pluto.medicinal.pojo.NonPrescriptionDrugExample;
import cn.pluto.medicinal.service.NonPrescriptionDrugService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.rmi.CORBA.Util;
import java.util.List;

/**
 * @author CHTW
 * @date 2020-02-05-10:18
 */
@Service
public class NonPrescriptionDrugServiceImpl implements NonPrescriptionDrugService {
    @Autowired
    private NonPrescriptionDrugMapper nonPrescriptionDrugMapper;

    /**
     * 根据Id获取药品
     * @param nid 药品id
     * @return
     */
    @Override
    public NonPrescriptionDrug getById(Integer nid) {
        NonPrescriptionDrug nonPrescriptionDrug = nonPrescriptionDrugMapper.selectByPrimaryKey(nid);

        return nonPrescriptionDrug;
    }

    /**
     * 根据条件查询药品信息
     * @param ndcid 分类 甲类 or 乙类
     * @param currentPage 分页参数，当前页码
     * @param pageSize 分页参数，页码大小
     * @param nName 查询条件，药品名称
     * @param mark 查询条件，药品条形码
     * @return
     */
    @Override
    public PageInfo<NonPrescriptionDrug> getNonPrescriptionDrug(Integer ndcid, Integer currentPage, Integer pageSize, String nName, String mark) {
        NonPrescriptionDrugExample example = new NonPrescriptionDrugExample();
        NonPrescriptionDrugExample.Criteria re = example.createCriteria();

        if(!StringUtils.isEmpty(mark)){
            re.andMarkEqualTo(mark);
        }else{
            re.andNdcidEqualTo(ndcid);
            if(!StringUtils.isEmpty(nName)){
                re.andNnameEqualTo(nName);
            }
        }
        PageHelper.startPage(currentPage,pageSize);
        List<NonPrescriptionDrug> NList = nonPrescriptionDrugMapper.selectByExample(example);
        PageInfo<NonPrescriptionDrug> pageInfo = new PageInfo<NonPrescriptionDrug>(NList);
        return pageInfo;
    }

}
