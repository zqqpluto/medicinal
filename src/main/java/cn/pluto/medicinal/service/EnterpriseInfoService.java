package cn.pluto.medicinal.service;

import cn.pluto.medicinal.pojo.EnterpriseWorker;
import cn.pluto.medicinal.pojo.Manufacturer;
import cn.pluto.medicinal.pojo.MenuPower;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.untils.EnterpriseAndUserInfo;
import cn.pluto.medicinal.untils.EnterpriseWorkerAndUserInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zqq
 * @create 2020-04-23-15:44
 */
public interface EnterpriseInfoService {


    /**
     * 添加企业信息
     * @param manufacturer
     * @return
     */
    int addEnterprise(Manufacturer manufacturer);


    /**
     * 获取所有菜单
     * @param user
     * @param enterpriseAndUserInfo
     * @return
     */
    List<MenuPower> getAllMenu(User user, EnterpriseAndUserInfo enterpriseAndUserInfo);

    /**
     * 获取所有菜单
     * @param user
     * @param enterpriseWorkerAndUserInfo
     * @return
     */
    List<MenuPower> getAllMenuWorker(User user, EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo);

    /**
     * 企业账户分页
     * @param page
     * @param size
     * @param userByUserAccount
     * @param userNameSearch
     * @return
     */
    PageInfo<EnterpriseAndUserInfo> getEnterpriseList(Integer page, Integer size, User userByUserAccount, String userNameSearch);

    /**
     * 企业员分页
     * @param page
     * @param size
     * @param userByUserAccount
     * @param userNameSearch
     * @return
     */
    PageInfo<EnterpriseWorkerAndUserInfo> getEnterpriseWorkerList(Integer page, Integer size, User userByUserAccount,
                                                       String userNameSearch);

    /**
     * 通过userid获取企业信息
     * @param user
     * @return
     */
    Manufacturer getEnterpriseInfoByUserid(User user);

    /**
     * 更新企业用户信息
     * @param manufacturer
     * @return
     */
    int updateEnterprise(Manufacturer manufacturer);

    /**
     * 更新权限
     * @param allMenu
     * @param enterpriseAndUserInfo
     * @return
     */
    boolean updateMenu(List<MenuPower> allMenu, EnterpriseAndUserInfo enterpriseAndUserInfo);

    /**
     * 删除企业账户的企业信息
     * @param manufacturer
     * @return
     */
    int delEnterprise(Manufacturer manufacturer);

    /**
     * 添加企业员工信息
     * @param enterpriseWorker
     * @return
     */
    int addEnterpriseEorker(EnterpriseWorker enterpriseWorker);

    /**
     * 通过userid获取员工信息
     * @param user2
     * @return
     */
    EnterpriseWorker getEnterpriseWorkerInfoByUserid(User user2);

    /**
     * 更新企业员工信息
     * @param enterpriseWorker
     * @return
     */
    int updateEnterpriseWorker(EnterpriseWorker enterpriseWorker);

    /**
     * 更新企业员信息
     * @param allMenu
     * @param enterpriseWorkerAndUserInfo
     * @return
     */
    boolean updateMenuWorker(List<MenuPower> allMenu, EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo);

    /**
     * 删除原员工信息
     * @param enterpriseWorker
     * @return
     */
    int delEnterpriseWorker(EnterpriseWorker enterpriseWorker);
}
