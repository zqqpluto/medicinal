package cn.pluto.medicinal.pojo;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManufacturerExample() {
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

        public Criteria andMidIsNull() {
            addCriterion("mId is null");
            return (Criteria) this;
        }

        public Criteria andMidIsNotNull() {
            addCriterion("mId is not null");
            return (Criteria) this;
        }

        public Criteria andMidEqualTo(Integer value) {
            addCriterion("mId =", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotEqualTo(Integer value) {
            addCriterion("mId <>", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThan(Integer value) {
            addCriterion("mId >", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidGreaterThanOrEqualTo(Integer value) {
            addCriterion("mId >=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThan(Integer value) {
            addCriterion("mId <", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidLessThanOrEqualTo(Integer value) {
            addCriterion("mId <=", value, "mid");
            return (Criteria) this;
        }

        public Criteria andMidIn(List<Integer> values) {
            addCriterion("mId in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotIn(List<Integer> values) {
            addCriterion("mId not in", values, "mid");
            return (Criteria) this;
        }

        public Criteria andMidBetween(Integer value1, Integer value2) {
            addCriterion("mId between", value1, value2, "mid");
            return (Criteria) this;
        }

        public Criteria andMidNotBetween(Integer value1, Integer value2) {
            addCriterion("mId not between", value1, value2, "mid");
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

        public Criteria andMnameIsNull() {
            addCriterion("mName is null");
            return (Criteria) this;
        }

        public Criteria andMnameIsNotNull() {
            addCriterion("mName is not null");
            return (Criteria) this;
        }

        public Criteria andMnameEqualTo(String value) {
            addCriterion("mName =", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotEqualTo(String value) {
            addCriterion("mName <>", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThan(String value) {
            addCriterion("mName >", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThanOrEqualTo(String value) {
            addCriterion("mName >=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThan(String value) {
            addCriterion("mName <", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThanOrEqualTo(String value) {
            addCriterion("mName <=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLike(String value) {
            addCriterion("mName like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotLike(String value) {
            addCriterion("mName not like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameIn(List<String> values) {
            addCriterion("mName in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotIn(List<String> values) {
            addCriterion("mName not in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameBetween(String value1, String value2) {
            addCriterion("mName between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotBetween(String value1, String value2) {
            addCriterion("mName not between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andWebIsNull() {
            addCriterion("web is null");
            return (Criteria) this;
        }

        public Criteria andWebIsNotNull() {
            addCriterion("web is not null");
            return (Criteria) this;
        }

        public Criteria andWebEqualTo(String value) {
            addCriterion("web =", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotEqualTo(String value) {
            addCriterion("web <>", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebGreaterThan(String value) {
            addCriterion("web >", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebGreaterThanOrEqualTo(String value) {
            addCriterion("web >=", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebLessThan(String value) {
            addCriterion("web <", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebLessThanOrEqualTo(String value) {
            addCriterion("web <=", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebLike(String value) {
            addCriterion("web like", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotLike(String value) {
            addCriterion("web not like", value, "web");
            return (Criteria) this;
        }

        public Criteria andWebIn(List<String> values) {
            addCriterion("web in", values, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotIn(List<String> values) {
            addCriterion("web not in", values, "web");
            return (Criteria) this;
        }

        public Criteria andWebBetween(String value1, String value2) {
            addCriterion("web between", value1, value2, "web");
            return (Criteria) this;
        }

        public Criteria andWebNotBetween(String value1, String value2) {
            addCriterion("web not between", value1, value2, "web");
            return (Criteria) this;
        }

        public Criteria andRecordnumberIsNull() {
            addCriterion("recordNumber is null");
            return (Criteria) this;
        }

        public Criteria andRecordnumberIsNotNull() {
            addCriterion("recordNumber is not null");
            return (Criteria) this;
        }

        public Criteria andRecordnumberEqualTo(String value) {
            addCriterion("recordNumber =", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberNotEqualTo(String value) {
            addCriterion("recordNumber <>", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberGreaterThan(String value) {
            addCriterion("recordNumber >", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberGreaterThanOrEqualTo(String value) {
            addCriterion("recordNumber >=", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberLessThan(String value) {
            addCriterion("recordNumber <", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberLessThanOrEqualTo(String value) {
            addCriterion("recordNumber <=", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberLike(String value) {
            addCriterion("recordNumber like", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberNotLike(String value) {
            addCriterion("recordNumber not like", value, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberIn(List<String> values) {
            addCriterion("recordNumber in", values, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberNotIn(List<String> values) {
            addCriterion("recordNumber not in", values, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberBetween(String value1, String value2) {
            addCriterion("recordNumber between", value1, value2, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andRecordnumberNotBetween(String value1, String value2) {
            addCriterion("recordNumber not between", value1, value2, "recordnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberIsNull() {
            addCriterion("productionNumber is null");
            return (Criteria) this;
        }

        public Criteria andProductionnumberIsNotNull() {
            addCriterion("productionNumber is not null");
            return (Criteria) this;
        }

        public Criteria andProductionnumberEqualTo(String value) {
            addCriterion("productionNumber =", value, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberNotEqualTo(String value) {
            addCriterion("productionNumber <>", value, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberGreaterThan(String value) {
            addCriterion("productionNumber >", value, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberGreaterThanOrEqualTo(String value) {
            addCriterion("productionNumber >=", value, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberLessThan(String value) {
            addCriterion("productionNumber <", value, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberLessThanOrEqualTo(String value) {
            addCriterion("productionNumber <=", value, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberLike(String value) {
            addCriterion("productionNumber like", value, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberNotLike(String value) {
            addCriterion("productionNumber not like", value, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberIn(List<String> values) {
            addCriterion("productionNumber in", values, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberNotIn(List<String> values) {
            addCriterion("productionNumber not in", values, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberBetween(String value1, String value2) {
            addCriterion("productionNumber between", value1, value2, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andProductionnumberNotBetween(String value1, String value2) {
            addCriterion("productionNumber not between", value1, value2, "productionnumber");
            return (Criteria) this;
        }

        public Criteria andMainproduceIsNull() {
            addCriterion("mainProduce is null");
            return (Criteria) this;
        }

        public Criteria andMainproduceIsNotNull() {
            addCriterion("mainProduce is not null");
            return (Criteria) this;
        }

        public Criteria andMainproduceEqualTo(String value) {
            addCriterion("mainProduce =", value, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceNotEqualTo(String value) {
            addCriterion("mainProduce <>", value, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceGreaterThan(String value) {
            addCriterion("mainProduce >", value, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceGreaterThanOrEqualTo(String value) {
            addCriterion("mainProduce >=", value, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceLessThan(String value) {
            addCriterion("mainProduce <", value, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceLessThanOrEqualTo(String value) {
            addCriterion("mainProduce <=", value, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceLike(String value) {
            addCriterion("mainProduce like", value, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceNotLike(String value) {
            addCriterion("mainProduce not like", value, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceIn(List<String> values) {
            addCriterion("mainProduce in", values, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceNotIn(List<String> values) {
            addCriterion("mainProduce not in", values, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceBetween(String value1, String value2) {
            addCriterion("mainProduce between", value1, value2, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andMainproduceNotBetween(String value1, String value2) {
            addCriterion("mainProduce not between", value1, value2, "mainproduce");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIsNull() {
            addCriterion("legalPerson is null");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIsNotNull() {
            addCriterion("legalPerson is not null");
            return (Criteria) this;
        }

        public Criteria andLegalpersonEqualTo(String value) {
            addCriterion("legalPerson =", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotEqualTo(String value) {
            addCriterion("legalPerson <>", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonGreaterThan(String value) {
            addCriterion("legalPerson >", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonGreaterThanOrEqualTo(String value) {
            addCriterion("legalPerson >=", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLessThan(String value) {
            addCriterion("legalPerson <", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLessThanOrEqualTo(String value) {
            addCriterion("legalPerson <=", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLike(String value) {
            addCriterion("legalPerson like", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotLike(String value) {
            addCriterion("legalPerson not like", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIn(List<String> values) {
            addCriterion("legalPerson in", values, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotIn(List<String> values) {
            addCriterion("legalPerson not in", values, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonBetween(String value1, String value2) {
            addCriterion("legalPerson between", value1, value2, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotBetween(String value1, String value2) {
            addCriterion("legalPerson not between", value1, value2, "legalperson");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalIsNull() {
            addCriterion("registeredCapital is null");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalIsNotNull() {
            addCriterion("registeredCapital is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalEqualTo(String value) {
            addCriterion("registeredCapital =", value, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalNotEqualTo(String value) {
            addCriterion("registeredCapital <>", value, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalGreaterThan(String value) {
            addCriterion("registeredCapital >", value, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalGreaterThanOrEqualTo(String value) {
            addCriterion("registeredCapital >=", value, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalLessThan(String value) {
            addCriterion("registeredCapital <", value, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalLessThanOrEqualTo(String value) {
            addCriterion("registeredCapital <=", value, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalLike(String value) {
            addCriterion("registeredCapital like", value, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalNotLike(String value) {
            addCriterion("registeredCapital not like", value, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalIn(List<String> values) {
            addCriterion("registeredCapital in", values, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalNotIn(List<String> values) {
            addCriterion("registeredCapital not in", values, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalBetween(String value1, String value2) {
            addCriterion("registeredCapital between", value1, value2, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andRegisteredcapitalNotBetween(String value1, String value2) {
            addCriterion("registeredCapital not between", value1, value2, "registeredcapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalIsNull() {
            addCriterion("paidinCapital is null");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalIsNotNull() {
            addCriterion("paidinCapital is not null");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalEqualTo(String value) {
            addCriterion("paidinCapital =", value, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalNotEqualTo(String value) {
            addCriterion("paidinCapital <>", value, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalGreaterThan(String value) {
            addCriterion("paidinCapital >", value, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalGreaterThanOrEqualTo(String value) {
            addCriterion("paidinCapital >=", value, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalLessThan(String value) {
            addCriterion("paidinCapital <", value, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalLessThanOrEqualTo(String value) {
            addCriterion("paidinCapital <=", value, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalLike(String value) {
            addCriterion("paidinCapital like", value, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalNotLike(String value) {
            addCriterion("paidinCapital not like", value, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalIn(List<String> values) {
            addCriterion("paidinCapital in", values, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalNotIn(List<String> values) {
            addCriterion("paidinCapital not in", values, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalBetween(String value1, String value2) {
            addCriterion("paidinCapital between", value1, value2, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andPaidincapitalNotBetween(String value1, String value2) {
            addCriterion("paidinCapital not between", value1, value2, "paidincapital");
            return (Criteria) this;
        }

        public Criteria andStateoperationIsNull() {
            addCriterion("stateOperation is null");
            return (Criteria) this;
        }

        public Criteria andStateoperationIsNotNull() {
            addCriterion("stateOperation is not null");
            return (Criteria) this;
        }

        public Criteria andStateoperationEqualTo(String value) {
            addCriterion("stateOperation =", value, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationNotEqualTo(String value) {
            addCriterion("stateOperation <>", value, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationGreaterThan(String value) {
            addCriterion("stateOperation >", value, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationGreaterThanOrEqualTo(String value) {
            addCriterion("stateOperation >=", value, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationLessThan(String value) {
            addCriterion("stateOperation <", value, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationLessThanOrEqualTo(String value) {
            addCriterion("stateOperation <=", value, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationLike(String value) {
            addCriterion("stateOperation like", value, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationNotLike(String value) {
            addCriterion("stateOperation not like", value, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationIn(List<String> values) {
            addCriterion("stateOperation in", values, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationNotIn(List<String> values) {
            addCriterion("stateOperation not in", values, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationBetween(String value1, String value2) {
            addCriterion("stateOperation between", value1, value2, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andStateoperationNotBetween(String value1, String value2) {
            addCriterion("stateOperation not between", value1, value2, "stateoperation");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeIsNull() {
            addCriterion("establishTime is null");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeIsNotNull() {
            addCriterion("establishTime is not null");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeEqualTo(String value) {
            addCriterion("establishTime =", value, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeNotEqualTo(String value) {
            addCriterion("establishTime <>", value, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeGreaterThan(String value) {
            addCriterion("establishTime >", value, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeGreaterThanOrEqualTo(String value) {
            addCriterion("establishTime >=", value, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeLessThan(String value) {
            addCriterion("establishTime <", value, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeLessThanOrEqualTo(String value) {
            addCriterion("establishTime <=", value, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeLike(String value) {
            addCriterion("establishTime like", value, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeNotLike(String value) {
            addCriterion("establishTime not like", value, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeIn(List<String> values) {
            addCriterion("establishTime in", values, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeNotIn(List<String> values) {
            addCriterion("establishTime not in", values, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeBetween(String value1, String value2) {
            addCriterion("establishTime between", value1, value2, "establishtime");
            return (Criteria) this;
        }

        public Criteria andEstablishtimeNotBetween(String value1, String value2) {
            addCriterion("establishTime not between", value1, value2, "establishtime");
            return (Criteria) this;
        }

        public Criteria andUsccodeIsNull() {
            addCriterion("uscCode is null");
            return (Criteria) this;
        }

        public Criteria andUsccodeIsNotNull() {
            addCriterion("uscCode is not null");
            return (Criteria) this;
        }

        public Criteria andUsccodeEqualTo(String value) {
            addCriterion("uscCode =", value, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeNotEqualTo(String value) {
            addCriterion("uscCode <>", value, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeGreaterThan(String value) {
            addCriterion("uscCode >", value, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeGreaterThanOrEqualTo(String value) {
            addCriterion("uscCode >=", value, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeLessThan(String value) {
            addCriterion("uscCode <", value, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeLessThanOrEqualTo(String value) {
            addCriterion("uscCode <=", value, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeLike(String value) {
            addCriterion("uscCode like", value, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeNotLike(String value) {
            addCriterion("uscCode not like", value, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeIn(List<String> values) {
            addCriterion("uscCode in", values, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeNotIn(List<String> values) {
            addCriterion("uscCode not in", values, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeBetween(String value1, String value2) {
            addCriterion("uscCode between", value1, value2, "usccode");
            return (Criteria) this;
        }

        public Criteria andUsccodeNotBetween(String value1, String value2) {
            addCriterion("uscCode not between", value1, value2, "usccode");
            return (Criteria) this;
        }

        public Criteria andTinumberIsNull() {
            addCriterion("tiNumber is null");
            return (Criteria) this;
        }

        public Criteria andTinumberIsNotNull() {
            addCriterion("tiNumber is not null");
            return (Criteria) this;
        }

        public Criteria andTinumberEqualTo(String value) {
            addCriterion("tiNumber =", value, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberNotEqualTo(String value) {
            addCriterion("tiNumber <>", value, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberGreaterThan(String value) {
            addCriterion("tiNumber >", value, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberGreaterThanOrEqualTo(String value) {
            addCriterion("tiNumber >=", value, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberLessThan(String value) {
            addCriterion("tiNumber <", value, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberLessThanOrEqualTo(String value) {
            addCriterion("tiNumber <=", value, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberLike(String value) {
            addCriterion("tiNumber like", value, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberNotLike(String value) {
            addCriterion("tiNumber not like", value, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberIn(List<String> values) {
            addCriterion("tiNumber in", values, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberNotIn(List<String> values) {
            addCriterion("tiNumber not in", values, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberBetween(String value1, String value2) {
            addCriterion("tiNumber between", value1, value2, "tinumber");
            return (Criteria) this;
        }

        public Criteria andTinumberNotBetween(String value1, String value2) {
            addCriterion("tiNumber not between", value1, value2, "tinumber");
            return (Criteria) this;
        }

        public Criteria andRnumberIsNull() {
            addCriterion("rNumber is null");
            return (Criteria) this;
        }

        public Criteria andRnumberIsNotNull() {
            addCriterion("rNumber is not null");
            return (Criteria) this;
        }

        public Criteria andRnumberEqualTo(String value) {
            addCriterion("rNumber =", value, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberNotEqualTo(String value) {
            addCriterion("rNumber <>", value, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberGreaterThan(String value) {
            addCriterion("rNumber >", value, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberGreaterThanOrEqualTo(String value) {
            addCriterion("rNumber >=", value, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberLessThan(String value) {
            addCriterion("rNumber <", value, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberLessThanOrEqualTo(String value) {
            addCriterion("rNumber <=", value, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberLike(String value) {
            addCriterion("rNumber like", value, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberNotLike(String value) {
            addCriterion("rNumber not like", value, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberIn(List<String> values) {
            addCriterion("rNumber in", values, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberNotIn(List<String> values) {
            addCriterion("rNumber not in", values, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberBetween(String value1, String value2) {
            addCriterion("rNumber between", value1, value2, "rnumber");
            return (Criteria) this;
        }

        public Criteria andRnumberNotBetween(String value1, String value2) {
            addCriterion("rNumber not between", value1, value2, "rnumber");
            return (Criteria) this;
        }

        public Criteria andOcodeIsNull() {
            addCriterion("oCode is null");
            return (Criteria) this;
        }

        public Criteria andOcodeIsNotNull() {
            addCriterion("oCode is not null");
            return (Criteria) this;
        }

        public Criteria andOcodeEqualTo(String value) {
            addCriterion("oCode =", value, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeNotEqualTo(String value) {
            addCriterion("oCode <>", value, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeGreaterThan(String value) {
            addCriterion("oCode >", value, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeGreaterThanOrEqualTo(String value) {
            addCriterion("oCode >=", value, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeLessThan(String value) {
            addCriterion("oCode <", value, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeLessThanOrEqualTo(String value) {
            addCriterion("oCode <=", value, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeLike(String value) {
            addCriterion("oCode like", value, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeNotLike(String value) {
            addCriterion("oCode not like", value, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeIn(List<String> values) {
            addCriterion("oCode in", values, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeNotIn(List<String> values) {
            addCriterion("oCode not in", values, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeBetween(String value1, String value2) {
            addCriterion("oCode between", value1, value2, "ocode");
            return (Criteria) this;
        }

        public Criteria andOcodeNotBetween(String value1, String value2) {
            addCriterion("oCode not between", value1, value2, "ocode");
            return (Criteria) this;
        }

        public Criteria andBtypeIsNull() {
            addCriterion("bType is null");
            return (Criteria) this;
        }

        public Criteria andBtypeIsNotNull() {
            addCriterion("bType is not null");
            return (Criteria) this;
        }

        public Criteria andBtypeEqualTo(String value) {
            addCriterion("bType =", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotEqualTo(String value) {
            addCriterion("bType <>", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeGreaterThan(String value) {
            addCriterion("bType >", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeGreaterThanOrEqualTo(String value) {
            addCriterion("bType >=", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeLessThan(String value) {
            addCriterion("bType <", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeLessThanOrEqualTo(String value) {
            addCriterion("bType <=", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeLike(String value) {
            addCriterion("bType like", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotLike(String value) {
            addCriterion("bType not like", value, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeIn(List<String> values) {
            addCriterion("bType in", values, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotIn(List<String> values) {
            addCriterion("bType not in", values, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeBetween(String value1, String value2) {
            addCriterion("bType between", value1, value2, "btype");
            return (Criteria) this;
        }

        public Criteria andBtypeNotBetween(String value1, String value2) {
            addCriterion("bType not between", value1, value2, "btype");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andSanctiondateIsNull() {
            addCriterion("sanctionDate is null");
            return (Criteria) this;
        }

        public Criteria andSanctiondateIsNotNull() {
            addCriterion("sanctionDate is not null");
            return (Criteria) this;
        }

        public Criteria andSanctiondateEqualTo(String value) {
            addCriterion("sanctionDate =", value, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateNotEqualTo(String value) {
            addCriterion("sanctionDate <>", value, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateGreaterThan(String value) {
            addCriterion("sanctionDate >", value, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateGreaterThanOrEqualTo(String value) {
            addCriterion("sanctionDate >=", value, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateLessThan(String value) {
            addCriterion("sanctionDate <", value, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateLessThanOrEqualTo(String value) {
            addCriterion("sanctionDate <=", value, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateLike(String value) {
            addCriterion("sanctionDate like", value, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateNotLike(String value) {
            addCriterion("sanctionDate not like", value, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateIn(List<String> values) {
            addCriterion("sanctionDate in", values, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateNotIn(List<String> values) {
            addCriterion("sanctionDate not in", values, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateBetween(String value1, String value2) {
            addCriterion("sanctionDate between", value1, value2, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andSanctiondateNotBetween(String value1, String value2) {
            addCriterion("sanctionDate not between", value1, value2, "sanctiondate");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityIsNull() {
            addCriterion("registrationAuthority is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityIsNotNull() {
            addCriterion("registrationAuthority is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityEqualTo(String value) {
            addCriterion("registrationAuthority =", value, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityNotEqualTo(String value) {
            addCriterion("registrationAuthority <>", value, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityGreaterThan(String value) {
            addCriterion("registrationAuthority >", value, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityGreaterThanOrEqualTo(String value) {
            addCriterion("registrationAuthority >=", value, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityLessThan(String value) {
            addCriterion("registrationAuthority <", value, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityLessThanOrEqualTo(String value) {
            addCriterion("registrationAuthority <=", value, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityLike(String value) {
            addCriterion("registrationAuthority like", value, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityNotLike(String value) {
            addCriterion("registrationAuthority not like", value, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityIn(List<String> values) {
            addCriterion("registrationAuthority in", values, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityNotIn(List<String> values) {
            addCriterion("registrationAuthority not in", values, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityBetween(String value1, String value2) {
            addCriterion("registrationAuthority between", value1, value2, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andRegistrationauthorityNotBetween(String value1, String value2) {
            addCriterion("registrationAuthority not between", value1, value2, "registrationauthority");
            return (Criteria) this;
        }

        public Criteria andEnameIsNull() {
            addCriterion("eName is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("eName is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("eName =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("eName <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("eName >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("eName >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("eName <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("eName <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("eName like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("eName not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("eName in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("eName not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("eName between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("eName not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andOnameIsNull() {
            addCriterion("oName is null");
            return (Criteria) this;
        }

        public Criteria andOnameIsNotNull() {
            addCriterion("oName is not null");
            return (Criteria) this;
        }

        public Criteria andOnameEqualTo(String value) {
            addCriterion("oName =", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotEqualTo(String value) {
            addCriterion("oName <>", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameGreaterThan(String value) {
            addCriterion("oName >", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameGreaterThanOrEqualTo(String value) {
            addCriterion("oName >=", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLessThan(String value) {
            addCriterion("oName <", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLessThanOrEqualTo(String value) {
            addCriterion("oName <=", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameLike(String value) {
            addCriterion("oName like", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotLike(String value) {
            addCriterion("oName not like", value, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameIn(List<String> values) {
            addCriterion("oName in", values, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotIn(List<String> values) {
            addCriterion("oName not in", values, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameBetween(String value1, String value2) {
            addCriterion("oName between", value1, value2, "oname");
            return (Criteria) this;
        }

        public Criteria andOnameNotBetween(String value1, String value2) {
            addCriterion("oName not between", value1, value2, "oname");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsIsNull() {
            addCriterion("insurePersons is null");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsIsNotNull() {
            addCriterion("insurePersons is not null");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsEqualTo(String value) {
            addCriterion("insurePersons =", value, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsNotEqualTo(String value) {
            addCriterion("insurePersons <>", value, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsGreaterThan(String value) {
            addCriterion("insurePersons >", value, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsGreaterThanOrEqualTo(String value) {
            addCriterion("insurePersons >=", value, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsLessThan(String value) {
            addCriterion("insurePersons <", value, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsLessThanOrEqualTo(String value) {
            addCriterion("insurePersons <=", value, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsLike(String value) {
            addCriterion("insurePersons like", value, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsNotLike(String value) {
            addCriterion("insurePersons not like", value, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsIn(List<String> values) {
            addCriterion("insurePersons in", values, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsNotIn(List<String> values) {
            addCriterion("insurePersons not in", values, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsBetween(String value1, String value2) {
            addCriterion("insurePersons between", value1, value2, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andInsurepersonsNotBetween(String value1, String value2) {
            addCriterion("insurePersons not between", value1, value2, "insurepersons");
            return (Criteria) this;
        }

        public Criteria andOtstaffIsNull() {
            addCriterion("otStaff is null");
            return (Criteria) this;
        }

        public Criteria andOtstaffIsNotNull() {
            addCriterion("otStaff is not null");
            return (Criteria) this;
        }

        public Criteria andOtstaffEqualTo(String value) {
            addCriterion("otStaff =", value, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffNotEqualTo(String value) {
            addCriterion("otStaff <>", value, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffGreaterThan(String value) {
            addCriterion("otStaff >", value, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffGreaterThanOrEqualTo(String value) {
            addCriterion("otStaff >=", value, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffLessThan(String value) {
            addCriterion("otStaff <", value, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffLessThanOrEqualTo(String value) {
            addCriterion("otStaff <=", value, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffLike(String value) {
            addCriterion("otStaff like", value, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffNotLike(String value) {
            addCriterion("otStaff not like", value, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffIn(List<String> values) {
            addCriterion("otStaff in", values, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffNotIn(List<String> values) {
            addCriterion("otStaff not in", values, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffBetween(String value1, String value2) {
            addCriterion("otStaff between", value1, value2, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOtstaffNotBetween(String value1, String value2) {
            addCriterion("otStaff not between", value1, value2, "otstaff");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodIsNull() {
            addCriterion("operatingPeriod is null");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodIsNotNull() {
            addCriterion("operatingPeriod is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodEqualTo(String value) {
            addCriterion("operatingPeriod =", value, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodNotEqualTo(String value) {
            addCriterion("operatingPeriod <>", value, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodGreaterThan(String value) {
            addCriterion("operatingPeriod >", value, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodGreaterThanOrEqualTo(String value) {
            addCriterion("operatingPeriod >=", value, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodLessThan(String value) {
            addCriterion("operatingPeriod <", value, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodLessThanOrEqualTo(String value) {
            addCriterion("operatingPeriod <=", value, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodLike(String value) {
            addCriterion("operatingPeriod like", value, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodNotLike(String value) {
            addCriterion("operatingPeriod not like", value, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodIn(List<String> values) {
            addCriterion("operatingPeriod in", values, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodNotIn(List<String> values) {
            addCriterion("operatingPeriod not in", values, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodBetween(String value1, String value2) {
            addCriterion("operatingPeriod between", value1, value2, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andOperatingperiodNotBetween(String value1, String value2) {
            addCriterion("operatingPeriod not between", value1, value2, "operatingperiod");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andGmpIsNull() {
            addCriterion("gmp is null");
            return (Criteria) this;
        }

        public Criteria andGmpIsNotNull() {
            addCriterion("gmp is not null");
            return (Criteria) this;
        }

        public Criteria andGmpEqualTo(String value) {
            addCriterion("gmp =", value, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpNotEqualTo(String value) {
            addCriterion("gmp <>", value, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpGreaterThan(String value) {
            addCriterion("gmp >", value, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpGreaterThanOrEqualTo(String value) {
            addCriterion("gmp >=", value, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpLessThan(String value) {
            addCriterion("gmp <", value, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpLessThanOrEqualTo(String value) {
            addCriterion("gmp <=", value, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpLike(String value) {
            addCriterion("gmp like", value, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpNotLike(String value) {
            addCriterion("gmp not like", value, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpIn(List<String> values) {
            addCriterion("gmp in", values, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpNotIn(List<String> values) {
            addCriterion("gmp not in", values, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpBetween(String value1, String value2) {
            addCriterion("gmp between", value1, value2, "gmp");
            return (Criteria) this;
        }

        public Criteria andGmpNotBetween(String value1, String value2) {
            addCriterion("gmp not between", value1, value2, "gmp");
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