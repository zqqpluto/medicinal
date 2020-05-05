package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.GovInfoMapper;
import cn.pluto.medicinal.dao.ManufacturerMapper;
import cn.pluto.medicinal.dao.MenuPowerMapper;
import cn.pluto.medicinal.dao.UserMapper;
import cn.pluto.medicinal.pojo.*;
import cn.pluto.medicinal.service.UserService;
import cn.pluto.medicinal.untils.GovAndUserInfo;
import cn.pluto.medicinal.untils.Menus;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zqq
 * @create 2020-04-15-21:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuPowerMapper menuPowerMapper;

    @Autowired
    private GovInfoMapper govInfoMapper;

    @Autowired
    private ManufacturerMapper manufacturerMapper;

    /**
     * @Description: addUser  添加账户信息
     * @param: [user]
     * @return: int
     * @auther: zqq
     * @date: 20/4/15 21:59
     */
    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * @Description: addGov  添加政府信息
     * @param: [govInfo]
     * @return: int
     * @auther: zqq
     * @date: 20/4/15 22:04
     */
    @Override
    public int addGov(GovInfo govInfo) {
        return govInfoMapper.insert(govInfo);
    }

    /**
     * @Description: getMenus 获取权限菜单
     * @param: [user]
     * @return: java.util.List<cn.pluto.medicinal.untils.Menus>
     * @auther: zqq
     * @date: 20/4/16 19:56
     */
    @Override
    public List<Menus> getMenus(User user) {
        MenuPowerExample menuPowerExample = new MenuPowerExample();
        MenuPowerExample.Criteria criteria = menuPowerExample.createCriteria();
        criteria.andUseridEqualTo(user.getUserid());
        List<MenuPower> menuPowers = menuPowerMapper.selectByExample(menuPowerExample);
        List<Menus> menuList = getMenusList(menuPowers);
        return menuList;
    }


    /**
     * @Description: getMenusList 对菜单进一步封装
     * @param: [menuPowers]
     * @return: java.util.List<cn.pluto.medicinal.untils.Menus>
     * @auther: zqq
     * @date: 20/4/16 19:57
     */
    private List<Menus> getMenusList(List<MenuPower> menuPowers) {
        List<Menus> menuList = new ArrayList<>();
        Menus m = null;
        for (MenuPower menuPower : menuPowers) {
            if (StringUtils.isEmpty(menuPower.getMenuFarherId())) {
                m = new Menus();
                m.setId(menuPower.getMenuId());
                m.setName(menuPower.getMenuName());
                menuList.add(m);
            }
        }
        for (Menus mp : menuList) {
            List<Menus> mpl = new ArrayList<>();
            for (MenuPower menuPower : menuPowers) {
                if (menuPower.getMenuFarherId() != null
                        && menuPower.getMenuFarherId().equals(mp.getId())
                        && menuPower.getMenuState() == 1 || mp.getId().equals("103") && menuPower.getMenuId().equals(
                        "103-2")) {
                    m = new Menus();
                    m.setId(menuPower.getMenuId());
                    m.setName(menuPower.getMenuName());
                    mpl.add(m);
                }
            }
            mp.setChildren(mpl);
        }

        for (Menus menu : menuList) {
            if (menu.getId().equals("103")) {
                for (Menus sub : menu.getChildren()) {
                    if (sub.getId().equals("103-2")) {
                        List<Menus> mpl = new ArrayList<>();
                        for (MenuPower menuPower : menuPowers) {
                            if (menuPower.getMenuFarherId() != null
                                    && menuPower.getMenuFarherId().equals(sub.getId())
                                    && menuPower.getMenuState() == 1) {
                                m = new Menus();
                                m.setId(menuPower.getMenuId());
                                m.setName(menuPower.getMenuName());
                                mpl.add(m);
                            }
                        }
                        sub.setChildren(mpl);
                    }
                }
            }
        }

        Iterator<Menus> iterator = menuList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getChildren().size() == 0){
                iterator.remove();
            }
        }

        return menuList;
    }

    /**
     * @Description: getAllMenu 获取当前账户所有权限,并根据前端传递的菜单id，转换子账户的权限
     * @param: [user]
     * @return: java.util.List<cn.pluto.medicinal.pojo.MenuPower>
     * @auther: zqq
     * @date: 20/4/17 10:41
     */
    @Override
    public List<MenuPower> getAllMenu(User user, GovAndUserInfo govAndUserInfo) {
        MenuPowerExample menuPowerExample = new MenuPowerExample();
        MenuPowerExample.Criteria criteria = menuPowerExample.createCriteria();
        criteria.andUseridEqualTo(user.getUserid());
        List<MenuPower> menuPowers = menuPowerMapper.selectByExample(menuPowerExample);
        // 切换为未拥有状态 默认为1 表示拥有   0表示不具有该权限
        for (MenuPower menuPower : menuPowers) {
            if (!govAndUserInfo.getMenuNumList().contains(menuPower.getMenuId())) {
                menuPower.setMenuState(0);
            }
        }
        return menuPowers;
    }



    /**
     * @Description: addMenu 为账户添加权限菜单那
     * @param: [allMenu]
     * @return: boolean
     * @auther: zqq
     * @date: 20/4/17 11:15
     */
    @Override
    public boolean addMenu(List<MenuPower> allMenu) {
        int num = 0;
        for (MenuPower menu : allMenu) {
            menu.setId(null);
            int insert = menuPowerMapper.insert(menu);
            num += insert;
        }
        return num == allMenu.size();
    }

    /**
     * @Description: checkUserExit 检查user是否存在
     * @param: [user]
     * @return: int
     * @auther: zqq
     * @date: 20/4/17 15:17
     */
    @Override
    public int checkUserExit(User user) {
        UserExample u = new UserExample();
        UserExample.Criteria criteria = u.createCriteria();
        criteria.andUseraccountEqualTo(user.getUseraccount());
        List<User> users = userMapper.selectByExample(u);
        return users.size();
    }


    /**
     * @Description: getGovList 政府帐号分页
     * @param: [page, size, user, userNameSearch]
     * @return: com.github.pagehelper.PageInfo<cn.pluto.medicinal.untils.GovAndUserInfo>
     * @auther: zqq
     * @date: 20/4/22 11:06
     */
    @Override
    public PageInfo<GovAndUserInfo> getGovList(Integer page, Integer size, @NotNull User user, String userNameSearch) {
        List<GovAndUserInfo> govAndUserInfos = new ArrayList<>();
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("userAccount asc");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andFatheridEqualTo(user.getUserid());
        criteria.andUseraccountLike("G-%");
        if (!StringUtils.isEmpty(userNameSearch)){
            criteria.andUsernameLike("%" + userNameSearch + "%");
        }
        PageHelper.startPage(page, size);
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo govAndUserInfoPageInfo = new PageInfo(users);
        GovAndUserInfo govAndUserInfo = null;
        for (User u : users) {
            GovInfoExample govInfoExample = new GovInfoExample();
            GovInfoExample.Criteria criteria1 = govInfoExample.createCriteria();
            criteria1.andUseridEqualTo(u.getUserid());
            List<GovInfo> govInfos = govInfoMapper.selectByExample(govInfoExample);
            if (govInfos.size() == 1){
                govAndUserInfo = setValue(u, govInfos.get(0));
                govAndUserInfos.add(govAndUserInfo);
            }
        }
        govAndUserInfoPageInfo.setList(govAndUserInfos);
        return govAndUserInfoPageInfo;
    }

    /**
     * @Description: setValue 设置GovAndUserInfo的值
     * @param: [u, govInfo]
     * @return: cn.pluto.medicinal.untils.GovAndUserInfo
     * @auther: zqq
     * @date: 20/4/22 10:59
     */
    private GovAndUserInfo setValue(User u, GovInfo govInfo) {
        GovAndUserInfo govAndUserInfo = new GovAndUserInfo();
        govAndUserInfo.setId(u.getUserid());
        govAndUserInfo.setUserAccount(u.getUseraccount());
        govAndUserInfo.setUserName(u.getUsername());
        govAndUserInfo.setGovermentDepartment(govInfo.getGovDep());
        govAndUserInfo.setGovermentMan(govInfo.getGovMan());
        govAndUserInfo.setGovermentPhone(govInfo.getGovPho());
        govAndUserInfo.setGovermentPhoneSelf(govInfo.getGovPhoneSelf());
        govAndUserInfo.setGovermentAddrsss(govInfo.getGovAddress());
        govAndUserInfo.setFatherName(u.getFathername());
        return govAndUserInfo;
    }

    /**
     * @Description: getSelectMenu  获取拥有的权限
     * @param: [menuPower]
     * @return: java.util.List<java.lang.String>
     * @auther: zqq
     * @date: 20/4/22 18:50
     */
    @Override
    public List<String> getSelectMenu(MenuPower menuPower) {
        MenuPowerExample menuPowerExample = new MenuPowerExample();
        MenuPowerExample.Criteria criteria = menuPowerExample.createCriteria();
        criteria.andUseridEqualTo(menuPower.getUserid());
        criteria.andMenuStateEqualTo(1);
        List<MenuPower> menuPowers = menuPowerMapper.selectByExample(menuPowerExample);
        ArrayList<String> strings = new ArrayList<>();
        for (MenuPower power : menuPowers) {
            strings.add(power.getMenuId());
        }
        return strings;
    }

    /**
     * @Description: updateUser 更新用户信息
     * @param: [user2]
     * @return: int
     * @auther: zqq
     * @date: 20/4/22 20:37
     */
    @Override
    public int updateUser(User user2) {
        if (StringUtils.isEmpty(user2.getUserpassword())){
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUseridEqualTo(user2.getUserid());
            List<User> users = userMapper.selectByExample(userExample);
            user2.setUserpassword(users.get(0).getUserpassword());
        }
        return userMapper.updateByPrimaryKey(user2);
    }

    /**
     * @Description: updateGov 更新政府账户的信息
     * @param: [govInfo]
     * @return: int
     * @auther: zqq
     * @date: 20/4/22 20:44
     */
    @Override
    public int updateGov(GovInfo govInfo) {
        GovInfoExample govInfoExample = new GovInfoExample();
        GovInfoExample.Criteria criteria = govInfoExample.createCriteria();
        criteria.andUseridEqualTo(govInfo.getUserid());
        criteria.andGovIdEqualTo(govInfo.getGovId());
        return govInfoMapper.updateByExample(govInfo,govInfoExample);
    }

    /**
     * @Description: updateMenu  更新权限菜单
     * @param: [allMenu, govAndUserInfo]
     * @return: boolean
     * @auther: zqq
     * @date: 20/4/22 20:55
     */
    @Override
    public boolean updateMenu(List<MenuPower> allMenu, GovAndUserInfo govAndUserInfo) {
        int a = 0;
        for (MenuPower menu : allMenu) {
            if (govAndUserInfo.getMenuNumList().contains(menu.getMenuId())){
                menu.setMenuState(1);
            }
            int i = menuPowerMapper.updateByPrimaryKey(menu);
            a += i;
        }
        return allMenu.size() == a ? true : false;
    }

    /**
     * @Description: getGovInfoByUserid 通过userid获取政府账户信息
     * @param: [govAndUserInfo]
     * @return: cn.pluto.medicinal.pojo.GovInfo
     * @auther: zqq
     * @date: 20/4/22 22:01
     */
    @Override
    public GovInfo getGovInfoByUserid(GovAndUserInfo govAndUserInfo) {
        GovInfoExample govInfoExample = new GovInfoExample();
        GovInfoExample.Criteria criteria = govInfoExample.createCriteria();
        criteria.andUseridEqualTo(govAndUserInfo.getId());
        List<GovInfo> govInfos = govInfoMapper.selectByExample(govInfoExample);
        return govInfos.get(0);
    }

    /**
     * @Description: delUser 根据userid和删除账户信息
     * @param: [user]
     * @return: int
     * @auther: zqq
     * @date: 20/4/23 12:39
     */
    @Override
    public int delUser(User user) {
        return userMapper.deleteByPrimaryKey(user.getUserid());
    }

    /**
     * @Description: delGov 删除政府账户的政府信息
     * @param: [govInfo]
     * @return: int
     * @auther: zqq
     * @date: 20/4/23 13:01
     */
    @Override
    public int delGov(GovInfo govInfo) {
        GovInfoExample govInfoExample = new GovInfoExample();
        GovInfoExample.Criteria criteria = govInfoExample.createCriteria();
        criteria.andUseridEqualTo(govInfo.getUserid());
        return govInfoMapper.deleteByExample(govInfoExample);
    }

    /**
     * @Description: delMenu 删除用户的权限
     * @param: [power]
     * @return: void
     * @auther: zqq
     * @date: 20/4/23 14:18
     */
    @Override
    public void delMenu(MenuPower power) {
        MenuPowerExample menuPowerExample = new MenuPowerExample();
        MenuPowerExample.Criteria criteria = menuPowerExample.createCriteria();
        criteria.andUseridEqualTo(power.getUserid());
        menuPowerMapper.deleteByExample(menuPowerExample);
    }


}
