package cn.pluto.medicinal.service;

import cn.pluto.medicinal.pojo.KnowledgeService;
import cn.pluto.medicinal.pojo.Manufacturer;
import cn.pluto.medicinal.pojo.User;
import cn.pluto.medicinal.untils.KnowledgeServiceUntil;
import cn.pluto.medicinal.untils.UserUntil;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zqq
 * @create 2020-02-03-11:27
 */
public interface KnowledgeServiceService {
    
    /**
     * @Description: 根据code查询所有该类别的资料
     * @param: code:分类依据码 currentPage：当前页码，pageSize每页条数
     * @return: 
     * @auther: zqq
     * @date: 20/2/3 11:45
     */
    public PageInfo<KnowledgeService> konwledge(Integer code, Integer currentPage, Integer pageSize);

    /**
     * 通过user查询企业信息
     * @param userByUserAccount
     * @return
     */
    Manufacturer getExterprise(User userByUserAccount, Boolean bool);

    /**
     * 添加知识服务
     * @param knowledgeService
     * @return
     */
    boolean addKnowledgeService(KnowledgeService knowledgeService);

    /**
     * 属于自己和子账户
     * @param userUntil
     * @return
     */
    List<UserUntil> getSelfAndLowerUserByUserAccount(UserUntil userUntil, String kcid);

    /**
     *
     * @param userUntil1
     * @param knowledgeServiceUntils
     * @return
     */
    ArrayList<KnowledgeServiceUntil> getKonwledgeList(UserUntil userUntil1,
                                                  ArrayList<KnowledgeServiceUntil> knowledgeServiceUntils,
                                                      String kcid, String nameSearch);

    /**
     * 更新知识服务库
     * @param k
     * @return
     */
    boolean updateKnowledgeService(KnowledgeService k);

    /**
     * 删除知识服务库
     * @param k
     * @return
     */
    boolean delKnowledgeService(KnowledgeService k);
}
