package cn.pluto.medicinal.controller;

import cn.pluto.medicinal.service.imp.KnowledgeClassServiceImpl;
import cn.pluto.medicinal.untils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CHTW
 * @date 2020-01-30-17:39
 */

@RestController
@RequestMapping("/kc")
public class KnowledgeClassController {

    @Autowired
    private KnowledgeClassServiceImpl knowledgeClassServiceImp;

    @RequestMapping("/findById")
    public Result findById(Integer id){
        return Result.success(knowledgeClassServiceImp.findById(id));
    }
}
