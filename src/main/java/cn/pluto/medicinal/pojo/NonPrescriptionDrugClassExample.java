package cn.pluto.medicinal.pojo;

import java.util.ArrayList;
import java.util.List;

public class NonPrescriptionDrugClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NonPrescriptionDrugClassExample() {
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

        public Criteria andNdcclassIsNull() {
            addCriterion("ndcClass is null");
            return (Criteria) this;
        }

        public Criteria andNdcclassIsNotNull() {
            addCriterion("ndcClass is not null");
            return (Criteria) this;
        }

        public Criteria andNdcclassEqualTo(String value) {
            addCriterion("ndcClass =", value, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassNotEqualTo(String value) {
            addCriterion("ndcClass <>", value, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassGreaterThan(String value) {
            addCriterion("ndcClass >", value, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassGreaterThanOrEqualTo(String value) {
            addCriterion("ndcClass >=", value, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassLessThan(String value) {
            addCriterion("ndcClass <", value, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassLessThanOrEqualTo(String value) {
            addCriterion("ndcClass <=", value, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassLike(String value) {
            addCriterion("ndcClass like", value, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassNotLike(String value) {
            addCriterion("ndcClass not like", value, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassIn(List<String> values) {
            addCriterion("ndcClass in", values, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassNotIn(List<String> values) {
            addCriterion("ndcClass not in", values, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassBetween(String value1, String value2) {
            addCriterion("ndcClass between", value1, value2, "ndcclass");
            return (Criteria) this;
        }

        public Criteria andNdcclassNotBetween(String value1, String value2) {
            addCriterion("ndcClass not between", value1, value2, "ndcclass");
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