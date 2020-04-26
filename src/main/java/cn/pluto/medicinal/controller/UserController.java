package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.pojo.GovInfo;
import cn.pluto.medicinal.pojo.MenuPower;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.service.imp.LoginServiceImpl;
import cn.pluto.medicinal.service.imp.UserServiceImpl;
import cn.pluto.medicinal.untils.GovAndUserInfo;
import cn.pluto.medicinal.untils.Menus;
import cn.pluto.medicinal.untils.Result;
import com.github.pagehelper.PageInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author zqq
 * @create 2020-04-15-20:14
 */
@RestController
public class UserController {

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private UserServiceImpl userService;


    /**
     * @Description: addGov  添加政府账户信息
     * @param: [govAndUserInfo, session]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/15 22:08
     */
    @PostMapping("/govInfo")
    @CrossOrigin
    @Transactional
    public Result addGov(@RequestBody GovAndUserInfo govAndUserInfo){
        User user1 = new User();
        User user2 = new User();

        user1.setUseraccount(govAndUserInfo.getFatherUserAccount());
        User userByUserAccount = loginService.getUserByUserAccount(user1);

        String userid = UUID.randomUUID().toString();

        user2.setUserid(userid);
        user2.setUseraccount(govAndUserInfo.getUserAccount());
        int us = userService.checkUserExit(user2);

        int u = 0;
        if (us == 0){
            user2.setUsername(govAndUserInfo.getUserName());
            user2.setUserpassword(govAndUserInfo.getUserPassword());
            user2.setFatherid(userByUserAccount.getUserid());
            user2.setFathername(userByUserAccount.getUsername());
            u = userService.addUser(user2);
        }else {
            return Result.fail(404, "该账户已经存在,请修改账户");
        }
        GovInfo govInfo = setGovInfo(govAndUserInfo, userid);
        int g = userService.addGov(govInfo);

        List<MenuPower> allMenu = userService.getAllMenu(userByUserAccount, govAndUserInfo);
        for (MenuPower menu : allMenu) {
            menu.setUserid(userid);
        }
        boolean b = userService.addMenu(allMenu);

        if (u ==1 && g == 1 && b){
            return Result.success("添加成功");
        }
        return Result.fail(404, "添加失败稍后再试");
    }

    @NotNull
    private GovInfo setGovInfo(@NotNull @RequestBody GovAndUserInfo govAndUserInfo, String userid) {
        GovInfo govInfo = new GovInfo();
        govInfo.setUserid(userid);
        govInfo.setGovAddress(govAndUserInfo.getGovermentAddrsss());
        govInfo.setGovDep(govAndUserInfo.getGovermentDepartment());
        govInfo.setGovMan(govAndUserInfo.getGovermentMan());
        govInfo.setGovPho(govAndUserInfo.getGovermentPhone());
        govInfo.setGovPhoneSelf(govAndUserInfo.getGovermentPhoneSelf());
        return govInfo;
    }


    /**
     * @Description: getMenus 获取菜单列表
     * @param: [username]
     * @return: java.util.List<cn.pluto.medicinal.untils.Menus>
     * @auther: zqq
     * @date: 20/4/17 10:17
     */
    @GetMapping("/menus")
    @CrossOrigin
    public List<Menus> getMenus(@RequestParam String username){
        User user = new User();
        user.setUseraccount(username);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        List<Menus> menus1 = userService.getMenus(userByUserAccount);
        Menus menus = new Menus();
        menus.setChildren(menus1);
        List<Menus> ml = new ArrayList<>();
        ml.add(menus);
        return ml;
    }


    /**
     * @Description: pageGov  处理分页
     * @param: [page, size, userName, userNameSearch]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/22 11:07
     */
    @GetMapping("/govList")
    @CrossOrigin
    public Result pageGov(@RequestParam(required = true,defaultValue = "1") Integer page,
                          @RequestParam(required = true,defaultValue = "10") Integer size,
                          @RequestParam(required = true) String userName,
                          @RequestParam(required = true) String userNameSearch){
        User user = new User();
        user.setUseraccount(userName);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        PageInfo<GovAndUserInfo> gui = userService.getGovList(page, size, userByUserAccount, userNameSearch);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data", gui.getList());
        stringObjectHashMap.put("total", gui.getTotal());
        return Result.success(stringObjectHashMap);
    }

    /**
     * @Description: selectMenu 处理查询请求
     * @param: [account]
     * @return: java.util.List<java.lang.String>
     * @auther: zqq
     * @date: 20/4/22 18:48
     */
    @GetMapping("/select")
    @CrossOrigin
    public List<String> selectMenu(@RequestParam(required = true) String account){
        User user = new User();
        user.setUseraccount(account);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        MenuPower menuPower = new MenuPower();
        menuPower.setUserid(userByUserAccount.getUserid());
        List<String> slectmenu = userService.getSelectMenu(menuPower);
        return slectmenu;
    }

    /**
     * @Description: updateGov 修改政府账户信息
     * @param: [govAndUserInfo]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/22 21:01
     */
    @PutMapping("/govInfo")
    @CrossOrigin
    @Transactional
    public Result updateGov(@RequestBody GovAndUserInfo govAndUserInfo){
        User user1 = new User();
        User user2 = new User();

        user1.setUseraccount(govAndUserInfo.getFatherUserAccount());
        User userByUserAccount = loginService.getUserByUserAccount(user1);

        user2.setUserid(govAndUserInfo.getId());
        user2.setUseraccount(govAndUserInfo.getUserAccount());
        user2.setUsername(govAndUserInfo.getUserName());
        user2.setFatherid(userByUserAccount.getUserid());
        user2.setFathername(userByUserAccount.getUsername());
        int u = userService.updateUser(user2);

        if (u == 1){
            GovInfo govInfo = userService.getGovInfoByUserid(govAndUserInfo);
            GovInfo govInfo1 = setGovInfo(govAndUserInfo, govAndUserInfo.getId());
            govInfo1.setGovId(govInfo.getGovId());
            int g = userService.updateGov(govInfo1);
            if (g == 1){
                List<MenuPower> allMenu = userService.getAllMenu(user2, govAndUserInfo);
                boolean b = userService.updateMenu(allMenu,govAndUserInfo);
                if (b){
                    return Result.success("修改成功");
                }
            }
        }
        return Result.fail(404, "修改失败稍后再试");
    }


    /**
     * @Description: delGov 处理删除用户的请求
     * @param: [userId]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/23 13:13
     */
    @DeleteMapping("/govInfo/{userId}")
    @CrossOrigin
    @Transactional
    public Result delGov(@PathVariable String userId){
        User user = new User();
        user.setUserid(userId);
        int delUser = userService.delUser(user);
        if (delUser == 1){
            GovInfo govInfo = new GovInfo();
            govInfo.setUserid(userId);
            int delGov = userService.delGov(govInfo);
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
