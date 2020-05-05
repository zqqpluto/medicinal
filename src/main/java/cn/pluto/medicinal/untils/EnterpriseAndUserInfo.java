package cn.pluto.medicinal.untils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zqq
 * @create 2020-04-17-18:58
 */
@Getter
@Setter
@ToString
public class EnterpriseAndUserInfo {

    /**
     * userid
     */
    private String id;

    /**
     * 账户
     */
    private String userAccount;

    /**
     * 账户名
     */
    private String userName;

    /**
     * 账户密码
     */
    private String userPassword;

    /**
     * 父id
     */
    private String fatherId;

    /**
     * 父管理的名称
     */
    private String fatherName;

    /**
     * 父账户的账号
     */
    private String fatherUserAccount;

    /**
     * 分配权限菜单的id列表
     */
    private List<String> menuNumList;

    private String mid;

    private String userid;

    private String mname;

    private String province;

    private String web;

    private String recordnumber;

    private String productionnumber;

    private String mainproduce;

    private String legalperson;

    private String registeredcapital;

    private String paidincapital;

    private String stateoperation;

    private String establishtime;

    private String usccode;

    private String tinumber;

    private String rnumber;

    private String ocode;

    private String btype;

    private String industry;

    private String sanctiondate;

    private String registrationauthority;

    private String ename;

    private String oname;

    private String insurepersons;

    private String otstaff;

    private String operatingperiod;

    private String address;

    private String gmp;
}
