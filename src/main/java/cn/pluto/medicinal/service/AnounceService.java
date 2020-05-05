package cn.pluto.medicinal.service;

import cn.pluto.medicinal.pojo.Anounce;
import cn.pluto.medicinal.pojo.GovInfo;
import cn.pluto.medicinal.pojo.Manufacturer;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.untils.AnounceUntil;
import cn.pluto.medicinal.untils.UserUntil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zqq
 * @create 2020-05-05-9:26
 */
public interface AnounceService {

    /**
     * 获取本身及子账户
     * @param userUntil1
     * @return
     */
    List<UserUntil> getSelfAndLowerUserByUserAccount(UserUntil userUntil1);

    /**
     * 添加公告
     * @param anounce
     * @return
     */
    boolean addAnounce(Anounce anounce);

    /**
     * 获取公告列表
     * @param userUntil1
     * @param anounceUntils
     * @param nameSearch
     * @return
     */
    ArrayList<AnounceUntil> getAnounceList(UserUntil userUntil1,
                                           ArrayList<AnounceUntil> anounceUntils, String nameSearch);

    /**
     * 获取企业信息
     * @param userByUserAccount
     * @param b
     * @return
     */
    Manufacturer getExterprise(User userByUserAccount, boolean b);

    /**
     * 获取政府信息
     * @param userByUserAccount
     * @return
     */
    GovInfo getGov(User userByUserAccount);

    /**
     * 删除公告
     * @param anounce
     * @return
     */
    boolean delAounce(Anounce anounce);
}
