package cn.pluto.medicinal.pojo;

public class NonPrescriptionDrugClass {
    private Integer ndcid;

    private String ndcclass;

    public Integer getNdcid() {
        return ndcid;
    }

    public void setNdcid(Integer ndcid) {
        this.ndcid = ndcid;
    }

    public String getNdcclass() {
        return ndcclass;
    }

    public void setNdcclass(String ndcclass) {
        this.ndcclass = ndcclass == null ? null : ndcclass.trim();
    }
}