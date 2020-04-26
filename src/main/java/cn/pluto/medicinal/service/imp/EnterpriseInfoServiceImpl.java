package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.ManufacturerMapper;
import cn.pluto.medicinal.dao.MenuPowerMapper;
import cn.pluto.medicinal.dao.UserMapper;
import cn.pluto.medicinal.dao.EnterpriseWorkerMapper;
import cn.pluto.medicinal.pojo.*;
import cn.pluto.medicinal.service.EnterpriseInfoService;
import cn.pluto.medicinal.untils.EnterpriseAndUserInfo;
import cn.pluto.medicinal.untils.EnterpriseWorkerAndUserInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zqq
 * @create 2020-04-23-15:45
 */
@Service
public class EnterpriseInfoServiceImpl implements EnterpriseInfoService {

    @Autowired
    private ManufacturerMapper manufacturerMapper;

    @Autowired
    private MenuPowerMapper menuPowerMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EnterpriseWorkerMapper enterpriseWorkerMapper;

    /**
     * @Description: addEnterprise 添加企业信息
     * @param: [manufacturer]
     * @return: int
     * @auther: zqq
     * @date: 20/4/23 16:14
     */
    @Override
    public int addEnterprise(Manufacturer manufacturer) {
        return manufacturerMapper.insert(manufacturer);
    }

    /**
     * @Description: getAllMenu 获取当前账户所有权限,并根据前端传递的菜单id，转换子账户的权限
     * @param: [user]
     * @return: java.util.List<cn.pluto.medicinal.pojo.MenuPower>
     * @auther: zqq
     * @date: 20/4/17 10:41
     */
    @Override
    public List<MenuPower> getAllMenu(User user, EnterpriseAndUserInfo enterpriseAndUserInfo) {
        MenuPowerExample menuPowerExample = new MenuPowerExample();
        MenuPowerExample.Criteria criteria = menuPowerExample.createCriteria();
        criteria.andUseridEqualTo(user.getUserid());
        List<MenuPower> menuPowers = menuPowerMapper.selectByExample(menuPowerExample);
        // 切换为为拥有状态 默认为1 表示拥有   0表示不具有该权限
        for (MenuPower menuPower : menuPowers) {
            if (!enterpriseAndUserInfo.getMenuNumList().contains(menuPower.getMenuId())) {
                menuPower.setMenuState(0);
            }
        }
        return menuPowers;
    }

    /**
     * @Description: getAllMenu 员工权限
     * @param: [user, enterpriseWorkerAndUserInfo]
     * @return: java.util.List<cn.pluto.medicinal.pojo.MenuPower>
     * @auther: zqq
     * @date: 20/4/26 10:48
     */
    @Override
    public List<MenuPower> getAllMenuWorker(User user, EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo) {
        MenuPowerExample menuPowerExample = new MenuPowerExample();
        MenuPowerExample.Criteria criteria = menuPowerExample.createCriteria();
        criteria.andUseridEqualTo(user.getUserid());
        List<MenuPower> menuPowers = menuPowerMapper.selectByExample(menuPowerExample);
        // 切换为为拥有状态 默认为1 表示拥有   0表示不具有该权限
        for (MenuPower menuPower : menuPowers) {
            if (!enterpriseWorkerAndUserInfo.getMenuNumList().contains(menuPower.getMenuId())) {
                menuPower.setMenuState(0);
            }
        }
        return menuPowers;
    }

