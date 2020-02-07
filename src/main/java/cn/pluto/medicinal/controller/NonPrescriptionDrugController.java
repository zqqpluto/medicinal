package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.pojo.NonPrescriptionDrug;
import cn.pluto.medicinal.service.imp.NonPrescriptionDrugServiceImpl;
import cn.pluto.medicinal.untils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CHTW
 * @date 2020-02-05-10:31
 */
@RestController
@RequestMapping("/NonPre")
public class NonPrescriptionDrugController {

    @Autowired
    private NonPrescriptionDrugServiceImpl nonPrescriptionDrugService;

    @RequestMapping("/getNonPre")
    public Result getNonPre(@RequestParam(required = false)Integer ndcid,
                            @RequestParam(required = true,defaultValue = "1")Integer currentPage,
                            @RequestParam(required = true,defaultValue = "40")Integer pageSize,
                            String nName, String mark){
        PageInfo<NonPrescriptionDrug> pageInfo = nonPrescriptionDrugService.getNonPrescriptionDrug(ndcid,currentPage,pageSize,nName,mark);
        if (pageInfo.getList().size()>1){
            return Result.success(pageInfo);
        }else{
            return  Result.success(pageInfo.getList().get(0));
        }

    }

    @RequestMapping("/getById")
    public Result getById(Integer nid){
        return Result.success(nonPrescriptionDrugService.getById(nid));
    }
}
