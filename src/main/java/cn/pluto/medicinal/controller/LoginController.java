package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.service.imp.LoginServiceImpl;
import cn.pluto.medicinal.untils.Menu;
import cn.pluto.medicinal.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zqq
 * @create 2020-04-12-11:03
 */
@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    /**
     * @Description: doLogin 处理登录请求
     * @param: [username, password]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/12 11:47
     */
    @PostMapping("/login")
    @CrossOrigin
    public Result doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session){
        User user = new User();
        user.setUseraccount(username);
        user.setUserpassword(password);
        int login = loginService.login(user);
        if (login == 1){
            return Result.fail(500,"密码错误");
        }else if (login == -1){
            return Result.fail(500, "账号不存在");
        }
        return Result.success();
    }

    /**
     * @Description: menu 处理获取权限菜单请求
     * @param: [username]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/4/13 10:32
     */
    @GetMapping("/menu")
    @CrossOrigin
    public Result menu(@RequestParam String username){
        User user = new User();
        user.setUseraccount(username);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        List<Menu> menuByUserId = loginService.getMenuByUserId(userByUserAccount);
        return Result.success(menuByUserId);
    }

}
