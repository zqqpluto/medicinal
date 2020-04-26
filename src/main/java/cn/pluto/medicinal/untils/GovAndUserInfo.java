package cn.pluto.medicinal.untils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zqq
 * @create 2020-04-15-18:35
 */
@Getter
@Setter
public class GovAndUserInfo {

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
     * 所属部门
     */
    private String govermentDepartment;

    /**
     * 部门负责人
     */
    private String govermentMan;

    /**
     * 负责人电话号码
     */
    private String govermentPhone;

    /**
     * 本人电话号码
     */
    private String govermentPhoneSelf;

    /**
     * 联系地址
     */
    private String govermentAddrsss;

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

    @Override
    public String toString() {
        return "GovAndUserInfo{" +
                "userAccount='" + userAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", govermentDepartment='" + govermentDepartment + '\'' +
                ", govermentMan='" + govermentMan + '\'' +
                ", govermentPhone='" + govermentPhone + '\'' +
                ", govermentPhoneSelf='" + govermentPhoneSelf + '\'' +
                ", govermentAddrsss='" + govermentAddrsss + '\'' +
                ", fatherId='" + fatherId + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", fatherUserAccount='" + fatherUserAccount + '\'' +
                ", menuNumList=" + menuNumList +
                '}';
    }
}
