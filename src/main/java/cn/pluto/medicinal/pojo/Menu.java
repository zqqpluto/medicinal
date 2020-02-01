package cn.pluto.medicinal.pojo;

public class Menu {
    private Integer menuId;

    private Integer menuFatherId;

    private String menuName;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuFatherId() {
        return menuFatherId;
    }

    public void setMenuFatherId(Integer menuFatherId) {
        this.menuFatherId = menuFatherId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }
}