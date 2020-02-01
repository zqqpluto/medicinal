package cn.pluto.medicinal.pojo;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeServiceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeServiceExample() {
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

        public Criteria andKsidIsNull() {
            addCriterion("ksId is null");
            return (Criteria) this;
        }

        public Criteria andKsidIsNotNull() {
            addCriterion("ksId is not null");
            return (Criteria) this;
        }

        public Criteria andKsidEqualTo(Integer value) {
            addCriterion("ksId =", value, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidNotEqualTo(Integer value) {
            addCriterion("ksId <>", value, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidGreaterThan(Integer value) {
            addCriterion("ksId >", value, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ksId >=", value, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidLessThan(Integer value) {
            addCriterion("ksId <", value, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidLessThanOrEqualTo(Integer value) {
            addCriterion("ksId <=", value, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidIn(List<Integer> values) {
            addCriterion("ksId in", values, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidNotIn(List<Integer> values) {
            addCriterion("ksId not in", values, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidBetween(Integer value1, Integer value2) {
            addCriterion("ksId between", value1, value2, "ksid");
            return (Criteria) this;
        }

        public Criteria andKsidNotBetween(Integer value1, Integer value2) {
            addCriterion("ksId not between", value1, value2, "ksid");
            return (Criteria) this;
        }

        public Criteria andKcidIsNull() {
            addCriterion("kcId is null");
            return (Criteria) this;
        }

        public Criteria andKcidIsNotNull() {
            addCriterion("kcId is not null");
            return (Criteria) this;
        }

        public Criteria andKcidEqualTo(Integer value) {
            addCriterion("kcId =", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidNotEqualTo(Integer value) {
            addCriterion("kcId <>", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidGreaterThan(Integer value) {
            addCriterion("kcId >", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("kcId >=", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidLessThan(Integer value) {
            addCriterion("kcId <", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidLessThanOrEqualTo(Integer value) {
            addCriterion("kcId <=", value, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidIn(List<Integer> values) {
            addCriterion("kcId in", values, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidNotIn(List<Integer> values) {
            addCriterion("kcId not in", values, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidBetween(Integer value1, Integer value2) {
            addCriterion("kcId between", value1, value2, "kcid");
            return (Criteria) this;
        }

        public Criteria andKcidNotBetween(Integer value1, Integer value2) {
            addCriterion("kcId not between", value1, value2, "kcid");
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

        public Criteria andKspathIsNull() {
            addCriterion("ksPath is null");
            return (Criteria) this;
        }

        public Criteria andKspathIsNotNull() {
            addCriterion("ksPath is not null");
            return (Criteria) this;
        }

        public Criteria andKspathEqualTo(String value) {
            addCriterion("ksPath =", value, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathNotEqualTo(String value) {
            addCriterion("ksPath <>", value, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathGreaterThan(String value) {
            addCriterion("ksPath >", value, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathGreaterThanOrEqualTo(String value) {
            addCriterion("ksPath >=", value, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathLessThan(String value) {
            addCriterion("ksPath <", value, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathLessThanOrEqualTo(String value) {
            addCriterion("ksPath <=", value, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathLike(String value) {
            addCriterion("ksPath like", value, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathNotLike(String value) {
            addCriterion("ksPath not like", value, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathIn(List<String> values) {
            addCriterion("ksPath in", values, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathNotIn(List<String> values) {
            addCriterion("ksPath not in", values, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathBetween(String value1, String value2) {
            addCriterion("ksPath between", value1, value2, "kspath");
            return (Criteria) this;
        }

        public Criteria andKspathNotBetween(String value1, String value2) {
            addCriterion("ksPath not between", value1, value2, "kspath");
            return (Criteria) this;
        }

        public Criteria andKstitleIsNull() {
            addCriterion("ksTitle is null");
            return (Criteria) this;
        }

        public Criteria andKstitleIsNotNull() {
            addCriterion("ksTitle is not null");
            return (Criteria) this;
        }

        public Criteria andKstitleEqualTo(String value) {
            addCriterion("ksTitle =", value, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleNotEqualTo(String value) {
            addCriterion("ksTitle <>", value, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleGreaterThan(String value) {
            addCriterion("ksTitle >", value, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleGreaterThanOrEqualTo(String value) {
            addCriterion("ksTitle >=", value, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleLessThan(String value) {
            addCriterion("ksTitle <", value, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleLessThanOrEqualTo(String value) {
            addCriterion("ksTitle <=", value, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleLike(String value) {
            addCriterion("ksTitle like", value, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleNotLike(String value) {
            addCriterion("ksTitle not like", value, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleIn(List<String> values) {
            addCriterion("ksTitle in", values, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleNotIn(List<String> values) {
            addCriterion("ksTitle not in", values, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleBetween(String value1, String value2) {
            addCriterion("ksTitle between", value1, value2, "kstitle");
            return (Criteria) this;
        }

        public Criteria andKstitleNotBetween(String value1, String value2) {
            addCriterion("ksTitle not between", value1, value2, "kstitle");
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