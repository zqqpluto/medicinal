package cn.pluto.medicinal.service;

import cn.pluto.medicinal.pojo.NonPrescriptionDrug;
import com.github.pagehelper.PageInfo;

/**
 * @author CHTW
 * @date 2020-02-05-10:14
 */
public interface NonPrescriptionDrugService {
    public NonPrescriptionDrug getById(Integer nid);

    public PageInfo<NonPrescriptionDrug> getNonPrescriptionDrug(Integer ndcid, Integer currentPage, Integer pageSize, String nName, String mark);
}


