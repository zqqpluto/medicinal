package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.MenuPowerMapper;
import cn.pluto.medicinal.dao.UserMapper;
import cn.pluto.medicinal.pojo.MenuPower;
import cn.pluto.medicinal.pojo.MenuPowerExample;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.pojo.UserExample;
import cn.pluto.medicinal.service.LoginService;
import cn.pluto.medicinal.untils.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author zqq
 * @create 2020-04-12-11:24
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuPowerMapper menuPowerMapper;

    private UserExample userExample;

    /**
     * @Description: login  登录判断
     * @param: [user]
     * @return: int   0 表示账号密码正确
     * 1 表示密码错误
     * -1 表示账号不存在
     * @auther: zqq
     * @date: 20/4/12 11:28
     */
    @Override
    public int login(User user) {
        // 账号密码正确
        int code = 0;
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseraccountEqualTo(user.getUseraccount());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 1) {
            if (!users.get(0).getUserpassword().equals(user.getUserpassword())) {
                // 密码错误
                code = 1;
            }
        } else {
            // 账号不存在
            code = -1;
        }
        return code;
    }

    /**
     * @Description: getUserByUserAccount 通账号获取user信息
     * @param: [user]
     * @return: cn.pluto.medicinal.pojo.User
     * @auther: zqq
     * @date: 20/4/13 10:20
     */
    @Override
    public User getUserByUserAccount(User user) {
        userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseraccountEqualTo(user.getUseraccount());
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0);
    }

    /**
     * @Description: getMenuByUserId 通过userid获取登录账户的id
     * @param: [user]
     * @return: java.util.List<cn.pluto.medicinal.pojo.MenuPower>
     * @auther: zqq
     * @date: 20/4/13 10:29
     */
    @Override
    public List<Menu> getMenuByUserId(User user) {
        MenuPowerExample menuPowerExample = new MenuPowerExample();
        MenuPowerExample.Criteria criteria = menuPowerExample.createCriteria();
        criteria.andUseridEqualTo(user.getUserid());
        List<MenuPower> menuPowers = menuPowerMapper.selectByExample(menuPowerExample);
        List<Menu> menuList = getMenus(menuPowers);
        return menuList;
    }

    /**
     * @Description: getMenus  修改权限菜单格式
     * @param: [menuPowers]
     * @return: java.util.List<cn.pluto.medicinal.untils.Menu>
     * @auther: zqq
     * @date: 20/4/13 15:06
     */
    private List<Menu> getMenus(List<MenuPower> menuPowers) {
        List<Menu> menuList = new ArrayList<>();
        Menu m = null;
        for (MenuPower menuPower : menuPowers) {
            if (StringUtils.isEmpty(menuPower.getMenuFarherId())) {
                m = new Menu();
                m.setId(menuPower.getMenuId());
                m.setIcon(menuPower.getIcon());
                m.setIndex(menuPower.getMenuPath());
                m.setTitle(menuPower.getMenuName());
                menuList.add(m);
            }
        }
        for (Menu mp : menuList) {
            List<Menu> mpl = new ArrayList<>();
            for (MenuPower menuPower : menuPowers) {

                if (menuPower.getMenuFarherId() != null
                        && menuPower.getMenuFarherId().equals(mp.getId())
                        && menuPower.getMenuState() == 1 || mp.getId().equals("103") && menuPower.getMenuId().equals(
                                "103-2")) {
                    m = new Menu();
                    m.setId(menuPower.getMenuId());
                    m.setIcon(menuPower.getIcon());
                    m.setIndex(menuPower.getMenuPath());
                    m.setTitle(menuPower.getMenuName());
                    mpl.add(m);
                }
            }
            mp.setSubs(mpl);
        }



        for (Menu menu : menuList) {
            if (menu.getId().equals("103")){
                for (Menu sub : menu.getSubs()) {
                    if (sub.getId().equals("103-2")){
                        List<Menu> mpl = new ArrayList<>();
                        for (MenuPower menuPower : menuPowers) {
                            if (menuPower.getMenuFarherId() != null
                                    && menuPower.getMenuFarherId().equals("103-2")
                                    && menuPower.getMenuState() == 1) {
                                m = new Menu();
                                m.setId(menuPower.getMenuId());
                                m.setIcon(menuPower.getIcon());
                                m.setIndex(menuPower.getMenuPath());
                                m.setTitle(menuPower.getMenuName());
                                mpl.add(m);
                            }
                        }
                        sub.setSubs(mpl);
                    }
                }
            }
        }
        Iterator<Menu> iterator = menuList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getSubs().size() == 0){
                iterator.remove();
            }
        }


        return menuList;
    }
}
