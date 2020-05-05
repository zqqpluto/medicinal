package cn.pluto.medicinal.service;

import cn.pluto.medicinal.pojo.NonPrescriptionDrug;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.untils.Examine;
import cn.pluto.medicinal.untils.ExamineUntil;
import cn.pluto.medicinal.untils.UserUntil;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zqq
 * @create 2020-04-28-10:45
 */
public interface DrugService {

    /**
     * 添加药品
     * @param nonPrescriptionDrug
     * @return
     */
    int addDrug(NonPrescriptionDrug nonPrescriptionDrug);

    /**
     * 添加审核的状态
     * @param examine
     * @return
     */
//    int addExamine(Examine examine);

    /**
     * 药品分页
     * @param userByUserAccount
     * @return
     */
    PageInfo<ExamineUntil> getPage(Integer page, Integer size, User userByUserAccount, String NameSearch, String power);

    /**
     * 获取拥有权限进行审批的用户列表
     * @return
     */
    List<Examine> getExamine();

    /**
     * 删除审核药品
     * @param nonPrescriptionDrug
     * @return
     */
    boolean delDrug(NonPrescriptionDrug nonPrescriptionDrug, Object ...objects);

    /**
     * 通过审核
     * @param nonPrescriptionDrug
     * @return
     */
    boolean drugPass(NonPrescriptionDrug nonPrescriptionDrug);

    /**
     * 不通过审核
     * @param nonPrescriptionDrug
     * @return
     */
    boolean notPassDrug(NonPrescriptionDrug nonPrescriptionDrug);

    /**
     * 获取该用户创建的所有政府账户拥有审核权限的子账号
     * @param userUntil
     * @return
     */
    List<UserUntil> getSelfAndLowerUserByUserAccount(UserUntil userUntil);

    /**
     * 获取列表已经审核的药品列表
     * @param userUntil1
     * @param examineUntils
     * @return
     */
    ArrayList<ExamineUntil> getAlreadyExamineList(UserUntil userUntil1, ArrayList<ExamineUntil> examineUntils,
                                                  String power, String nameSearch);


}
