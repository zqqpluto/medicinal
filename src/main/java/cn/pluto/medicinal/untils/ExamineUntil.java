package cn.pluto.medicinal.untils;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

/**
 * @author zqq
 * @create 2020-04-27-15:47
 */
@Getter
@Setter
public class ExamineUntil implements Comparable<ExamineUntil>{

    /**
     * user表信息
     */
    private String userid;

    private String useraccount;

    private String username;

    private String userpassword;

    private String fatherid;

    private String fathername;

    /**
     * 非处方要信息
     */
    private String nid;

    private Integer mid;

    private String ndcid;

    private String nname;

    private String fromdrug;

    private String specs;

    private String indication;

    private String usetaboo;

    private String dosageandadministration;

    private String basis;

    private String remark;

    private String batch;

    private String newbatch;

    private String mark;

    private String newdrugcertificate;

    private String examineresult;

    private String examinefailmessage;

    private String examineuserid;

    /**
     * 企业名
     */
    private String mname;


    /**
     * @Description: compareTo 实现比较器
     * @param: [o]
     * @return: int
     * @auther: zqq
     * @date: 20/5/2 20:57
     */
    @Override
    public int compareTo(@NotNull ExamineUntil o) {
        int flag = this.username.compareTo(o.getUsername());
        if (flag == 0){
            flag = this.mark.compareTo(o.getMark());
        }
        if (flag == 0){
            flag = this.mname.compareTo(o.getMname());
        }
        return 0;
    }
}
