package cn.pluto.medicinal.service.imp;

import cn.pluto.medicinal.dao.AnounceMapper;
import cn.pluto.medicinal.dao.ManufacturerMapper;
import cn.pluto.medicinal.dao.UserMapper;
import cn.pluto.medicinal.dao.GovInfoMapper;
import cn.pluto.medicinal.pojo.*;
import cn.pluto.medicinal.service.AnounceService;
import cn.pluto.medicinal.untils.AnounceUntil;
import cn.pluto.medicinal.untils.UserUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zqq
 * @create 2020-05-05-9:27
 */
@Service
public class AnounceServiceImpl implements AnounceService {

    @Autowired
    private AnounceMapper anounceMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ManufacturerMapper manufacturerMapper;

    @Autowired
    private GovInfoMapper govinfoMapper;


    /**
     * @Description: getSelfAndLowerUserByUserAccount 获取当前用户及子用户
     * @param: [userUntil]
     * @return: java.util.List<cn.pluto.medicinal.untils.UserUntil>
     * @auther: zqq
     * @date: 20/5/5 9:54
     */
    @Override
    public List<UserUntil> getSelfAndLowerUserByUserAccount(UserUntil userUntil) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andFatheridEqualTo(userUntil.getUserid());
        List<User> users = userMapper.selectByExample(userExample);
        UserUntil userUntil1 = null;
        List<UserUntil>  untilList = new ArrayList<>();
        if (users.size() != 0){
            for (User user : users) {
                AnounceExample anounceExample = new AnounceExample();
                anounceExample.createCriteria().andUseridEqualTo(user.getUserid());
                List<Anounce> anounces = anounceMapper.selectByExample(anounceExample);
                if (anounces.size() != 0){
                    userUntil1 = new UserUntil();
                    userUntil1.setUserid(user.getUserid());
                    userUntil1.setUsername(user.getUsername());
                    userUntil1.setUseraccount(user.getUseraccount());
                    userUntil1.setUserUntils(getSelfAndLowerUserByUserAccount(userUntil1));
                    untilList.add(userUntil1);
                }
            }
            return untilList;
        }
        return null;
    }

    /**
     * @Description: addAnounce 添加公告
     * @param: [anounce]
     * @return: boolean
     * @auther: zqq
     * @date: 20/5/5 9:45
     */
    @Override
    public boolean addAnounce(Anounce anounce) {
        int insert = anounceMapper.insert(anounce);
        return insert == 1 ? true :false;
    }

    /**
     * @Description: getAnounceList 获取通告列表
     * @param: [userUntil1, anounceUntils, nameSearch]
     * @return: java.util.ArrayList<cn.pluto.medicinal.untils.AnounceUntil>
     * @auther: zqq
     * @date: 20/5/5 10:08
     */
    @Override
    public ArrayList<AnounceUntil> getAnounceList(UserUntil userUntil1,
                                                  ArrayList<AnounceUntil> anounceUntils, String nameSearch) {
        if (userUntil1.getUserUntils() != null){
            for (UserUntil userUntil : userUntil1.getUserUntils()) {
                anounceUntils = getAnounceList(userUntil, anounceUntils, nameSearch);
            }
        }
        AnounceExample anounceExample = new AnounceExample();
        AnounceExample.Criteria criteria = anounceExample.createCriteria();
        criteria.andUseridEqualTo(userUntil1.getUserid());
        if (!StringUtils.isEmpty(nameSearch)) {
            criteria.andAtitleEqualTo(nameSearch);
        }
        List<Anounce> anounceList = anounceMapper.selectByExampleWithBLOBs(anounceExample);

        AnounceUntil anounceUntil = null;
        ManufacturerExample manufacturerExample = null;
        if (anounceList.size() != 0){
            for (Anounce anounce : anounceList) {
                if (anounce.getMid() != null){
                    manufacturerExample= new ManufacturerExample();
                    manufacturerExample.createCriteria().andMidEqualTo(anounce.getMid());
                    List<Manufacturer> manufacturers = manufacturerMapper.selectByExample(manufacturerExample);
                    if (manufacturers.size() != 0){
                        anounceUntil = setAnounceUntil2(userUntil1, anounce, manufacturers.get(0));
                    }else {
                        GovInfoExample govInfoExample = new GovInfoExample();
                        govInfoExample.createCriteria().andGovIdEqualTo(anounce.getMid());
                        List<GovInfo> govInfos = govinfoMapper.selectByExample(govInfoExample);
                        anounceUntil = setAnounceUntil2(userUntil1, anounce, govInfos.get(0));
                    }
                }

                anounceUntils.add(anounceUntil);
            }
        }
        return anounceUntils;
    }

    private AnounceUntil setAnounceUntil2(UserUntil userUntil1, Anounce anounce, Object object) {
        AnounceUntil anounceUntil = new AnounceUntil();

        anounceUntil.setId(anounce.getId());
        anounceUntil.setAtitle(anounce.getAtitle());
        anounceUntil.setAcontent(anounce.getAcontent());

        anounceUntil.setUserid(userUntil1.getUserid());
        anounceUntil.setUseraccount(userUntil1.getUseraccount());
        anounceUntil.setUsername(userUntil1.getUsername());

        if (object instanceof Manufacturer){
            Manufacturer m = (Manufacturer) object;
            anounceUntil.setMid(m.getMid());
            anounceUntil.setMname(m.getMname());
        }else if (object instanceof GovInfo){
            GovInfo g = (GovInfo) object;
            anounceUntil.setMid(g.getGovId());
            anounceUntil.setMname(g.getGovDep());
        }
        return anounceUntil;
    }


    @Override
    public Manufacturer getExterprise(User userByUserAccount, boolean b) {
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
     * @Description: getGov 获取政府信息
     * @param: [userByUserAccount]
     * @return: cn.pluto.medicinal.pojo.GovInfo
     * @auther: zqq
     * @date: 20/5/5 12:02
     */
    @Override
    public GovInfo getGov(User userByUserAccount) {
        GovInfoExample govInfoExample = new GovInfoExample();
        govInfoExample.createCriteria().andUseridEqualTo(userByUserAccount.getUserid());
        return govinfoMapper.selectByExample(govInfoExample).get(0);
    }

    /**
     * @Description: delAounce 删除公告
     * @param: [anounce]
     * @return: boolean
     * @auther: zqq
     * @date: 20/5/5 13:51
     */
    @Override
    public boolean delAounce(Anounce anounce) {
        int i = anounceMapper.deleteByPrimaryKey(anounce.getId());
        return i == 1 ? true : false;
    }
}
