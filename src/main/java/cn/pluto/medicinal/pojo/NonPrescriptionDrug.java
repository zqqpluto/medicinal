package cn.pluto.medicinal.pojo;

public class NonPrescriptionDrug {
    private String nid;

    private String userid;

    private Integer mid;

    private Integer ndcid;

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

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid == null ? null : nid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getNdcid() {
        return ndcid;
    }

    public void setNdcid(Integer ndcid) {
        this.ndcid = ndcid;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname == null ? null : nname.trim();
    }

    public String getFromdrug() {
        return fromdrug;
    }

    public void setFromdrug(String fromdrug) {
        this.fromdrug = fromdrug == null ? null : fromdrug.trim();
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs == null ? null : specs.trim();
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication == null ? null : indication.trim();
    }

    public String getUsetaboo() {
        return usetaboo;
    }

    public void setUsetaboo(String usetaboo) {
        this.usetaboo = usetaboo == null ? null : usetaboo.trim();
    }

    public String getDosageandadministration() {
        return dosageandadministration;
    }

    public void setDosageandadministration(String dosageandadministration) {
        this.dosageandadministration = dosageandadministration == null ? null : dosageandadministration.trim();
    }

    public String getBasis() {
        return basis;
    }

    public void setBasis(String basis) {
        this.basis = basis == null ? null : basis.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch == null ? null : batch.trim();
    }

    public String getNewbatch() {
        return newbatch;
    }

    public void setNewbatch(String newbatch) {
        this.newbatch = newbatch == null ? null : newbatch.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getNewdrugcertificate() {
        return newdrugcertificate;
    }

    public void setNewdrugcertificate(String newdrugcertificate) {
        this.newdrugcertificate = newdrugcertificate == null ? null : newdrugcertificate.trim();
    }

    public String getExamineresult() {
        return examineresult;
    }

    public void setExamineresult(String examineresult) {
        this.examineresult = examineresult == null ? null : examineresult.trim();
    }

    public String getExaminefailmessage() {
        return examinefailmessage;
    }

    public void setExaminefailmessage(String examinefailmessage) {
        this.examinefailmessage = examinefailmessage == null ? null : examinefailmessage.trim();
    }

    public String getExamineuserid() {
        return examineuserid;
    }

    public void setExamineuserid(String examineuserid) {
        this.examineuserid = examineuserid == null ? null : examineuserid.trim();
    }
}