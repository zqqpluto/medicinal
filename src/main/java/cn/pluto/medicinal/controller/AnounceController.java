package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.pojo.Anounce;
import cn.pluto.medicinal.pojo.Manufacturer;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.service.imp.AnounceServiceImpl;
import cn.pluto.medicinal.service.imp.EnterpriseInfoServiceImpl;
import cn.pluto.medicinal.service.imp.LoginServiceImpl;
import cn.pluto.medicinal.untils.AnounceUntil;
import cn.pluto.medicinal.untils.PageInfoUtils;
import cn.pluto.medicinal.untils.Result;
import cn.pluto.medicinal.untils.UserUntil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zqq
 * @create 2020-05-05-9:18
 */
@RestController
public class AnounceController {

    @Autowired
    private AnounceServiceImpl anounceService;

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private EnterpriseInfoServiceImpl enterpriseInfoService;

    /**
     * @Description: addAnounce 处理添加公告请求
     * @param: [anounceUntil]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/5 9:46
     */
    @PostMapping("/anounce")
    @CrossOrigin
    public Result addAnounce(@RequestBody AnounceUntil anounceUntil){
        User user = new User();
        user.setUseraccount(anounceUntil.getUseraccount());
        User userByUserAccount = loginService.getUserByUserAccount(user);
        anounceUntil.setUserid(userByUserAccount.getUserid());
        // 默认为true表示是当前账户
        boolean b = true;
        // 判断是否是企业账户的子账户
        Manufacturer m = null;
        if (userByUserAccount.getUseraccount().startsWith("E-")){
            m = anounceService.getExterprise(userByUserAccount, b);
            anounceUntil.setMid(m.getMid());
        }else if (userByUserAccount.getUseraccount().startsWith("W-")){
            b = false;
            m = anounceService.getExterprise(userByUserAccount, b);
            anounceUntil.setMid(m.getMid());
        }else if (userByUserAccount.getUseraccount().startsWith("G-") || userByUserAccount.getUsername().startsWith(
                "admin")){
            anounceUntil.setMid(anounceService.getGov(userByUserAccount).getGovId());
        }
        Anounce anounce = setAnounce(anounceUntil);
        boolean bool = anounceService.addAnounce(anounce);
        if(bool){
            return Result.success("添加成功");
        }
        return Result.fail(404, "添加失败请重试");
    }

    private Anounce setAnounce(AnounceUntil anounceUntil) {
        Anounce anounce = new Anounce();
        anounce.setUserid(anounceUntil.getUserid());
        anounce.setAtitle(anounceUntil.getAtitle());
        anounce.setAcontent(anounceUntil.getAcontent());
        if (anounceUntil.getMid() != null){
            anounce.setMid(anounceUntil.getMid());
        }
        return anounce;
    }

    /**
     * @Description: anounce 公告分页
     * @param: [page, size, userName, nameSearch]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/5 10:10
     */
    @GetMapping("/anounce")
    @CrossOrigin
    public Result anounce(@RequestParam(required = true,defaultValue = "1") Integer page,
                                   @RequestParam(required = true,defaultValue = "10") Integer size,
                                   @RequestParam(required = true) String userName,
                                   @RequestParam(required = false) String nameSearch){
        User user = new User();
        user.setUseraccount(userName);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        UserUntil userUntil1 = new UserUntil();
        userUntil1.setUserid(userByUserAccount.getUserid());
        userUntil1.setUseraccount(userByUserAccount.getUseraccount());
        userUntil1.setUsername(userByUserAccount.getUsername());
        List<UserUntil> selfAndLowerUserByUserAccount = anounceService.getSelfAndLowerUserByUserAccount(userUntil1);
        userUntil1.setUserUntils(selfAndLowerUserByUserAccount);

        ArrayList<AnounceUntil> anounceUntils = new ArrayList<>();
        anounceUntils = anounceService.getAnounceList(userUntil1, anounceUntils, nameSearch);
        PageInfo<AnounceUntil> pageInfo = PageInfoUtils.list2PageInfo(anounceUntils, page, size);

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data", pageInfo.getList());
        stringObjectHashMap.put("total", pageInfo.getTotal());
        return Result.success(stringObjectHashMap);
    }

    @DeleteMapping("/anounce/{id}")
    @CrossOrigin
    public Result delKnowledge(@PathVariable(required = true) Integer id){
        Anounce anounce = new Anounce();
        anounce.setId(id);
        boolean bool = anounceService.delAounce(anounce);
        if (bool){
            return Result.success("删除成功");
        }
        return Result.fail(404, "删除失败，请重试");
    }

}
