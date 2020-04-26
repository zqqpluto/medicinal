package cn.pluto.medicinal.pojo;

public class GovInfo {
    private Integer govId;

    private String userid;

    private String govDep;

    private String govMan;

    private String govPho;

    private String govPhoneSelf;

    private String govAddress;

    public Integer getGovId() {
        return govId;
    }

    public void setGovId(Integer govId) {
        this.govId = govId;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getGovDep() {
        return govDep;
    }

    public void setGovDep(String govDep) {
        this.govDep = govDep == null ? null : govDep.trim();
    }

    public String getGovMan() {
        return govMan;
    }

    public void setGovMan(String govMan) {
        this.govMan = govMan == null ? null : govMan.trim();
    }

    public String getGovPho() {
        return govPho;
    }

    public void setGovPho(String govPho) {
        this.govPho = govPho == null ? null : govPho.trim();
    }

    public String getGovPhoneSelf() {
        return govPhoneSelf;
    }

    public void setGovPhoneSelf(String govPhoneSelf) {
        this.govPhoneSelf = govPhoneSelf == null ? null : govPhoneSelf.trim();
    }

    public String getGovAddress() {
        return govAddress;
    }

    public void setGovAddress(String govAddress) {
        this.govAddress = govAddress == null ? null : govAddress.trim();
    }
}