    /**
     * @Description: getEnterpriseList 企业账户分页
     * @param: [page, size, user, userNameSearch]
     * @return: com.github.pagehelper.PageInfo<cn.pluto.medicinal.untils.GovAndUserInfo>
     * @auther: zqq
     * @date: 20/4/23 18:01
     */
    @Override
    public PageInfo<EnterpriseAndUserInfo> getEnterpriseList(Integer page, Integer size, User user, String userNameSearch) {
        List<EnterpriseAndUserInfo> enterpriseAndUserInfos = new ArrayList<>();
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("userAccount asc");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andFatheridEqualTo(user.getUserid());
        criteria.andUseraccountLike("E-%");
        if (!StringUtils.isEmpty(userNameSearch)){
            criteria.andUsernameLike("%" + userNameSearch + "%");
        }

        PageHelper.startPage(page, size);
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo govAndUserInfoPageInfo = new PageInfo(users);
        EnterpriseAndUserInfo enterpriseAndUserInfo = null;
        for (User u : users) {
            ManufacturerExample manufacturerExample = new ManufacturerExample();
            ManufacturerExample.Criteria criteria1 = manufacturerExample.createCriteria();
            criteria1.andUseridEqualTo(u.getUserid());
            List<Manufacturer> manufacturers = manufacturerMapper.selectByExample(manufacturerExample);
            if (manufacturers.size() == 1){
                enterpriseAndUserInfo = setValue(u, manufacturers.get(0));
                enterpriseAndUserInfos.add(enterpriseAndUserInfo);
            }
        }
        govAndUserInfoPageInfo.setList(enterpriseAndUserInfos);
        return govAndUserInfoPageInfo;
    }


    /**
     * @Description: getEnterpriseWorkerList 获取企业员工分页
     * @param: [page, size, user, userNameSearch]
     * @return: com.github.pagehelper.PageInfo<cn.pluto.medicinal.untils.EnterpriseWorkerAndUserInfo>
     * @auther: zqq
     * @date: 20/4/26 11:12
     */
    @Override
    public PageInfo<EnterpriseWorkerAndUserInfo> getEnterpriseWorkerList(Integer page, Integer size, User user, String userNameSearch) {
        List<EnterpriseWorkerAndUserInfo> enterpriseWorkerAndUserInfoArrayList = new ArrayList<>();
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("userAccount asc");
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andFatheridEqualTo(user.getUserid());
        criteria.andUseraccountLike("W-%");
        if (!StringUtils.isEmpty(userNameSearch)){
            criteria.andUsernameLike("%" + userNameSearch + "%");
        }

        PageHelper.startPage(page, size);
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo govAndUserInfoPageInfo = new PageInfo(users);
        EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo = null;
        for (User u : users) {
            EnterpriseWorkerExample enterpriseWorkerExample = new EnterpriseWorkerExample();
            EnterpriseWorkerExample.Criteria criteria1 = enterpriseWorkerExample.createCriteria();
            criteria1.andUseridEqualTo(u.getUserid());
            List<EnterpriseWorker> enterpriseWorkerList = enterpriseWorkerMapper.selectByExample(enterpriseWorkerExample);
            if (enterpriseWorkerList.size() == 1){
                enterpriseWorkerAndUserInfo = setWorkerValue(u, enterpriseWorkerList.get(0));
                enterpriseWorkerAndUserInfoArrayList.add(enterpriseWorkerAndUserInfo);
            }
        }
        govAndUserInfoPageInfo.setList(enterpriseWorkerAndUserInfoArrayList);
        return govAndUserInfoPageInfo;
    }

    /**
     * @Description: setWorkerValue 设置员工的值
     * @param: [u, enterpriseWorker]
     * @return: cn.pluto.medicinal.untils.EnterpriseWorkerAndUserInfo
     * @auther: zqq
     * @date: 20/4/26 11:10
     */
    private EnterpriseWorkerAndUserInfo setWorkerValue(User u, EnterpriseWorker enterpriseWorker) {
        EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo = new EnterpriseWorkerAndUserInfo();
        enterpriseWorkerAndUserInfo.setId(u.getUserid());
        enterpriseWorkerAndUserInfo.setUserAccount(u.getUseraccount());
        enterpriseWorkerAndUserInfo.setUserName(u.getUsername());

        enterpriseWorkerAndUserInfo.setId2(enterpriseWorker.getId());
        enterpriseWorkerAndUserInfo.setUserid(enterpriseWorker.getUserid());
        enterpriseWorkerAndUserInfo.setWorkername(enterpriseWorker.getWorkername());
        enterpriseWorkerAndUserInfo.setMname(enterpriseWorker.getMname());
        return enterpriseWorkerAndUserInfo;
    }

