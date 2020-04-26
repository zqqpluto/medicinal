package cn.pluto.medicinal.service;

import cn.pluto.medicinal.pojo.KnowledgeService;
import com.github.pagehelper.PageInfo;

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
}
