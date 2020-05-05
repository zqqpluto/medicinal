package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.GovInfoMapper;
import cn.pluto.medicinal.dao.KnowledgeServiceMapper;
import cn.pluto.medicinal.dao.ManufacturerMapper;
import cn.pluto.medicinal.dao.UserMapper;
import cn.pluto.medicinal.pojo.*;
import cn.pluto.medicinal.service.KnowledgeServiceService;
import cn.pluto.medicinal.untils.KnowledgeServiceUntil;
import cn.pluto.medicinal.untils.UserUntil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

    @Autowired
    private ManufacturerMapper manufacturerMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GovInfoMapper govinfoMapper;

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

    /**
     * @Description: getExterprise 通过userid查询
     * @param: [userByUserAccount]
     * @return: cn.pluto.medicinal.pojo.Manufacturer
     * @auther: zqq
     * @date: 20/5/3 10:06
     */
    @Override
    public Manufacturer getExterprise(User userByUserAccount, Boolean b) {
        ManufacturerExample manufacturerExample = new ManufacturerExample();
        ManufacturerExample.Criteria criteria = manufacturerExample.createCriteria();
        if (b){
            criteria.andUseridEqualTo(userByUserAccount.getUserid());
        }else {
            criteria.andUseridEqualTo(userByUserAccount.getFatherid());
        }
        List<Manufacturer> manufacturers = manufacturerMapper.selectByExample(manufacturerExample);
        if (manufacturers.size() == 1){
            return manufacturers.get(0);
        }
        return null;
    }

    /**
     * @Description: addKnowledgeService  添加知识服务
     * @param: [knowledgeService]
     * @return: boolean
     * @auther: zqq
     * @date: 20/5/3 15:37
     */
    @Override
    public boolean addKnowledgeService(KnowledgeService knowledgeService) {
        int insert = knowledgeServiceMapper.insert(knowledgeService);
        return insert == 1 ? true : false;
    }

    /**
     * @Description: getSelfAndLowerUserByUserAccount 获取自身与子用户的用户列表
     * @param: [userUntil, kcid]
     * @return: java.util.List<cn.pluto.medicinal.untils.UserUntil>
     * @auther: zqq
     * @date: 20/5/3 15:50
     */
    @Override
    public List<UserUntil> getSelfAndLowerUserByUserAccount(UserUntil userUntil, String kcid) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andFatheridEqualTo(userUntil.getUserid());
        List<User> users = userMapper.selectByExample(userExample);
        UserUntil userUntil1 = null;
        List<UserUntil>  untilList = new ArrayList<>();
        if (users.size() != 0){
            for (User user : users) {
                KnowledgeServiceExample knowledgeServiceExample = new KnowledgeServiceExample();
                knowledgeServiceExample.createCriteria().andUseridEqualTo(user.getUserid()).andKcidEqualTo(Integer.valueOf(kcid));
                List<KnowledgeService> knowledgeServices = knowledgeServiceMapper.selectByExample(knowledgeServiceExample);
                if (knowledgeServices.size() != 0){
                    userUntil1 = new UserUntil();
                    userUntil1.setUserid(user.getUserid());
                    userUntil1.setUsername(user.getUsername());
                    userUntil1.setUseraccount(user.getUseraccount());
                    userUntil1.setUserUntils(getSelfAndLowerUserByUserAccount(userUntil1, kcid));
                    untilList.add(userUntil1);
                }
            }
            return untilList;
        }
        return null;
    }


    /**
     * @Description: getKonwledgeList 获取知识服务列表
     * @param: [userUntil1, knowledgeServiceUntils]
     * @return: java.util.ArrayList<cn.pluto.medicinal.untils.KnowledgeServiceUntil>
     * @auther: zqq
     * @date: 20/5/3 16:10
     */
    @Override
    public ArrayList<KnowledgeServiceUntil>  getKonwledgeList(UserUntil userUntil1,
                                         ArrayList<KnowledgeServiceUntil> knowledgeServiceUntils, String kcid,
                                                              String nameSearch) {
        if (userUntil1.getUserUntils() != null){
            for (UserUntil userUntil : userUntil1.getUserUntils()) {
                knowledgeServiceUntils = getKonwledgeList(userUntil, knowledgeServiceUntils, kcid, nameSearch);
            }
        }
        KnowledgeServiceExample knowledgeServiceExample = new KnowledgeServiceExample();
        KnowledgeServiceExample.Criteria criteria = knowledgeServiceExample.createCriteria();
        criteria.andUseridEqualTo(userUntil1.getUserid()).andKcidEqualTo(Integer.valueOf(kcid));
        if (!StringUtils.isEmpty(nameSearch)) {
            criteria.andKstitleEqualTo(nameSearch);
        }
        List<KnowledgeService> knowledgeServices = knowledgeServiceMapper.selectByExample(knowledgeServiceExample);

        KnowledgeServiceUntil knowledgeServiceUntil = null;
        ManufacturerExample manufacturerExample = null;
        if (knowledgeServices.size() != 0){
            for (KnowledgeService knowledgeService : knowledgeServices) {
                if (knowledgeService.getMid() != null){
                    manufacturerExample= new ManufacturerExample();
                    manufacturerExample.createCriteria().andMidEqualTo(knowledgeService.getMid());
                    List<Manufacturer> manufacturers = manufacturerMapper.selectByExample(manufacturerExample);
                    if (manufacturers.size() != 0){
                        knowledgeServiceUntil = setKnowledgeUntil2(userUntil1, knowledgeService, manufacturers.get(0));
                    }else {
                        GovInfoExample govInfoExample = new GovInfoExample();
                        govInfoExample.createCriteria().andGovIdEqualTo(knowledgeService.getMid());
                        List<GovInfo> govInfos = govinfoMapper.selectByExample(govInfoExample);
                        knowledgeServiceUntil = setKnowledgeUntil2(userUntil1, knowledgeService, govInfos.get(0));
                    }
                }
            }
        }
        return knowledgeServiceUntils;
    }

    private KnowledgeServiceUntil setKnowledgeUntil2(UserUntil userUntil1, KnowledgeService knowledgeService,
                                                     Object object) {
        KnowledgeServiceUntil knowledgeServiceUntil = new KnowledgeServiceUntil();
        knowledgeServiceUntil.setKsid(knowledgeService.getKsid());
        knowledgeServiceUntil.setKcid(knowledgeService.getKcid());
        if (knowledgeService.getNdcid() == 1){
            knowledgeServiceUntil.setNdcid("乙类");
        }else if (knowledgeService.getNdcid() == 0){
            knowledgeServiceUntil.setNdcid("甲类");
        }

        knowledgeServiceUntil.setKspath(knowledgeService.getKspath());
        knowledgeServiceUntil.setKstitle(knowledgeService.getKstitle());

        knowledgeServiceUntil.setUserid(userUntil1.getUserid());
        knowledgeServiceUntil.setUseraccount(userUntil1.getUseraccount());
        knowledgeServiceUntil.setUsername(userUntil1.getUsername());

        if (object instanceof Manufacturer){
            Manufacturer m = (Manufacturer) object;
            knowledgeServiceUntil.setMid(m.getMid());
            knowledgeServiceUntil.setMname(m.getMname());
        }else if (object instanceof GovInfo){
            GovInfo g = (GovInfo) object;
            knowledgeServiceUntil.setMid(g.getGovId());
            knowledgeServiceUntil.setMname(g.getGovDep());
        }
        return knowledgeServiceUntil;
    }

    /**
     * @Description: updateKnowledgeService 更新知识服务库
     * @param: [k]
     * @return: boolean
     * @auther: zqq
     * @date: 20/5/4 20:43
     */
    @Override
    public boolean updateKnowledgeService(KnowledgeService k) {
        int i = knowledgeServiceMapper.updateByPrimaryKeySelective(k);
        return i == 1 ? true : false;
    }

    /**
     * @Description: delKnowledgeService 删除知识服务库
     * @param: [k]
     * @return: boolean
     * @auther: zqq
     * @date: 20/5/4 20:50
     */
    @Override
    public boolean delKnowledgeService(KnowledgeService k) {
        int i = knowledgeServiceMapper.deleteByPrimaryKey(k.getKsid());
        return i == 1 ? true : false;
    }
}