    /**
     * @Description: setValue 设置企业信息的值
     * @param: [u, manufacturer]
     * @return: cn.pluto.medicinal.untils.EnterpriseAndUserInfo
     * @auther: zqq
     * @date: 20/4/23 17:53
     */
    private EnterpriseAndUserInfo setValue(User u, Manufacturer manufacturer) {
        EnterpriseAndUserInfo enterpriseAndUserInfo = new EnterpriseAndUserInfo();
        enterpriseAndUserInfo.setId(u.getUserid());
        enterpriseAndUserInfo.setUserAccount(u.getUseraccount());
        enterpriseAndUserInfo.setUserName(u.getUsername());
        enterpriseAndUserInfo.setMid(manufacturer.getMid());
        enterpriseAndUserInfo.setUserid(manufacturer.getUserid());

        enterpriseAndUserInfo.setUserid(manufacturer.getUserid());
        enterpriseAndUserInfo.setMname(manufacturer.getMname());
        enterpriseAndUserInfo.setProvince(manufacturer.getProvince());
        enterpriseAndUserInfo.setWeb(manufacturer.getWeb());
        enterpriseAndUserInfo.setRecordnumber(manufacturer.getRecordnumber());
        enterpriseAndUserInfo.setProductionnumber(manufacturer.getProductionnumber());
        enterpriseAndUserInfo.setMainproduce(manufacturer.getMainproduce());
        enterpriseAndUserInfo.setLegalperson(manufacturer.getLegalperson());
        enterpriseAndUserInfo.setRegisteredcapital(manufacturer.getRegisteredcapital());
        enterpriseAndUserInfo.setPaidincapital(manufacturer.getPaidincapital());
        enterpriseAndUserInfo.setStateoperation(manufacturer.getStateoperation());
        enterpriseAndUserInfo.setEstablishtime(manufacturer.getEstablishtime());
        enterpriseAndUserInfo.setUsccode(manufacturer.getUsccode());
        enterpriseAndUserInfo.setTinumber(manufacturer.getTinumber());
        enterpriseAndUserInfo.setRnumber(manufacturer.getRnumber());
        enterpriseAndUserInfo.setOcode(manufacturer.getOcode());
        enterpriseAndUserInfo.setBtype(manufacturer.getBtype());
        enterpriseAndUserInfo.setIndustry(manufacturer.getIndustry());
        enterpriseAndUserInfo.setSanctiondate(manufacturer.getSanctiondate());
        enterpriseAndUserInfo.setRegistrationauthority(manufacturer.getRegistrationauthority());
        enterpriseAndUserInfo.setEname(manufacturer.getEname());
        enterpriseAndUserInfo.setOname(manufacturer.getOname());
        enterpriseAndUserInfo.setInsurepersons(manufacturer.getInsurepersons());
        enterpriseAndUserInfo.setOtstaff(manufacturer.getOtstaff());
        enterpriseAndUserInfo.setOperatingperiod(manufacturer.getOperatingperiod());
        enterpriseAndUserInfo.setAddress(manufacturer.getAddress());
        enterpriseAndUserInfo.setGmp(manufacturer.getGmp());
        return enterpriseAndUserInfo;
    }

    /**
     * @Description: getEnterpriseInfoByUserid 获取企业信息
     * @param: [enterpriseAndUserInfo]
     * @return: cn.pluto.medicinal.pojo.Manufacturer
     * @auther: zqq
     * @date: 20/4/23 21:57
     */
    @Override
    public Manufacturer getEnterpriseInfoByUserid(User user) {
        ManufacturerExample manufacturerExample = new ManufacturerExample();
        manufacturerExample.createCriteria().andUseridEqualTo(user.getUserid());
        List<Manufacturer> manufacturers = manufacturerMapper.selectByExample(manufacturerExample);
        return manufacturers.get(0);
    }



    /**
     * @Description: updateEnterprise 更新企业信息
     * @param: [manufacturer]
     * @return: int
     * @auther: zqq
     * @date: 20/4/24 7:45
     */
    @Override
    public int updateEnterprise(Manufacturer manufacturer) {
        ManufacturerExample manufacturerExample = new ManufacturerExample();
        manufacturerExample.createCriteria().andUseridEqualTo(manufacturer.getUserid()).andMidEqualTo(manufacturer.getMid());
        int i = manufacturerMapper.updateByExample(manufacturer, manufacturerExample);
        return i;
    }

