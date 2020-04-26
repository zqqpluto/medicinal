package cn.pluto.medicinal.untils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 菜单工具类
 * @author zqq
 * @create 2020-04-16-16:09
 */
@Getter
@Setter
@ToString
public class Menus {

    private String id;

    private String url;

    private String path;

    private String Component;

    private String name = "所有";

    private String iconCls;

    private String meta;

    private String parentId;

    private String enable;

    private List<Menus> children;

}
