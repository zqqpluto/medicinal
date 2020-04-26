package cn.pluto.medicinal.service;

import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.untils.Menu;

import java.util.List;

/**
 * @author zqq
 * @create 2020-04-12-11:21
 */
public interface LoginService {

    /**
     * 用户是userAccount
     */
    String SESSION_USER = "";

    /**
     * 处理登录
     * @param user
     * @return
     */
    int  login(User user);

    /**
     * 通过userAccount账户，获取user信息
     * @param user
     * @return
     */
    User getUserByUserAccount(User user);

    /**
     * 获取登录账户的权限菜单
     * @param user
     * @return
     */
    List<Menu> getMenuByUserId(User user);

}
