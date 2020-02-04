package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.pojo.KnowledgeService;
import cn.pluto.medicinal.service.imp.KnowledgeServiceServiceImpl;
import cn.pluto.medicinal.untils.PageKnowledge;
import cn.pluto.medicinal.untils.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author zqq
 * @create 2020-02-02-16:14
 */

@RestController
public class KnowledgeController {

    @Autowired
    private KnowledgeServiceServiceImpl knowledgeServiceServiceImpl;

    /**
     * @Description: 根据分类的code分页查询
     * @param:
     * @return:
     * @auther: zqq
     * @date: 20/2/3 11:23
     */
    @GetMapping("/knowledge")
    public Result knowledge(@RequestParam(required = true) Integer code,
                            @RequestParam(required = true,defaultValue = "1") Integer currentPage,
                            @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageInfo<KnowledgeService> info = knowledgeServiceServiceImpl.konwledge(code, currentPage, pageSize);
        return Result.success(info);
    }
}