    /**
     * @Description: updateMenu 更新账户权限
     * @param: [allMenu, enterpriseAndUserInfo]
     * @return: boolean
     * @auther: zqq
     * @date: 20/4/24 7:52
     */
    @Override
    public boolean updateMenu(List<MenuPower> allMenu, EnterpriseAndUserInfo enterpriseAndUserInfo) {
        int a = 0;
        for (MenuPower menu : allMenu) {
            if (enterpriseAndUserInfo.getMenuNumList().contains(menu.getMenuId())){
                menu.setMenuState(1);
            }
            int i = menuPowerMapper.updateByPrimaryKey(menu);
            a += i;
        }
        return allMenu.size() == a ? true : false;
    }

    /**
     * @Description: delEnterprise 删除企业账户
     * @param: [manufacturer]
     * @return: int
     * @auther: zqq
     * @date: 20/4/24 7:58
     */
    @Override
    public int delEnterprise(Manufacturer manufacturer) {
        ManufacturerExample manufacturerExample = new ManufacturerExample();
        manufacturerExample.createCriteria().andUseridEqualTo(manufacturer.getUserid());
        return manufacturerMapper.deleteByExample(manufacturerExample);
    }

    /**
     * @Description: addEnterpriseEorker 添加企业员工的账户
     * @param: [enterpriseWorker]
     * @return: int
     * @auther: zqq
     * @date: 20/4/26 10:53
     */
    @Override
    public int addEnterpriseEorker(EnterpriseWorker enterpriseWorker) {
        return enterpriseWorkerMapper.insert(enterpriseWorker);
    }

    /**
     * @Description: getEnterpriseWorkerInfoByUserid 通过userid查询元信息
     * @param: [user2]
     * @return: cn.pluto.medicinal.pojo.EnterpriseWorker
     * @auther: zqq
     * @date: 20/4/26 12:11
     */
    @Override
    public EnterpriseWorker getEnterpriseWorkerInfoByUserid(User user2) {
        EnterpriseWorkerExample enterpriseWorkerExample = new EnterpriseWorkerExample();
        enterpriseWorkerExample.createCriteria().andUseridEqualTo(user2.getUserid());
        List<EnterpriseWorker> enterpriseWorkerList = enterpriseWorkerMapper.selectByExample(enterpriseWorkerExample);
        return enterpriseWorkerList.get(0);
    }


    /**
     * @Description: updateEnterpriseWorker 更新企业员信息
     * @param: [enterpriseWorker]
     * @return: int
     * @auther: zqq
     * @date: 20/4/26 12:25
     */
    @Override
    public int updateEnterpriseWorker(EnterpriseWorker enterpriseWorker) {
        EnterpriseWorkerExample enterpriseWorkerExample = new EnterpriseWorkerExample();
        enterpriseWorkerExample.createCriteria().andUseridEqualTo(enterpriseWorker.getUserid()).andIdEqualTo(enterpriseWorker.getId());
        return enterpriseWorkerMapper.updateByExample(enterpriseWorker, enterpriseWorkerExample);
    }

    /**
     * @Description: updateMenuWorker 更新企业员工信息
     * @param: [allMenu, enterpriseWorkerAndUserInfo]
     * @return: boolean
     * @auther: zqq
     * @date: 20/4/26 12:28
     */
    @Override
    public boolean updateMenuWorker(List<MenuPower> allMenu, EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo) {
        int a = 0;
        for (MenuPower menu : allMenu) {
            if (enterpriseWorkerAndUserInfo.getMenuNumList().contains(menu.getMenuId())){
                menu.setMenuState(1);
            }
            int i = menuPowerMapper.updateByPrimaryKey(menu);
            a += i;
        }
        return allMenu.size() == a ? true : false;
    }

    /**
     * @Description: delEnterpriseWorker 删除员工
     * @param: [enterpriseWorker]
     * @return: int
     * @auther: zqq
     * @date: 20/4/26 12:34
     */
    @Override
    public int delEnterpriseWorker(EnterpriseWorker enterpriseWorker) {
        EnterpriseWorkerExample enterpriseWorkerExample = new EnterpriseWorkerExample();
        enterpriseWorkerExample.createCriteria().andUseridEqualTo(enterpriseWorker.getUserid());
        return enterpriseWorkerMapper.deleteByExample(enterpriseWorkerExample);
    }
}
