package cn.pluto.medicinal.pojo;

import java.util.ArrayList;
import java.util.List;

public class NonPrescriptionDrugExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NonPrescriptionDrugExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andNidIsNull() {
            addCriterion("nId is null");
            return (Criteria) this;
        }

        public Criteria andNidIsNotNull() {
            addCriterion("nId is not null");
            return (Criteria) this;
        }

        public Criteria andNidEqualTo(String value) {
            addCriterion("nId =", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotEqualTo(String value) {
            addCriterion("nId <>", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThan(String value) {
            addCriterion("nId >", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThanOrEqualTo(String value) {
            addCriterion("nId >=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThan(String value) {
            addCriterion("nId <", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThanOrEqualTo(String value) {
            addCriterion("nId <=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLike(String value) {
            addCriterion("nId like", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotLike(String value) {
            addCriterion("nId not like", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidIn(List<String> values) {
            addCriterion("nId in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotIn(List<String> values) {
            addCriterion("nId not in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidBetween(String value1, String value2) {
            addCriterion("nId between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotBetween(String value1, String value2) {
            addCriterion("nId not between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMidIsNull() {
            addCriterion("mId is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mId is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(String value) {
            addCriterion("mId =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(String value) {
            addCriterion("mId <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(String value) {
            addCriterion("mId >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(String value) {
            addCriterion("mId >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(String value) {
            addCriterion("mId <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(String value) {
            addCriterion("mId <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLike(String value) {
            addCriterion("mId like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotLike(String value) {
            addCriterion("mId not like", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<String> values) {
            addCriterion("mId in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<String> values) {
            addCriterion("mId not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(String value1, String value2) {
            addCriterion("mId between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(String value1, String value2) {
            addCriterion("mId not between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andNdcidIsNull() {
            addCriterion("ndcId is null");
            return (Criteria) this;
        }

        public Criteria andNdcidIsNotNull() {
            addCriterion("ndcId is not null");
            return (Criteria) this;
        }

        public Criteria andNdcidEqualTo(Integer value) {
            addCriterion("ndcId =", value, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidNotEqualTo(Integer value) {
            addCriterion("ndcId <>", value, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidGreaterThan(Integer value) {
            addCriterion("ndcId >", value, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ndcId >=", value, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidLessThan(Integer value) {
            addCriterion("ndcId <", value, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidLessThanOrEqualTo(Integer value) {
            addCriterion("ndcId <=", value, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidIn(List<Integer> values) {
            addCriterion("ndcId in", values, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidNotIn(List<Integer> values) {
            addCriterion("ndcId not in", values, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidBetween(Integer value1, Integer value2) {
            addCriterion("ndcId between", value1, value2, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNdcidNotBetween(Integer value1, Integer value2) {
            addCriterion("ndcId not between", value1, value2, "ndcid");
            return (Criteria) this;
        }

        public Criteria andNnameIsNull() {
            addCriterion("nName is null");
            return (Criteria) this;
        }

        public Criteria andNnameIsNotNull() {
            addCriterion("nName is not null");
            return (Criteria) this;
        }

        public Criteria andNnameEqualTo(String value) {
            addCriterion("nName =", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameNotEqualTo(String value) {
            addCriterion("nName <>", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameGreaterThan(String value) {
            addCriterion("nName >", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameGreaterThanOrEqualTo(String value) {
            addCriterion("nName >=", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameLessThan(String value) {
            addCriterion("nName <", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameLessThanOrEqualTo(String value) {
            addCriterion("nName <=", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameLike(String value) {
            addCriterion("nName like", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameNotLike(String value) {
            addCriterion("nName not like", value, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameIn(List<String> values) {
            addCriterion("nName in", values, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameNotIn(List<String> values) {
            addCriterion("nName not in", values, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameBetween(String value1, String value2) {
            addCriterion("nName between", value1, value2, "nname");
            return (Criteria) this;
        }

        public Criteria andNnameNotBetween(String value1, String value2) {
            addCriterion("nName not between", value1, value2, "nname");
            return (Criteria) this;
        }

        public Criteria andFromdrugIsNull() {
            addCriterion("fromDrug is null");
            return (Criteria) this;
        }

        public Criteria andFromdrugIsNotNull() {
            addCriterion("fromDrug is not null");
            return (Criteria) this;
        }

        public Criteria andFromdrugEqualTo(String value) {
            addCriterion("fromDrug =", value, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugNotEqualTo(String value) {
            addCriterion("fromDrug <>", value, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugGreaterThan(String value) {
            addCriterion("fromDrug >", value, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugGreaterThanOrEqualTo(String value) {
            addCriterion("fromDrug >=", value, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugLessThan(String value) {
            addCriterion("fromDrug <", value, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugLessThanOrEqualTo(String value) {
            addCriterion("fromDrug <=", value, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugLike(String value) {
            addCriterion("fromDrug like", value, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugNotLike(String value) {
            addCriterion("fromDrug not like", value, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugIn(List<String> values) {
            addCriterion("fromDrug in", values, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugNotIn(List<String> values) {
            addCriterion("fromDrug not in", values, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugBetween(String value1, String value2) {
            addCriterion("fromDrug between", value1, value2, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andFromdrugNotBetween(String value1, String value2) {
            addCriterion("fromDrug not between", value1, value2, "fromdrug");
            return (Criteria) this;
        }

        public Criteria andSpecsIsNull() {
            addCriterion("specs is null");
            return (Criteria) this;
        }

        public Criteria andSpecsIsNotNull() {
            addCriterion("specs is not null");
            return (Criteria) this;
        }

        public Criteria andSpecsEqualTo(String value) {
            addCriterion("specs =", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotEqualTo(String value) {
            addCriterion("specs <>", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsGreaterThan(String value) {
            addCriterion("specs >", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsGreaterThanOrEqualTo(String value) {
            addCriterion("specs >=", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLessThan(String value) {
            addCriterion("specs <", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLessThanOrEqualTo(String value) {
            addCriterion("specs <=", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsLike(String value) {
            addCriterion("specs like", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotLike(String value) {
            addCriterion("specs not like", value, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsIn(List<String> values) {
            addCriterion("specs in", values, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotIn(List<String> values) {
            addCriterion("specs not in", values, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsBetween(String value1, String value2) {
            addCriterion("specs between", value1, value2, "specs");
            return (Criteria) this;
        }

        public Criteria andSpecsNotBetween(String value1, String value2) {
            addCriterion("specs not between", value1, value2, "specs");
            return (Criteria) this;
        }

        public Criteria andIndicationIsNull() {
            addCriterion("indication is null");
            return (Criteria) this;
        }

        public Criteria andIndicationIsNotNull() {
            addCriterion("indication is not null");
            return (Criteria) this;
        }

        public Criteria andIndicationEqualTo(String value) {
            addCriterion("indication =", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationNotEqualTo(String value) {
            addCriterion("indication <>", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationGreaterThan(String value) {
            addCriterion("indication >", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationGreaterThanOrEqualTo(String value) {
            addCriterion("indication >=", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationLessThan(String value) {
            addCriterion("indication <", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationLessThanOrEqualTo(String value) {
            addCriterion("indication <=", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationLike(String value) {
            addCriterion("indication like", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationNotLike(String value) {
            addCriterion("indication not like", value, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationIn(List<String> values) {
            addCriterion("indication in", values, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationNotIn(List<String> values) {
            addCriterion("indication not in", values, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationBetween(String value1, String value2) {
            addCriterion("indication between", value1, value2, "indication");
            return (Criteria) this;
        }

        public Criteria andIndicationNotBetween(String value1, String value2) {
            addCriterion("indication not between", value1, value2, "indication");
            return (Criteria) this;
        }

        public Criteria andUsetabooIsNull() {
            addCriterion("useTaboo is null");
            return (Criteria) this;
        }

        public Criteria andUsetabooIsNotNull() {
            addCriterion("useTaboo is not null");
            return (Criteria) this;
        }

        public Criteria andUsetabooEqualTo(String value) {
            addCriterion("useTaboo =", value, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooNotEqualTo(String value) {
            addCriterion("useTaboo <>", value, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooGreaterThan(String value) {
            addCriterion("useTaboo >", value, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooGreaterThanOrEqualTo(String value) {
            addCriterion("useTaboo >=", value, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooLessThan(String value) {
            addCriterion("useTaboo <", value, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooLessThanOrEqualTo(String value) {
            addCriterion("useTaboo <=", value, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooLike(String value) {
            addCriterion("useTaboo like", value, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooNotLike(String value) {
            addCriterion("useTaboo not like", value, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooIn(List<String> values) {
            addCriterion("useTaboo in", values, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooNotIn(List<String> values) {
            addCriterion("useTaboo not in", values, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooBetween(String value1, String value2) {
            addCriterion("useTaboo between", value1, value2, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andUsetabooNotBetween(String value1, String value2) {
            addCriterion("useTaboo not between", value1, value2, "usetaboo");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationIsNull() {
            addCriterion("dosageAndAdministration is null");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationIsNotNull() {
            addCriterion("dosageAndAdministration is not null");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationEqualTo(String value) {
            addCriterion("dosageAndAdministration =", value, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationNotEqualTo(String value) {
            addCriterion("dosageAndAdministration <>", value, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationGreaterThan(String value) {
            addCriterion("dosageAndAdministration >", value, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationGreaterThanOrEqualTo(String value) {
            addCriterion("dosageAndAdministration >=", value, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationLessThan(String value) {
            addCriterion("dosageAndAdministration <", value, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationLessThanOrEqualTo(String value) {
            addCriterion("dosageAndAdministration <=", value, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationLike(String value) {
            addCriterion("dosageAndAdministration like", value, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationNotLike(String value) {
            addCriterion("dosageAndAdministration not like", value, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationIn(List<String> values) {
            addCriterion("dosageAndAdministration in", values, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationNotIn(List<String> values) {
            addCriterion("dosageAndAdministration not in", values, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationBetween(String value1, String value2) {
            addCriterion("dosageAndAdministration between", value1, value2, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andDosageandadministrationNotBetween(String value1, String value2) {
            addCriterion("dosageAndAdministration not between", value1, value2, "dosageandadministration");
            return (Criteria) this;
        }

        public Criteria andBasisIsNull() {
            addCriterion("basis is null");
            return (Criteria) this;
        }

        public Criteria andBasisIsNotNull() {
            addCriterion("basis is not null");
            return (Criteria) this;
        }

        public Criteria andBasisEqualTo(String value) {
            addCriterion("basis =", value, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisNotEqualTo(String value) {
            addCriterion("basis <>", value, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisGreaterThan(String value) {
            addCriterion("basis >", value, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisGreaterThanOrEqualTo(String value) {
            addCriterion("basis >=", value, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisLessThan(String value) {
            addCriterion("basis <", value, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisLessThanOrEqualTo(String value) {
            addCriterion("basis <=", value, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisLike(String value) {
            addCriterion("basis like", value, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisNotLike(String value) {
            addCriterion("basis not like", value, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisIn(List<String> values) {
            addCriterion("basis in", values, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisNotIn(List<String> values) {
            addCriterion("basis not in", values, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisBetween(String value1, String value2) {
            addCriterion("basis between", value1, value2, "basis");
            return (Criteria) this;
        }

        public Criteria andBasisNotBetween(String value1, String value2) {
            addCriterion("basis not between", value1, value2, "basis");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBatchIsNull() {
            addCriterion("batch is null");
            return (Criteria) this;
        }

        public Criteria andBatchIsNotNull() {
            addCriterion("batch is not null");
            return (Criteria) this;
        }

        public Criteria andBatchEqualTo(String value) {
            addCriterion("batch =", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotEqualTo(String value) {
            addCriterion("batch <>", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThan(String value) {
            addCriterion("batch >", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchGreaterThanOrEqualTo(String value) {
            addCriterion("batch >=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThan(String value) {
            addCriterion("batch <", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLessThanOrEqualTo(String value) {
            addCriterion("batch <=", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchLike(String value) {
            addCriterion("batch like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotLike(String value) {
            addCriterion("batch not like", value, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchIn(List<String> values) {
            addCriterion("batch in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotIn(List<String> values) {
            addCriterion("batch not in", values, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchBetween(String value1, String value2) {
            addCriterion("batch between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andBatchNotBetween(String value1, String value2) {
            addCriterion("batch not between", value1, value2, "batch");
            return (Criteria) this;
        }

        public Criteria andNewbatchIsNull() {
            addCriterion("newBatch is null");
            return (Criteria) this;
        }

        public Criteria andNewbatchIsNotNull() {
            addCriterion("newBatch is not null");
            return (Criteria) this;
        }

        public Criteria andNewbatchEqualTo(String value) {
            addCriterion("newBatch =", value, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchNotEqualTo(String value) {
            addCriterion("newBatch <>", value, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchGreaterThan(String value) {
            addCriterion("newBatch >", value, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchGreaterThanOrEqualTo(String value) {
            addCriterion("newBatch >=", value, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchLessThan(String value) {
            addCriterion("newBatch <", value, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchLessThanOrEqualTo(String value) {
            addCriterion("newBatch <=", value, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchLike(String value) {
            addCriterion("newBatch like", value, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchNotLike(String value) {
            addCriterion("newBatch not like", value, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchIn(List<String> values) {
            addCriterion("newBatch in", values, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchNotIn(List<String> values) {
            addCriterion("newBatch not in", values, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchBetween(String value1, String value2) {
            addCriterion("newBatch between", value1, value2, "newbatch");
            return (Criteria) this;
        }

        public Criteria andNewbatchNotBetween(String value1, String value2) {
            addCriterion("newBatch not between", value1, value2, "newbatch");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateIsNull() {
            addCriterion("newDrugCertificate is null");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateIsNotNull() {
            addCriterion("newDrugCertificate is not null");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateEqualTo(String value) {
            addCriterion("newDrugCertificate =", value, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateNotEqualTo(String value) {
            addCriterion("newDrugCertificate <>", value, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateGreaterThan(String value) {
            addCriterion("newDrugCertificate >", value, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateGreaterThanOrEqualTo(String value) {
            addCriterion("newDrugCertificate >=", value, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateLessThan(String value) {
            addCriterion("newDrugCertificate <", value, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateLessThanOrEqualTo(String value) {
            addCriterion("newDrugCertificate <=", value, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateLike(String value) {
            addCriterion("newDrugCertificate like", value, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateNotLike(String value) {
            addCriterion("newDrugCertificate not like", value, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateIn(List<String> values) {
            addCriterion("newDrugCertificate in", values, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateNotIn(List<String> values) {
            addCriterion("newDrugCertificate not in", values, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateBetween(String value1, String value2) {
            addCriterion("newDrugCertificate between", value1, value2, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andNewdrugcertificateNotBetween(String value1, String value2) {
            addCriterion("newDrugCertificate not between", value1, value2, "newdrugcertificate");
            return (Criteria) this;
        }

        public Criteria andExamineresultIsNull() {
            addCriterion("examineResult is null");
            return (Criteria) this;
        }

        public Criteria andExamineresultIsNotNull() {
            addCriterion("examineResult is not null");
            return (Criteria) this;
        }

        public Criteria andExamineresultEqualTo(String value) {
            addCriterion("examineResult =", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultNotEqualTo(String value) {
            addCriterion("examineResult <>", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultGreaterThan(String value) {
            addCriterion("examineResult >", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultGreaterThanOrEqualTo(String value) {
            addCriterion("examineResult >=", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultLessThan(String value) {
            addCriterion("examineResult <", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultLessThanOrEqualTo(String value) {
            addCriterion("examineResult <=", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultLike(String value) {
            addCriterion("examineResult like", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultNotLike(String value) {
            addCriterion("examineResult not like", value, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultIn(List<String> values) {
            addCriterion("examineResult in", values, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultNotIn(List<String> values) {
            addCriterion("examineResult not in", values, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultBetween(String value1, String value2) {
            addCriterion("examineResult between", value1, value2, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExamineresultNotBetween(String value1, String value2) {
            addCriterion("examineResult not between", value1, value2, "examineresult");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageIsNull() {
            addCriterion("examineFailMessage is null");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageIsNotNull() {
            addCriterion("examineFailMessage is not null");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageEqualTo(String value) {
            addCriterion("examineFailMessage =", value, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageNotEqualTo(String value) {
            addCriterion("examineFailMessage <>", value, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageGreaterThan(String value) {
            addCriterion("examineFailMessage >", value, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageGreaterThanOrEqualTo(String value) {
            addCriterion("examineFailMessage >=", value, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageLessThan(String value) {
            addCriterion("examineFailMessage <", value, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageLessThanOrEqualTo(String value) {
            addCriterion("examineFailMessage <=", value, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageLike(String value) {
            addCriterion("examineFailMessage like", value, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageNotLike(String value) {
            addCriterion("examineFailMessage not like", value, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageIn(List<String> values) {
            addCriterion("examineFailMessage in", values, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageNotIn(List<String> values) {
            addCriterion("examineFailMessage not in", values, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageBetween(String value1, String value2) {
            addCriterion("examineFailMessage between", value1, value2, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExaminefailmessageNotBetween(String value1, String value2) {
            addCriterion("examineFailMessage not between", value1, value2, "examinefailmessage");
            return (Criteria) this;
        }

        public Criteria andExamineuseridIsNull() {
            addCriterion("examineUserId is null");
            return (Criteria) this;
        }

        public Criteria andExamineuseridIsNotNull() {
            addCriterion("examineUserId is not null");
            return (Criteria) this;
        }

        public Criteria andExamineuseridEqualTo(String value) {
            addCriterion("examineUserId =", value, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridNotEqualTo(String value) {
            addCriterion("examineUserId <>", value, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridGreaterThan(String value) {
            addCriterion("examineUserId >", value, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridGreaterThanOrEqualTo(String value) {
            addCriterion("examineUserId >=", value, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridLessThan(String value) {
            addCriterion("examineUserId <", value, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridLessThanOrEqualTo(String value) {
            addCriterion("examineUserId <=", value, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridLike(String value) {
            addCriterion("examineUserId like", value, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridNotLike(String value) {
            addCriterion("examineUserId not like", value, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridIn(List<String> values) {
            addCriterion("examineUserId in", values, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridNotIn(List<String> values) {
            addCriterion("examineUserId not in", values, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridBetween(String value1, String value2) {
            addCriterion("examineUserId between", value1, value2, "examineuserid");
            return (Criteria) this;
        }

        public Criteria andExamineuseridNotBetween(String value1, String value2) {
            addCriterion("examineUserId not between", value1, value2, "examineuserid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}