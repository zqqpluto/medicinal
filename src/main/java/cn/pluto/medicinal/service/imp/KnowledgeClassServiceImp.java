package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.KnowledgeClassMapper;
import cn.pluto.medicinal.pojo.KnowledgeClass;
import cn.pluto.medicinal.service.KnowledgeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CHTW
 * @date 2020-01-30-17:34
 */
@Service
public class KnowledgeClassServiceImp implements KnowledgeClassService {

    @Autowired
    private KnowledgeClassMapper knowledgeClassMapper;

    @Override
    public KnowledgeClass findById(Integer id) {
        return knowledgeClassMapper.selectByPrimaryKey(id);
    }
}
