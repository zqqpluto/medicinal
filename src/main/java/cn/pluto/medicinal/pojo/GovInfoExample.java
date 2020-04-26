package cn.pluto.medicinal.pojo;

import java.util.ArrayList;
import java.util.List;

public class GovInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GovInfoExample() {
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

        public Criteria andGovIdIsNull() {
            addCriterion("gov_id is null");
            return (Criteria) this;
        }

        public Criteria andGovIdIsNotNull() {
            addCriterion("gov_id is not null");
            return (Criteria) this;
        }

        public Criteria andGovIdEqualTo(Integer value) {
            addCriterion("gov_id =", value, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdNotEqualTo(Integer value) {
            addCriterion("gov_id <>", value, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdGreaterThan(Integer value) {
            addCriterion("gov_id >", value, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gov_id >=", value, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdLessThan(Integer value) {
            addCriterion("gov_id <", value, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdLessThanOrEqualTo(Integer value) {
            addCriterion("gov_id <=", value, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdIn(List<Integer> values) {
            addCriterion("gov_id in", values, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdNotIn(List<Integer> values) {
            addCriterion("gov_id not in", values, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdBetween(Integer value1, Integer value2) {
            addCriterion("gov_id between", value1, value2, "govId");
            return (Criteria) this;
        }

        public Criteria andGovIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gov_id not between", value1, value2, "govId");
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

        public Criteria andGovDepIsNull() {
            addCriterion("gov_dep is null");
            return (Criteria) this;
        }

        public Criteria andGovDepIsNotNull() {
            addCriterion("gov_dep is not null");
            return (Criteria) this;
        }

        public Criteria andGovDepEqualTo(String value) {
            addCriterion("gov_dep =", value, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepNotEqualTo(String value) {
            addCriterion("gov_dep <>", value, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepGreaterThan(String value) {
            addCriterion("gov_dep >", value, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepGreaterThanOrEqualTo(String value) {
            addCriterion("gov_dep >=", value, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepLessThan(String value) {
            addCriterion("gov_dep <", value, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepLessThanOrEqualTo(String value) {
            addCriterion("gov_dep <=", value, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepLike(String value) {
            addCriterion("gov_dep like", value, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepNotLike(String value) {
            addCriterion("gov_dep not like", value, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepIn(List<String> values) {
            addCriterion("gov_dep in", values, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepNotIn(List<String> values) {
            addCriterion("gov_dep not in", values, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepBetween(String value1, String value2) {
            addCriterion("gov_dep between", value1, value2, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovDepNotBetween(String value1, String value2) {
            addCriterion("gov_dep not between", value1, value2, "govDep");
            return (Criteria) this;
        }

        public Criteria andGovManIsNull() {
            addCriterion("gov_man is null");
            return (Criteria) this;
        }

        public Criteria andGovManIsNotNull() {
            addCriterion("gov_man is not null");
            return (Criteria) this;
        }

        public Criteria andGovManEqualTo(String value) {
            addCriterion("gov_man =", value, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManNotEqualTo(String value) {
            addCriterion("gov_man <>", value, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManGreaterThan(String value) {
            addCriterion("gov_man >", value, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManGreaterThanOrEqualTo(String value) {
            addCriterion("gov_man >=", value, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManLessThan(String value) {
            addCriterion("gov_man <", value, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManLessThanOrEqualTo(String value) {
            addCriterion("gov_man <=", value, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManLike(String value) {
            addCriterion("gov_man like", value, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManNotLike(String value) {
            addCriterion("gov_man not like", value, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManIn(List<String> values) {
            addCriterion("gov_man in", values, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManNotIn(List<String> values) {
            addCriterion("gov_man not in", values, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManBetween(String value1, String value2) {
            addCriterion("gov_man between", value1, value2, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovManNotBetween(String value1, String value2) {
            addCriterion("gov_man not between", value1, value2, "govMan");
            return (Criteria) this;
        }

        public Criteria andGovPhoIsNull() {
            addCriterion("gov_pho is null");
            return (Criteria) this;
        }

        public Criteria andGovPhoIsNotNull() {
            addCriterion("gov_pho is not null");
            return (Criteria) this;
        }

        public Criteria andGovPhoEqualTo(String value) {
            addCriterion("gov_pho =", value, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoNotEqualTo(String value) {
            addCriterion("gov_pho <>", value, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoGreaterThan(String value) {
            addCriterion("gov_pho >", value, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoGreaterThanOrEqualTo(String value) {
            addCriterion("gov_pho >=", value, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoLessThan(String value) {
            addCriterion("gov_pho <", value, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoLessThanOrEqualTo(String value) {
            addCriterion("gov_pho <=", value, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoLike(String value) {
            addCriterion("gov_pho like", value, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoNotLike(String value) {
            addCriterion("gov_pho not like", value, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoIn(List<String> values) {
            addCriterion("gov_pho in", values, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoNotIn(List<String> values) {
            addCriterion("gov_pho not in", values, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoBetween(String value1, String value2) {
            addCriterion("gov_pho between", value1, value2, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoNotBetween(String value1, String value2) {
            addCriterion("gov_pho not between", value1, value2, "govPho");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfIsNull() {
            addCriterion("gov_phone_self is null");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfIsNotNull() {
            addCriterion("gov_phone_self is not null");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfEqualTo(String value) {
            addCriterion("gov_phone_self =", value, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfNotEqualTo(String value) {
            addCriterion("gov_phone_self <>", value, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfGreaterThan(String value) {
            addCriterion("gov_phone_self >", value, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfGreaterThanOrEqualTo(String value) {
            addCriterion("gov_phone_self >=", value, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfLessThan(String value) {
            addCriterion("gov_phone_self <", value, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfLessThanOrEqualTo(String value) {
            addCriterion("gov_phone_self <=", value, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfLike(String value) {
            addCriterion("gov_phone_self like", value, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfNotLike(String value) {
            addCriterion("gov_phone_self not like", value, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfIn(List<String> values) {
            addCriterion("gov_phone_self in", values, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfNotIn(List<String> values) {
            addCriterion("gov_phone_self not in", values, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfBetween(String value1, String value2) {
            addCriterion("gov_phone_self between", value1, value2, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovPhoneSelfNotBetween(String value1, String value2) {
            addCriterion("gov_phone_self not between", value1, value2, "govPhoneSelf");
            return (Criteria) this;
        }

        public Criteria andGovAddressIsNull() {
            addCriterion("gov_address is null");
            return (Criteria) this;
        }

        public Criteria andGovAddressIsNotNull() {
            addCriterion("gov_address is not null");
            return (Criteria) this;
        }

        public Criteria andGovAddressEqualTo(String value) {
            addCriterion("gov_address =", value, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressNotEqualTo(String value) {
            addCriterion("gov_address <>", value, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressGreaterThan(String value) {
            addCriterion("gov_address >", value, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressGreaterThanOrEqualTo(String value) {
            addCriterion("gov_address >=", value, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressLessThan(String value) {
            addCriterion("gov_address <", value, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressLessThanOrEqualTo(String value) {
            addCriterion("gov_address <=", value, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressLike(String value) {
            addCriterion("gov_address like", value, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressNotLike(String value) {
            addCriterion("gov_address not like", value, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressIn(List<String> values) {
            addCriterion("gov_address in", values, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressNotIn(List<String> values) {
            addCriterion("gov_address not in", values, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressBetween(String value1, String value2) {
            addCriterion("gov_address between", value1, value2, "govAddress");
            return (Criteria) this;
        }

        public Criteria andGovAddressNotBetween(String value1, String value2) {
            addCriterion("gov_address not between", value1, value2, "govAddress");
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