package cn.pluto.medicinal.untils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 对权限菜单进行封装
 * @author zqq
 * @create 2020-04-13-10:47
 */

@Getter
@Setter
@ToString
public class Menu {
    private String id;
    private String icon;
    private String index;
    private String title;
    private List<Menu> subs;
}
