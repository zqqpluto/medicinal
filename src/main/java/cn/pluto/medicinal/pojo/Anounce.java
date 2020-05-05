package cn.pluto.medicinal.pojo;

public class Anounce {
    private Integer id;

    private String userid;

    private String atitle;

    private String mid;

    private String acontent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle == null ? null : atitle.trim();
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getAcontent() {
        return acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent == null ? null : acontent.trim();
    }
}