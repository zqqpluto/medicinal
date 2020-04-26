package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.pojo.EnterpriseWorker;
import cn.pluto.medicinal.pojo.Manufacturer;
import cn.pluto.medicinal.pojo.MenuPower;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.service.imp.EnterpriseInfoServiceImpl;
import cn.pluto.medicinal.service.imp.LoginServiceImpl;
import cn.pluto.medicinal.service.imp.UserServiceImpl;
import cn.pluto.medicinal.untils.EnterpriseAndUserInfo;
import cn.pluto.medicinal.untils.EnterpriseWorkerAndUserInfo;
import cn.pluto.medicinal.untils.Result;
import com.github.pagehelper.PageInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author zqq
 * @create 2020-04-23-15:42
 */
@RestController
public class EnterpriseInfoController {

    @Autowired
    private EnterpriseInfoServiceImpl enterpriseInfoService;

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private UserServiceImpl userService;

    /**
     * @Description: addEnterprise 处理添加企业请求
     * @param: [enterpriseAndUserInfo]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/23 16:24
     */
    @PostMapping("/enterpriseInfo")
    @CrossOrigin
    @Transactional
    public Result addEnterprise(@NotNull @RequestBody EnterpriseAndUserInfo enterpriseAndUserInfo){
        User user1 = new User();
        User user2 = new User();

        user1.setUseraccount(enterpriseAndUserInfo.getFatherUserAccount());
        User userByUserAccount = loginService.getUserByUserAccount(user1);

        String userid = UUID.randomUUID().toString();

        user2.setUserid(userid);
        user2.setUseraccount(enterpriseAndUserInfo.getUserAccount());
        int us = userService.checkUserExit(user2);

        int u = 0;
        if (us == 0){
            user2.setUsername(enterpriseAndUserInfo.getUserName());
            user2.setUserpassword(enterpriseAndUserInfo.getUserPassword());
            user2.setFatherid(userByUserAccount.getUserid());
            user2.setFathername(userByUserAccount.getUsername());
            u = userService.addUser(user2);
        }else {
            return Result.fail(404, "该账户已经存在,请修改账户");
        }
        Manufacturer manufacturer = setEnterpriseInfo(enterpriseAndUserInfo, userid);
        int g = enterpriseInfoService.addEnterprise(manufacturer);

        List<MenuPower> allMenu = enterpriseInfoService.getAllMenu(userByUserAccount, enterpriseAndUserInfo);
        for (MenuPower menu : allMenu) {
            menu.setUserid(userid);
        }
        boolean b = userService.addMenu(allMenu);

        if (u ==1 && g == 1 && b){
            return Result.success("添加成功");
        }
        return Result.fail(404, "添加失败稍后再试");
    }

    /**
     * @Description: pageEnterprise 企业账户分页
     * @param: [page, size, userName, userNameSearch]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/23 18:03
     */
    @GetMapping("/enterpriseInfo")
    @CrossOrigin
    public Result pageEnterprise(@RequestParam(required = true,defaultValue = "1") Integer page,
                          @RequestParam(required = true,defaultValue = "10") Integer size,
                          @RequestParam(required = true) String userName,
                          @RequestParam(required = true) String userNameSearch){
        User user = new User();
        user.setUseraccount(userName);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        PageInfo<EnterpriseAndUserInfo> enterpriseList = enterpriseInfoService.getEnterpriseList(page, size, userByUserAccount, userNameSearch);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data", enterpriseList.getList());
        stringObjectHashMap.put("total", enterpriseList.getTotal());
        return Result.success(stringObjectHashMap);
    }

