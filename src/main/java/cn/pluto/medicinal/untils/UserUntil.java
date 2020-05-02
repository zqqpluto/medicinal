package cn.pluto.medicinal.untils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zqq
 * @create 2020-05-01-11:21
 */
@Getter
@Setter
public class UserUntil {

    private String userid;

    private String useraccount;

    private String username;

    private Integer mid;

    private String mname;

    private List<UserUntil> userUntils;

}
