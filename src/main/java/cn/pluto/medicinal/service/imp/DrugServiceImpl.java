package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.*;
import cn.pluto.medicinal.pojo.*;
import cn.pluto.medicinal.service.DrugService;
import cn.pluto.medicinal.untils.Examine;
import cn.pluto.medicinal.untils.ExamineFinal;
import cn.pluto.medicinal.untils.ExamineUntil;
import cn.pluto.medicinal.untils.UserUntil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zqq
 * @create 2020-04-28-10:51
 */
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private NonPrescriptionDrugMapper nonPrescriptionDrugMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuPowerMapper menuPowerMapper;

    @Autowired
    private ManufacturerMapper manufacturerMapper;

    /**
     * @Description: addGrug 向数据库添加药品
     * @param: [nonPrescriptionDrug]
     * @return: int
     * @auther: zqq
     * @date: 20/4/28 10:54
     */
    @Override
    public int addDrug(NonPrescriptionDrug nonPrescriptionDrug) {
        return nonPrescriptionDrugMapper.insert(nonPrescriptionDrug);
    }



    /**
     * @Description: getPage  已经提交到审核的分页
     * @param: [page, size, userByUserAccount, nameSearch]
     * @return: com.github.pagehelper.PageInfo<cn.pluto.medicinal.untils.ExamineUntil>
     * @auther: zqq
     * @date: 20/4/29 22:30
     */
    @Override
    public PageInfo<ExamineUntil> getPage(Integer page, Integer size, User userByUserAccount, String nameSearch,
                                          String power) {
        NonPrescriptionDrugExample nonPrescriptionDrugExample = new NonPrescriptionDrugExample();
        NonPrescriptionDrugExample.Criteria criteria = nonPrescriptionDrugExample.createCriteria();
        if (!StringUtils.isEmpty(power)){
            // 政府查看
            criteria.andExamineuseridEqualTo(userByUserAccount.getUserid());
            criteria.andExamineresultEqualTo(ExamineFinal.EXAMINE_NOT_STATE);
        }else {
            // 提交用户查看
            criteria.andUseridEqualTo(userByUserAccount.getUserid());
        }
        if (!StringUtils.isEmpty(nameSearch)){
            criteria.andNnameEqualTo(nameSearch);
        }
        PageHelper.startPage(page, size);
        List<NonPrescriptionDrug> nonPrescriptionDrugs =
                nonPrescriptionDrugMapper.selectByExample(nonPrescriptionDrugExample);
        PageInfo listPageInfo = new PageInfo<>(nonPrescriptionDrugs);

        ManufacturerExample manufacturerExample = new ManufacturerExample();

        ExamineUntil examineUntil = null;
        UserExample userExample = null;
        List<ExamineUntil> examineUntilList = new ArrayList<>();
        for (NonPrescriptionDrug nonPrescriptionDrug : nonPrescriptionDrugs) {
            manufacturerExample.createCriteria().andMidEqualTo(nonPrescriptionDrug.getMid());
            List<Manufacturer> manufacturers = manufacturerMapper.selectByExample(manufacturerExample);
            userExample = new UserExample();
            userExample.createCriteria().andUseridEqualTo(nonPrescriptionDrug.getExamineuserid());
            List<User> users = userMapper.selectByExample(userExample);
            examineUntil = setExamineUntil(nonPrescriptionDrug, manufacturers.get(0), users.get(0));
            examineUntilList.add(examineUntil);
        }
        listPageInfo.setList(examineUntilList);

        return listPageInfo;
    }

    private ExamineUntil setExamineUntil(NonPrescriptionDrug nonPrescriptionDrug, Manufacturer m, User user) {
        ExamineUntil examineUntil = new ExamineUntil();
        examineUntil.setNid(nonPrescriptionDrug.getNid());
        examineUntil.setUserid(nonPrescriptionDrug.getUserid());
        examineUntil.setUsername(user.getUsername());
        examineUntil.setMid(nonPrescriptionDrug.getMid());
        if (nonPrescriptionDrug.getNdcid() == 1){
            examineUntil.setNdcid("乙类");
        }else {
            examineUntil.setNdcid("甲类");
        }
        examineUntil.setNname(nonPrescriptionDrug.getNname());
        examineUntil.setFromdrug(nonPrescriptionDrug.getFromdrug());
        examineUntil.setSpecs(nonPrescriptionDrug.getSpecs());
        examineUntil.setIndication(nonPrescriptionDrug.getIndication());
        examineUntil.setUsetaboo(nonPrescriptionDrug.getUsetaboo());
        examineUntil.setDosageandadministration(nonPrescriptionDrug.getDosageandadministration());
        examineUntil.setBasis(nonPrescriptionDrug.getBasis());
        examineUntil.setRemark(nonPrescriptionDrug.getRemark());
        examineUntil.setBatch(nonPrescriptionDrug.getBatch());
        examineUntil.setNewbatch(nonPrescriptionDrug.getNewbatch());
        examineUntil.setMark(nonPrescriptionDrug.getMark());
        examineUntil.setNewdrugcertificate(nonPrescriptionDrug.getNewdrugcertificate());
        examineUntil.setExaminefailmessage(nonPrescriptionDrug.getExaminefailmessage());
        examineUntil.setExamineresult(nonPrescriptionDrug.getExamineresult());
        examineUntil.setExamineuserid(nonPrescriptionDrug.getExamineuserid());
        examineUntil.setMname(m.getMname());
        return examineUntil;
    }


    /**
     * @Description: getExamine 获取拥有处理审核的政府用户
     * @param: []
     * @return: java.util.List<cn.pluto.medicinal.untils.Examine>
     * @auther: zqq
     * @date: 20/4/29 16:02
     */
    @Override
    public List<Examine> getExamine() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUseraccountLike("G-%");
        List<User> users = userMapper.selectByExample(userExample);
        MenuPowerExample menuPowerExample = null;
        List<Examine> examineList = new ArrayList<>();
        Examine examine = null;
        for (User user : users) {
            menuPowerExample = new MenuPowerExample();
            menuPowerExample.createCriteria()
                    .andUseridEqualTo(user.getUserid())
                    .andMenuIdEqualTo(ExamineFinal.EXAMINE_RESUL_MENUID)
                    .andMenuStateEqualTo(1);
            List<MenuPower> menuPowers = menuPowerMapper.selectByExample(menuPowerExample);
            if (menuPowers.size() == 1){
                examine =  new Examine();
                examine.setLabel(user.getUsername());
                examine.setValue(user.getUserid());
                examineList.add(examine);
            }
        }
        return examineList;
    }


    /**
     * @Description: delDrug 删除已经提交但未审核的药品
     * @param: [nonPrescriptionDrug]
     * @return: boolean
     * @auther: zqq
     * @date: 20/4/30 20:21
     */
    @Override
    public boolean delDrug(NonPrescriptionDrug nonPrescriptionDrug ,Object ...objects) {
        NonPrescriptionDrugExample nonPrescriptionDrugExample = new NonPrescriptionDrugExample();
        NonPrescriptionDrugExample.Criteria criteria = nonPrescriptionDrugExample.createCriteria()
                .andNidEqualTo(nonPrescriptionDrug.getNid());
        if (objects.length == 0){
            criteria.andExamineresultEqualTo(ExamineFinal.EXAMINE_NOT_STATE);
        }
        int i = nonPrescriptionDrugMapper.deleteByExample(nonPrescriptionDrugExample);
        return i == 1 ? true : false;
    }


    /**
     * @Description: drugPass 通过审核
     * @param: [nonPrescriptionDrug]
     * @return: boolean
     * @auther: zqq
     * @date: 20/5/1 10:49
     */
    @Override
    public boolean drugPass(NonPrescriptionDrug nonPrescriptionDrug) {
        int i = nonPrescriptionDrugMapper.updateByPrimaryKeySelective(nonPrescriptionDrug);
        return i == 1 ? true : false;
    }

    /**
     * @Description: notPassDrug 处理不通过是审核
     * @param: [nonPrescriptionDrug]
     * @return: boolean
     * @auther: zqq
     * @date: 20/5/1 10:58
     */
    @Override
    public boolean notPassDrug(NonPrescriptionDrug nonPrescriptionDrug) {
        int i = nonPrescriptionDrugMapper.updateByPrimaryKeySelective(nonPrescriptionDrug);
        return i == 1 ? true : false;
    }

    /**
     * @Description: getSelfAndLowerUserByUserAccount 迭代获取登录账户与子账户拥有审核权力的账户
     * @param: [userUntil]
     * @return: java.util.List<cn.pluto.medicinal.untils.UserUntil>
     * @auther: zqq
     * @date: 20/5/1 14:31
     */
    @Override
    public List<UserUntil> getSelfAndLowerUserByUserAccount(UserUntil userUntil) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andFatheridEqualTo(userUntil.getUserid())
                .andUseraccountLike("G-%");
        List<User> users = userMapper.selectByExample(userExample);
        UserUntil userUntil1 = null;
        List<UserUntil>  untilList = new ArrayList<>();
        if (users.size() != 0){
            for (User user : users) {
                MenuPowerExample menuPowerExample = new MenuPowerExample();
                menuPowerExample.createCriteria().andUseridEqualTo(user.getUserid())
                        .andMenuIdEqualTo(ExamineFinal.EXAMINE_RESUL_MENUID)
                        .andMenuStateEqualTo(1);
                List<MenuPower> menuPowers = menuPowerMapper.selectByExample(menuPowerExample);
                if (menuPowers.size() == 1){
                    userUntil1 = new UserUntil();
                    userUntil1.setUserid(user.getUserid());
                    userUntil1.setUsername(user.getUsername());
                    userUntil1.setUseraccount(user.getUseraccount());
                    userUntil1.setUserUntils(getSelfAndLowerUserByUserAccount(userUntil1));
                    untilList.add(userUntil1);
                }
            }
            return untilList;
        }
        return null;
    }

    /**
     * @Description: getAlreadyExamineList 获取已经审核了的药品的列表
     * @param: [userUntil1, examineUntils]
     * @return: java.util.ArrayList<cn.pluto.medicinal.untils.ExamineUntil>
     * @auther: zqq
     * @date: 20/5/1 15:28
     */
    @Override
    public ArrayList<ExamineUntil> getAlreadyExamineList(UserUntil userUntil1,
                                                         ArrayList<ExamineUntil> examineUntils,
                                                         String power) {
        if (userUntil1.getUserUntils() != null){
            for (UserUntil userUntil : userUntil1.getUserUntils()) {
                examineUntils = getAlreadyExamineList(userUntil, examineUntils, power);
            }
        }
        NonPrescriptionDrugExample nonPrescriptionDrugExample = new NonPrescriptionDrugExample();
        NonPrescriptionDrugExample.Criteria criteria = nonPrescriptionDrugExample.createCriteria();
        if (StringUtils.isEmpty(power)) {
            criteria.andExamineuseridEqualTo(userUntil1.getUserid())
                    .andExamineresultNotEqualTo(ExamineFinal.EXAMINE_NOT_STATE);
        }else {
            criteria.andExamineuseridEqualTo(userUntil1.getUserid())
                    .andExamineresultEqualTo(ExamineFinal.EXAMINE_PASS);
        }
        List<NonPrescriptionDrug> nonPrescriptionDrugs =
                nonPrescriptionDrugMapper.selectByExample(nonPrescriptionDrugExample);
        ExamineUntil examineUntil = null;
        ManufacturerExample manufacturerExample = null;
        if (nonPrescriptionDrugs.size() != 0){
            for (NonPrescriptionDrug drug : nonPrescriptionDrugs) {
                manufacturerExample= new ManufacturerExample();
                manufacturerExample.createCriteria().andMidEqualTo(drug.getMid());
                List<Manufacturer> manufacturers = manufacturerMapper.selectByExample(manufacturerExample);
                examineUntil = setExamineUntil2(userUntil1, drug, manufacturers.get(0));
                examineUntils.add(examineUntil);
            }
        }
        return examineUntils;
    }

    private ExamineUntil setExamineUntil2(UserUntil userUntil1, NonPrescriptionDrug drug, Manufacturer manufacturer) {
        ExamineUntil examineUntil = new ExamineUntil();
        examineUntil.setUserid(userUntil1.getUserid());
        examineUntil.setUsername(userUntil1.getUsername());
        examineUntil.setUseraccount(userUntil1.getUseraccount());
        examineUntil.setMid(userUntil1.getMid());
        examineUntil.setMname(userUntil1.getMname());
        examineUntil.setNid(drug.getNid());
        if (drug.getNdcid() == 1){
            examineUntil.setNdcid("甲类");
        }else if (drug.getNdcid() == 0){
            examineUntil.setNdcid("乙类");
        }
        examineUntil.setNname(drug.getNname());
        examineUntil.setFromdrug(drug.getFromdrug());
        examineUntil.setSpecs(drug.getSpecs());
        examineUntil.setIndication(drug.getIndication());
        examineUntil.setUsetaboo(drug.getUsetaboo());
        examineUntil.setDosageandadministration(drug.getDosageandadministration());
        examineUntil.setBasis(drug.getBasis());
        examineUntil.setRemark(drug.getRemark());
        examineUntil.setBatch(drug.getBatch());
        examineUntil.setNewbatch(drug.getNewbatch());
        examineUntil.setMark(drug.getMark());
        examineUntil.setNewdrugcertificate(drug.getNewdrugcertificate());
        examineUntil.setExamineuserid(drug.getExamineuserid());
        examineUntil.setExamineresult(drug.getExamineresult());
        examineUntil.setExaminefailmessage(drug.getExaminefailmessage());

        examineUntil.setMid(manufacturer.getMid());
        examineUntil.setMname(manufacturer.getMname());
        return examineUntil;
    }


}
