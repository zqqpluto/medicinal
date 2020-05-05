package cn.pluto.medicinal.pojo;

public class KnowledgeService {
    private Integer ksid;

    private String userid;

    private Integer kcid;

    private Integer ndcid;

    private String mid;

    private String kspath;

    private String kstitle;

    public Integer getKsid() {
        return ksid;
    }

    public void setKsid(Integer ksid) {
        this.ksid = ksid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getKcid() {
        return kcid;
    }

    public void setKcid(Integer kcid) {
        this.kcid = kcid;
    }

    public Integer getNdcid() {
        return ndcid;
    }

    public void setNdcid(Integer ndcid) {
        this.ndcid = ndcid;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getKspath() {
        return kspath;
    }

    public void setKspath(String kspath) {
        this.kspath = kspath == null ? null : kspath.trim();
    }

    public String getKstitle() {
        return kstitle;
    }

    public void setKstitle(String kstitle) {
        this.kstitle = kstitle == null ? null : kstitle.trim();
    }
}