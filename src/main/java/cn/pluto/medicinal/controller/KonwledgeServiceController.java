package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.pojo.KnowledgeService;
import cn.pluto.medicinal.pojo.Manufacturer;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.service.imp.AnounceServiceImpl;
import cn.pluto.medicinal.service.imp.KnowledgeServiceServiceImpl;
import cn.pluto.medicinal.service.imp.LoginServiceImpl;
import cn.pluto.medicinal.untils.*;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zqq
 * @create 2020-05-03-9:30
 */
@RestController
public class KonwledgeServiceController {

    @Autowired
    private KnowledgeServiceServiceImpl  konwledgeService;

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private AnounceServiceImpl anounceService;

    /**
     * @Description: addKonwedgeService 处理添加知识服务的请求
     * @param: [knowledgeServiceUntil]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/3 18:04
     */
    @PostMapping("/knowledgeService")
    @CrossOrigin
    public Result addKonwedgeService(@RequestBody KnowledgeServiceUntil knowledgeServiceUntil){
        User user = new User();
        user.setUseraccount(knowledgeServiceUntil.getUseraccount());
        User userByUserAccount = loginService.getUserByUserAccount(user);

        knowledgeServiceUntil.setUserid(userByUserAccount.getUserid());
        knowledgeServiceUntil.setUsername(userByUserAccount.getUsername());
        knowledgeServiceUntil.setKcid(knowledgeServiceUntil.getKcid());
        // 默认为true表示是当前账户
        boolean b = true;
        // 判断是否是企业账户的子账户
        Manufacturer m = null;
        if (userByUserAccount.getUseraccount().startsWith("E-")){
            m = anounceService.getExterprise(userByUserAccount, b);
            knowledgeServiceUntil.setMid(m.getMid());
        }else if (userByUserAccount.getUseraccount().startsWith("W-")){
            b = false;
            m = anounceService.getExterprise(userByUserAccount, b);
            knowledgeServiceUntil.setMid(m.getMid());
        }else if (userByUserAccount.getUseraccount().startsWith("G-") || userByUserAccount.getUsername().startsWith(
                "admin")){
            knowledgeServiceUntil.setMid(anounceService.getGov(userByUserAccount).getGovId());
        }
        KnowledgeService knowledgeService = setKonwledgeService(knowledgeServiceUntil);
        boolean boo = konwledgeService.addKnowledgeService(knowledgeService);
        if (boo){
            return Result.success("添加成功");
        }
        return Result.fail(404, "添加失败，请重试");
    }

    private KnowledgeService setKonwledgeService(KnowledgeServiceUntil knowledgeServiceUntil) {
        KnowledgeService knowledgeService = new KnowledgeService();
        if (knowledgeServiceUntil.getKsid() != null){
            knowledgeService.setKsid(knowledgeServiceUntil.getKsid());
        }
        knowledgeService.setKcid(knowledgeServiceUntil.getKcid());
        knowledgeService.setNdcid(Integer.valueOf(knowledgeServiceUntil.getNdcid()));
        if (knowledgeServiceUntil.getMid() != null){
            knowledgeService.setMid(knowledgeServiceUntil.getMid());
        }
        knowledgeService.setKspath(knowledgeServiceUntil.getKspath());
        knowledgeService.setKstitle(knowledgeServiceUntil.getKstitle());
        knowledgeService.setUserid(knowledgeServiceUntil.getUserid());
        return knowledgeService;
    }


    /**
     * @Description: knowledgeService 处理分页知识服务分页
     * @param: [page, size, userName, nameSearch, kcid]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/3 16:49
     */
    @GetMapping("/knowledgeService")
    @CrossOrigin
    public Result knowledgeService(@RequestParam(required = true,defaultValue = "1") Integer page,
                                   @RequestParam(required = true,defaultValue = "10") Integer size,
                                   @RequestParam(required = true) String userName,
                                   @RequestParam(required = false) String nameSearch,
                                   @RequestParam(required = true) String kcid){
        User user = new User();
        user.setUseraccount(userName);
        User userByUserAccount = loginService.getUserByUserAccount(user);
        UserUntil userUntil1 = new UserUntil();
        userUntil1.setUserid(userByUserAccount.getUserid());
        userUntil1.setUseraccount(userByUserAccount.getUseraccount());
        userUntil1.setUsername(userByUserAccount.getUsername());
        List<UserUntil> selfAndLowerUserByUserAccount = konwledgeService.getSelfAndLowerUserByUserAccount(userUntil1,
                kcid);
        userUntil1.setUserUntils(selfAndLowerUserByUserAccount);

        ArrayList<KnowledgeServiceUntil> knowledgeServiceUntils = new ArrayList<>();
        knowledgeServiceUntils = konwledgeService.getKonwledgeList(userUntil1, knowledgeServiceUntils,
                kcid, nameSearch);
        PageInfo<KnowledgeServiceUntil> pageInfo = PageInfoUtils.list2PageInfo(knowledgeServiceUntils, page, size);

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data", pageInfo.getList());
        stringObjectHashMap.put("total", pageInfo.getTotal());
        return Result.success(stringObjectHashMap);
    }

    /**
     * @Description: updateKnowledgeService 处理更新请请求
     * @param: [knowledgeServiceUntil]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/4 20:45
     */
    @PutMapping("/knowledgeService")
    @CrossOrigin
    public Result updateKnowledgeService(@RequestBody KnowledgeServiceUntil knowledgeServiceUntil){
        KnowledgeService k = setKonwledgeService(knowledgeServiceUntil);
        boolean bool = konwledgeService.updateKnowledgeService(k);
        if (bool){
            return Result.success("更新成功");
        }
        return Result.fail(404, "更新失败，请重试");
    }

    /**
     * @Description: delKnowledge 处理删除请求
     * @param: [knowledgeServiceUntil]
     * @return: cn.pluto.medicinal.untils.Result
     * @auther: zqq
     * @date: 20/5/4 20:51
     */
    @DeleteMapping("/knowledgeService/{ksid}")
    @CrossOrigin
    public Result delKnowledge(@PathVariable(required = true) Integer ksid){
        KnowledgeService k = new KnowledgeService();
        k.setKsid(ksid);
        boolean bool = konwledgeService.delKnowledgeService(k);
        if (bool){
            return Result.success("删除成功");
        }
        return Result.fail(404, "删除失败，请重试");
    }

}
