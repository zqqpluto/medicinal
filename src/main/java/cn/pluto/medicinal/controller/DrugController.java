package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.pojo.Manufacturer;
import cn.pluto.medicinal.pojo.NonPrescriptionDrug;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.service.imp.DrugServiceImpl;
import cn.pluto.medicinal.service.imp.EnterpriseInfoServiceImpl;
import cn.pluto.medicinal.service.imp.LoginServiceImpl;
import cn.pluto.medicinal.untils.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author zqq
 * @create 2020-04-27-19:14
 */
@RestController
public class DrugController {

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private EnterpriseInfoServiceImpl enterpriseInfoService;

    @Autowired
    private DrugServiceImpl drugService;


    /**
     * @Description: addDrug 处理添加药品审核请求
     * @param: [examineUntil]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/28 10:58
     */
    @PostMapping("/drug")
    @CrossOrigin
    @Transactional
    public Result addDrug(@RequestBody ExamineUntil examineUntil){
        User user = new User();
        user.setUseraccount(examineUntil.getUseraccount());
        User userByUserAccount = loginService.getUserByUserAccount(user);
        Manufacturer enterpriseInfoByUserid = enterpriseInfoService.getEnterpriseInfoByUserid(userByUserAccount);
        NonPrescriptionDrug nonPrescriptionDrug = setDrug(userByUserAccount, enterpriseInfoByUserid, examineUntil);
        int i = drugService.addDrug(nonPrescriptionDrug);
        return i == 1 ? Result.success("提交成功") : Result.fail(404,"提交失败请重试");
    }

    /**
     * @Description: pageDrug 处理当前账户的提交的审核分页显示请求
     * @param: [page, size, userName, NameSearch]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/29 22:22
     */
    @GetMapping("/drug")
    @CrossOrigin
    public Result pageDrug(@RequestParam(required = true,defaultValue = "1") Integer page,
                                      @RequestParam(required = true,defaultValue = "10") Integer size,
                                      @RequestParam(required = true) String userName,
                                      @RequestParam(required = true) String nameSearch,
                                      @RequestParam(required = false) String power){
        User user = new User();
        user.setUseraccount(userName);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        PageInfo<ExamineUntil> pageInfo = drugService.getPage(page, size,  userByUserAccount, nameSearch,power);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data", pageInfo.getList());
        stringObjectHashMap.put("total", pageInfo.getTotal());
        return Result.success(stringObjectHashMap);
    }

    /**
     * @Description: examine 处理获取拥有审核权限的列表
     * @param: []
     * @return: java.util.List<cn.pluto.medicinal.untils.Examine>
     * @auther: zqq
     * @date: 20/4/29 16:04
     */
    @GetMapping("/examineUser")
    @CrossOrigin
    public List<Examine> examine(){
        List<Examine> examine = drugService.getExamine();
        return  examine;
    }


    /**
     * @Description: setDrug 设置药品信息
     * @param: [userByUserAccount, enterpriseInfoByUserid, examineUntil]
     * @return: cn.pluto.medicinal.pojo.NonPrescriptionDrug
     * @auther: zqq
     * @date: 20/4/28 10:34
     */
    private NonPrescriptionDrug setDrug(User userByUserAccount, Manufacturer enterpriseInfoByUserid, ExamineUntil examineUntil) {
        NonPrescriptionDrug nonPrescriptionDrug = new NonPrescriptionDrug();
        nonPrescriptionDrug.setNid(UUID.randomUUID().toString());
        nonPrescriptionDrug.setUserid(userByUserAccount.getUserid());
        nonPrescriptionDrug.setMid(enterpriseInfoByUserid.getMid());
        nonPrescriptionDrug.setNdcid(Integer.valueOf(examineUntil.getNdcid()));
        nonPrescriptionDrug.setNname(examineUntil.getNname());
        nonPrescriptionDrug.setFromdrug(examineUntil.getFromdrug());
        nonPrescriptionDrug.setSpecs(examineUntil.getSpecs());
        nonPrescriptionDrug.setIndication(examineUntil.getIndication());
        nonPrescriptionDrug.setUsetaboo(examineUntil.getUsetaboo());
        nonPrescriptionDrug.setDosageandadministration(examineUntil.getDosageandadministration());
        nonPrescriptionDrug.setBasis(examineUntil.getBasis());
        nonPrescriptionDrug.setRemark(examineUntil.getRemark());
        nonPrescriptionDrug.setBatch(examineUntil.getBatch());
        nonPrescriptionDrug.setNewbatch(examineUntil.getNewbatch());
        nonPrescriptionDrug.setMark(examineUntil.getMark());
        nonPrescriptionDrug.setNewdrugcertificate(examineUntil.getNewdrugcertificate());
        nonPrescriptionDrug.setExamineresult(ExamineFinal.EXAMINE_NOT_STATE);
        nonPrescriptionDrug.setExamineuserid(examineUntil.getExamineuserid());
        return nonPrescriptionDrug;
    }