    /**
     * @Description: setEnterpriseInfo 设置企业信息
     * @param: [enterpriseAndUserInfo, userid]
     * @return: cn.pluto.medicinal.pojo.Manufacturer
     * @auther: zqq
     * @date: 20/4/23 16:08
     */
    @NotNull
    private Manufacturer setEnterpriseInfo(@NotNull EnterpriseAndUserInfo enterpriseAndUserInfo, String userid) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setUserid(userid);
        manufacturer.setMname(enterpriseAndUserInfo.getMname());
        manufacturer.setProvince(enterpriseAndUserInfo.getProvince());
        manufacturer.setWeb(enterpriseAndUserInfo.getWeb());
        manufacturer.setRecordnumber(enterpriseAndUserInfo.getRecordnumber());
        manufacturer.setProductionnumber(enterpriseAndUserInfo.getProductionnumber());
        manufacturer.setMainproduce(enterpriseAndUserInfo.getMainproduce());
        manufacturer.setLegalperson(enterpriseAndUserInfo.getLegalperson());
        manufacturer.setRegisteredcapital(enterpriseAndUserInfo.getRegisteredcapital());
        manufacturer.setPaidincapital(enterpriseAndUserInfo.getPaidincapital());
        manufacturer.setStateoperation(enterpriseAndUserInfo.getStateoperation());
        manufacturer.setEstablishtime(enterpriseAndUserInfo.getEstablishtime());
        manufacturer.setUsccode(enterpriseAndUserInfo.getUsccode());
        manufacturer.setTinumber(enterpriseAndUserInfo.getTinumber());
        manufacturer.setRnumber(enterpriseAndUserInfo.getRnumber());
        manufacturer.setOcode(enterpriseAndUserInfo.getOcode());
        manufacturer.setBtype(enterpriseAndUserInfo.getBtype());
        manufacturer.setIndustry(enterpriseAndUserInfo.getIndustry());
        manufacturer.setSanctiondate(enterpriseAndUserInfo.getSanctiondate());
        manufacturer.setRegistrationauthority(enterpriseAndUserInfo.getRegistrationauthority());
        manufacturer.setEname(enterpriseAndUserInfo.getEname());
        manufacturer.setOname(enterpriseAndUserInfo.getOname());
        manufacturer.setInsurepersons(enterpriseAndUserInfo.getInsurepersons());
        manufacturer.setOtstaff(enterpriseAndUserInfo.getOtstaff());
        manufacturer.setOperatingperiod(enterpriseAndUserInfo.getOperatingperiod());
        manufacturer.setAddress(enterpriseAndUserInfo.getAddress());
        manufacturer.setGmp(enterpriseAndUserInfo.getGmp());
        return manufacturer;
    }

    /**
     * @Description: updateGov 处理更新账户的请求
     * @param: [enterpriseAndUserInfo]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/24 7:53
     */
    @PutMapping("/enterpriseInfo")
    @CrossOrigin
    @Transactional
    public Result updateEnterprise(@NotNull @RequestBody EnterpriseAndUserInfo enterpriseAndUserInfo){
        User user1 = new User();
        User user2 = new User();

        user1.setUseraccount(enterpriseAndUserInfo.getFatherUserAccount());
        User userByUserAccount = loginService.getUserByUserAccount(user1);

        user2.setUserid(enterpriseAndUserInfo.getId());
        user2.setUseraccount(enterpriseAndUserInfo.getUserAccount());
        user2.setUsername(enterpriseAndUserInfo.getUserName());
        user2.setFatherid(userByUserAccount.getUserid());
        user2.setFathername(userByUserAccount.getUsername());
        int u = userService.updateUser(user2);

        if (u == 1){
            Manufacturer enterpriseInfoByUserid = enterpriseInfoService.getEnterpriseInfoByUserid(user2);
            Manufacturer manufacturer = setEnterpriseInfo(enterpriseAndUserInfo, enterpriseAndUserInfo.getId());
            manufacturer.setMid(enterpriseInfoByUserid.getMid());
            int g = enterpriseInfoService.updateEnterprise(manufacturer);
            if (g == 1){
                List<MenuPower> allMenu = enterpriseInfoService.getAllMenu(user2, enterpriseAndUserInfo);
                boolean b = enterpriseInfoService.updateMenu(allMenu,enterpriseAndUserInfo);
                if (b){
                    return Result.success("修改成功");
                }
            }
        }
        return Result.fail(404, "修改失败稍后再试");
    }

    /**
     * @Description: delEnterprise 删除企业账户
     * @param: [userId]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/24 8:00
     */
    @DeleteMapping("/enterpriseInfo/{userId}")
    @CrossOrigin
    @Transactional
    public Result delEnterprise(@PathVariable String userId){
        User user = new User();
        user.setUserid(userId);
        int delUser = userService.delUser(user);
        if (delUser == 1){
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setUserid(userId);
            int delGov = enterpriseInfoService.delEnterprise(manufacturer);
            if (delGov == 1){
                MenuPower menuPower = new MenuPower();
                menuPower.setUserid(userId);
                //删除权限
                userService.delMenu(menuPower);
                return Result.success("删除成功");
            }
        }
        return Result.fail(404,"删除失败");
    }

    /**
     * @Description: addEnterpriseWorker 处理添加企业员工的请求
     * @param: [enterpriseWorkerAndUserInfo]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/26 10:54
     */
    @PostMapping("/enterpriseWorkerInfo")
    @CrossOrigin
    @Transactional
    public Result addEnterpriseWorker(@NotNull @RequestBody EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo){
        User user1 = new User();
        User user2 = new User();

        user1.setUseraccount(enterpriseWorkerAndUserInfo.getFatherUserAccount());
        User userByUserAccount = loginService.getUserByUserAccount(user1);

        String userid = UUID.randomUUID().toString();

        user2.setUserid(userid);
        user2.setUseraccount(enterpriseWorkerAndUserInfo.getUserAccount());
        int us = userService.checkUserExit(user2);

        int u = 0;
        if (us == 0){
            user2.setUsername(enterpriseWorkerAndUserInfo.getUserName());
            user2.setUserpassword(enterpriseWorkerAndUserInfo.getUserPassword());
            user2.setFatherid(userByUserAccount.getUserid());
            user2.setFathername(userByUserAccount.getUsername());
            u = userService.addUser(user2);
        }else {
            return Result.fail(404, "该账户已经存在,请修改账户");
        }

        EnterpriseWorker enterpriseWorker = setEnterpriseWorkerInfo(enterpriseWorkerAndUserInfo, userid);
        int g = enterpriseInfoService.addEnterpriseEorker(enterpriseWorker);

        List<MenuPower> allMenu = enterpriseInfoService.getAllMenuWorker(userByUserAccount, enterpriseWorkerAndUserInfo);
        for (MenuPower menu : allMenu) {
            menu.setUserid(userid);
        }
        boolean b = userService.addMenu(allMenu);

        if (u ==1 && g == 1 && b){
            return Result.success("添加成功");
        }
        return Result.fail(404, "添加失败稍后再试");
    }

    /**
     * @Description: setEnterpriseWorkerInfo 设置企业员工的信息
     * @param: [enterpriseWorkerAndUserInfo, userid]
     * @return: cn.pluto.medicinal.pojo.EnterpriseWorker
     * @auther: zqq
     * @date: 20/4/26 9:51
     */
    private EnterpriseWorker setEnterpriseWorkerInfo(EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo, String userid) {
        EnterpriseWorker enterpriseWorker = new EnterpriseWorker();
        enterpriseWorker.setId(UUID.randomUUID().toString());
        enterpriseWorker.setUserid(userid);
        enterpriseWorker.setMname(enterpriseWorkerAndUserInfo.getMname());
        enterpriseWorker.setWorkername(enterpriseWorkerAndUserInfo.getWorkername());
        return enterpriseWorker;
    }


    /**
     * @Description: pageEnterpriseWoker 处理企业员发呢也请求
     * @param: [page, size, userName, userNameSearch]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/26 11:12
     */
    @GetMapping("/enterpriseWorkerInfo")
    @CrossOrigin
    public Result pageEnterpriseWoker(@RequestParam(required = true,defaultValue = "1") Integer page,
                                 @RequestParam(required = true,defaultValue = "10") Integer size,
                                 @RequestParam(required = true) String userName,
                                 @RequestParam(required = true) String userNameSearch){
        User user = new User();
        user.setUseraccount(userName);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        PageInfo<EnterpriseWorkerAndUserInfo> enterpriseList = enterpriseInfoService.getEnterpriseWorkerList(page, size, userByUserAccount,
                userNameSearch);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data", enterpriseList.getList());
        stringObjectHashMap.put("total", enterpriseList.getTotal());
        return Result.success(stringObjectHashMap);
    }

    /**
     * @Description: getEnterpriseName 处理获取公司名称请求
     * @param: [username]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/26 12:00
     */
    @GetMapping("/enterpriseName")
    @CrossOrigin
    public Result getEnterpriseName(@RequestParam(required = true) String username){
        User user = new User();
        user.setUseraccount(username);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        Manufacturer m = enterpriseInfoService.getEnterpriseInfoByUserid(userByUserAccount);
        return Result.success(m.getMname());
    }

    /**
     * @Description: updateEnterpriseWorker 处理更新员工的请求
     * @param: [enterpriseWorkerAndUserInfo]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/26 12:29
     */
    @PutMapping("/enterpriseWorkerInfo")
    @CrossOrigin
    @Transactional
    public Result updateEnterpriseWorker(@NotNull @RequestBody EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo){
        User user1 = new User();
        User user2 = new User();

        user1.setUseraccount(enterpriseWorkerAndUserInfo.getFatherUserAccount());
        User userByUserAccount = loginService.getUserByUserAccount(user1);

        user2.setUserid(enterpriseWorkerAndUserInfo.getId());
        user2.setUseraccount(enterpriseWorkerAndUserInfo.getUserAccount());
        user2.setUsername(enterpriseWorkerAndUserInfo.getUserName());
        user2.setFatherid(userByUserAccount.getUserid());
        user2.setFathername(userByUserAccount.getUsername());
        int u = userService.updateUser(user2);

        if (u == 1){
            EnterpriseWorker enterpriseWorkerInfoByUserid = enterpriseInfoService.getEnterpriseWorkerInfoByUserid(user2);
            EnterpriseWorker enterpriseWorker = setEnterpriseWprkerInfo(enterpriseWorkerAndUserInfo,
                    enterpriseWorkerAndUserInfo.getId());
            enterpriseWorker.setId(enterpriseWorkerInfoByUserid.getId());
            int g = enterpriseInfoService.updateEnterpriseWorker(enterpriseWorker);
            if (g == 1){
                List<MenuPower> allMenu = enterpriseInfoService.getAllMenuWorker(user2, enterpriseWorkerAndUserInfo);
                boolean b = enterpriseInfoService.updateMenuWorker(allMenu,enterpriseWorkerAndUserInfo);
                if (b){
                    return Result.success("修改成功");
                }
            }
        }
        return Result.fail(404, "修改失败稍后再试");
    }

    /**
     * @Description: setEnterpriseWprkerInfo 设置企业员工的值
     * @param: [enterpriseWorkerAndUserInfo, id]
     * @return: cn.pluto.medicinal.pojo.EnterpriseWorker
     * @auther: zqq
     * @date: 20/4/26 12:16
     */
    private EnterpriseWorker setEnterpriseWprkerInfo(EnterpriseWorkerAndUserInfo enterpriseWorkerAndUserInfo, String id) {
        EnterpriseWorker enterpriseWorker = new EnterpriseWorker();
        enterpriseWorker.setWorkername(enterpriseWorkerAndUserInfo.getWorkername());
        enterpriseWorker.setMname(enterpriseWorkerAndUserInfo.getMname());
        enterpriseWorker.setUserid(id);
        return enterpriseWorker;
    }

    /**
     * @Description: delEnterpriseWorker 处理删除企业员工的请求
     * @param: [userId]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/26 12:35
     */
    @DeleteMapping("/enterpriseWorkerInfo/{userId}")
    @CrossOrigin
    @Transactional
    public Result delEnterpriseWorker(@PathVariable String userId){
        User user = new User();
        user.setUserid(userId);
        int delUser = userService.delUser(user);
        if (delUser == 1){
            EnterpriseWorker enterpriseWorker = new EnterpriseWorker();
            enterpriseWorker.setUserid(userId);
            int delGov = enterpriseInfoService.delEnterpriseWorker(enterpriseWorker);
            if (delGov == 1){
                MenuPower menuPower = new MenuPower();
                menuPower.setUserid(userId);
                //删除权限
                userService.delMenu(menuPower);
                return Result.success("删除成功");
            }
        }
        return Result.fail(404,"删除失败");
    }

}
