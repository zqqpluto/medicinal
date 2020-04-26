package cn.pluto.medicinal.pojo;

public class KnowledgeService {
    private Integer ksid;

    private Integer kcid;

    private Integer ndcid;

    private Integer mid;

    private String kspath;

    private String kstitle;

    public Integer getKsid() {
        return ksid;
    }

    public void setKsid(Integer ksid) {
        this.ksid = ksid;
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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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