    /**
     * @Description: delGov 处理删除提交审核的药品的请求
     * @param: [nid]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/30 20:23
     */
    @DeleteMapping("/drug/{nid}")
    @CrossOrigin
    @Transactional
    public Result delDrug(@PathVariable String nid){
        NonPrescriptionDrug nonPrescriptionDrug = new NonPrescriptionDrug();
        nonPrescriptionDrug.setNid(nid);
        boolean bool = drugService.delDrug(nonPrescriptionDrug);
        return bool ? Result.success("删除成功") : Result.fail(404, "已审核，不能删除");
    }

    /**
     * @Description: examineDrug 处理通过审核
     * @param: [nid]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/1 10:42
     */
    @GetMapping("/examine")
    @CrossOrigin
    public Result examineDrug(@RequestParam String nid){
        NonPrescriptionDrug nonPrescriptionDrug = new NonPrescriptionDrug();
        nonPrescriptionDrug.setNid(nid);
        nonPrescriptionDrug.setExamineresult(ExamineFinal.EXAMINE_PASS);
        boolean bool = drugService.drugPass(nonPrescriptionDrug);
        if (bool){
            return Result.success("通过审核");
        }else {
            return Result.fail(404, "审核失败");
        }
    }

    /**
     * @Description: examineDrugFail 处理不通过的审核请求
     * @param: [examineUntil]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/1 10:59
     */
    @PostMapping("/examine")
    @CrossOrigin
    public Result examineDrugFail(@RequestBody ExamineUntil examineUntil){
        NonPrescriptionDrug nonPrescriptionDrug = new NonPrescriptionDrug();
        nonPrescriptionDrug.setNid(examineUntil.getNid());
        nonPrescriptionDrug.setExamineresult(ExamineFinal.EXAMINE_NOT_PASS);
        nonPrescriptionDrug.setExaminefailmessage(examineUntil.getExaminefailmessage());
        boolean bool = drugService.notPassDrug(nonPrescriptionDrug);
        if (bool){
            return Result.success("成功");
        }else {
            return Result.fail(404, "失败，请重试");
        }
    }

    /**
     * @Description: examineNote 处理查询已经审核请求 分页
     * @param: [page, size, userName, nameSearch]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/1 15:33
     */
    @GetMapping("/examineNote")
    @CrossOrigin
    public Result examineNote(@RequestParam(required = true,defaultValue = "1") Integer page,
                           @RequestParam(required = true,defaultValue = "10") Integer size,
                           @RequestParam(required = true) String userName,
                           @RequestParam(required = false) String nameSearch,
                              @RequestParam(required = false) String power){
        User user = new User();
        user.setUseraccount(userName);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        UserUntil userUntil1 = new UserUntil();
        userUntil1.setUserid(userByUserAccount.getUserid());
        userUntil1.setUseraccount(userByUserAccount.getUseraccount());
        userUntil1.setUsername(userByUserAccount.getUsername());
        List<UserUntil> selfAndLowerUserByUserAccount = drugService.getSelfAndLowerUserByUserAccount(userUntil1);
        userUntil1.setUserUntils(selfAndLowerUserByUserAccount);

        ArrayList<ExamineUntil> examineUntils = new ArrayList<>();
        examineUntils = drugService.getAlreadyExamineList(userUntil1, examineUntils, power, nameSearch);

        PageInfo<ExamineUntil> pageInfo = PageInfoUtils.list2PageInfo(examineUntils, page, size);

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data", pageInfo.getList());
        stringObjectHashMap.put("total", pageInfo.getTotal());
        return Result.success(stringObjectHashMap);
    }


    /**
     * @Description: delExamineDrug 处理删除请求
     * @param: [nid]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/4 21:23
     */
    @DeleteMapping("/examineDrug/{nid}")
    @CrossOrigin
    @Transactional
    public Result delExamineDrug(@PathVariable String nid){
        NonPrescriptionDrug nonPrescriptionDrug = new NonPrescriptionDrug();
        nonPrescriptionDrug.setNid(nid);
        boolean bool = drugService.delDrug(nonPrescriptionDrug, "删除已经通过审核的药品");
        return bool ? Result.success("删除成功") : Result.fail(404, "删除失败");
    }

}
