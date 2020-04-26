package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.KnowledgeServiceMapper;
import cn.pluto.medicinal.pojo.KnowledgeService;
import cn.pluto.medicinal.pojo.KnowledgeServiceExample;
import cn.pluto.medicinal.service.KnowledgeServiceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zqq
 * @create 2020-02-03-11:31
 */
@Service
public class KnowledgeServiceServiceImpl implements KnowledgeServiceService{

    @Autowired
    private KnowledgeServiceMapper knowledgeServiceMapper;

    private KnowledgeServiceExample knowledgeServiceExample;

    /**
     * @Description: konwledge
     * @param: [code, currentPage, pageSize]
     * @return: com.github.pagehelper.PageInfo<cn.pluto.medicinal.pojo.KnowledgeService>
     * @auther: zqq
     * @date: 20/2/4 10:33
     */
    @Override
    public PageInfo<KnowledgeService> konwledge(Integer code, Integer currentPage, Integer pageSize) {

        knowledgeServiceExample = new KnowledgeServiceExample();
        KnowledgeServiceExample.Criteria criteria = knowledgeServiceExample.createCriteria();
        criteria.andKcidEqualTo(code);
        PageHelper.startPage(currentPage,pageSize);
        List<KnowledgeService> knowledgeServices = knowledgeServiceMapper.selectByExample(knowledgeServiceExample);

        PageInfo<KnowledgeService> pageInfo = new PageInfo<KnowledgeService>(knowledgeServices);
        return pageInfo;
    }
}
