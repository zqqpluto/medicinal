package cn.pluto.medicinal.untils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author zqq
 * @create 2020-04-25-20:33
 */
@Getter
@Setter
@ToString
public class EnterpriseWorkerAndUserInfo {

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

    /**
     * 员工id
     */
    private String id2;

    /**
     * 员工userid
     */
    private String userid;

    /**
     * 员工名
     */
    private String workername;

    /**
     * 公司名
     */
    private String mname;
}
