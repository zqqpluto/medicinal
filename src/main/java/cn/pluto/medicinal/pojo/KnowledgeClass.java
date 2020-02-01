package cn.pluto.medicinal.pojo;

public class KnowledgeClass {
    private Integer kcid;

    private String kcname;

    public Integer getKcid() {
        return kcid;
    }

    public void setKcid(Integer kcid) {
        this.kcid = kcid;
    }

    public String getKcname() {
        return kcname;
    }

    public void setKcname(String kcname) {
        this.kcname = kcname == null ? null : kcname.trim();
    }
}