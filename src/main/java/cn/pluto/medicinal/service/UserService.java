package cn.pluto.medicinal.service;

import cn.pluto.medicinal.pojo.GovInfo;
import cn.pluto.medicinal.pojo.MenuPower;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.untils.GovAndUserInfo;
import cn.pluto.medicinal.untils.Menus;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zqq
 * @create 2020-04-15-21:53
 */
public interface UserService {

    /**
     * 添加账户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 添加政府信息
     * @param govInfo
     * @return
     */
    int addGov(GovInfo govInfo);

    /**
     * 获取添加用户的菜单
     * @param user
     * @return
     */
    List<Menus> getMenus(User user);

    /**
     * 获取当前登录账户的全部菜单
     * @param user
     * @return
     */
    List<MenuPower> getAllMenu(User user, GovAndUserInfo govAndUserInfo);


    /**
     * 添加菜单
     * @param allMenu
     * @return
     */
    boolean addMenu(List<MenuPower> allMenu);

    /**
     * 检查添加的用户是否已经存在
     * @param user
     * @return
     */
    int checkUserExit(User user);



    /**
     * 列表分页
     * @param page 当前页
     * @param size 页面大小
     * @param user 当前登录用户的user
     * @param userNameSearch 查询条件
     * @return
     */
    PageInfo<GovAndUserInfo> getGovList(Integer page, Integer size, User user, String userNameSearch);

    /**
     * 获取拥有的权限的菜单的菜单id
     * @param menuPower
     * @return
     */
    List<String> getSelectMenu(MenuPower menuPower);

    /**
     * 更新用户信息
     * @param user2
     * @return
     */
    int updateUser(User user2);

    /**
     * 更新政府账户的信息
     * @param govInfo
     * @return
     */
    int updateGov(GovInfo govInfo);


    /**
     * 更新权限
     * @param allMenu
     * @param govAndUserInfo
     * @return
     */
    boolean updateMenu(List<MenuPower> allMenu, GovAndUserInfo govAndUserInfo);

    /**
     *
     * @param govAndUserInfo
     * @return
     */
    GovInfo getGovInfoByUserid(GovAndUserInfo govAndUserInfo);

    /**
     * 删除政府账户的用户信息
     * @param user
     * @return
     */
    int delUser(User user);

    /**
     * 删除政府帐号信息的政府信息
     * @param govInfo
     * @return
     */
    int delGov(GovInfo govInfo);

    /**
     * 根据userid删除权限
     * @param power
     * @return
     */
    void delMenu(MenuPower power);

}
