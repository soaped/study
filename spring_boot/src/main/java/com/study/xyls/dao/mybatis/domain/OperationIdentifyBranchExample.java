package com.study.xyls.dao.mybatis.domain;

import com.xyls.mybatus_plugin.Page;

import java.util.ArrayList;
import java.util.List;

public class OperationIdentifyBranchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OperationIdentifyBranchExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andBrhCdIsNull() {
            addCriterion("brh_cd is null");
            return (Criteria) this;
        }

        public Criteria andBrhCdIsNotNull() {
            addCriterion("brh_cd is not null");
            return (Criteria) this;
        }

        public Criteria andBrhCdEqualTo(Integer value) {
            addCriterion("brh_cd =", value, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdNotEqualTo(Integer value) {
            addCriterion("brh_cd <>", value, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdGreaterThan(Integer value) {
            addCriterion("brh_cd >", value, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brh_cd >=", value, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdLessThan(Integer value) {
            addCriterion("brh_cd <", value, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdLessThanOrEqualTo(Integer value) {
            addCriterion("brh_cd <=", value, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdIn(List<Integer> values) {
            addCriterion("brh_cd in", values, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdNotIn(List<Integer> values) {
            addCriterion("brh_cd not in", values, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdBetween(Integer value1, Integer value2) {
            addCriterion("brh_cd between", value1, value2, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhCdNotBetween(Integer value1, Integer value2) {
            addCriterion("brh_cd not between", value1, value2, "brhCd");
            return (Criteria) this;
        }

        public Criteria andBrhNmIsNull() {
            addCriterion("brh_nm is null");
            return (Criteria) this;
        }

        public Criteria andBrhNmIsNotNull() {
            addCriterion("brh_nm is not null");
            return (Criteria) this;
        }

        public Criteria andBrhNmEqualTo(String value) {
            addCriterion("brh_nm =", value, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmNotEqualTo(String value) {
            addCriterion("brh_nm <>", value, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmGreaterThan(String value) {
            addCriterion("brh_nm >", value, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmGreaterThanOrEqualTo(String value) {
            addCriterion("brh_nm >=", value, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmLessThan(String value) {
            addCriterion("brh_nm <", value, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmLessThanOrEqualTo(String value) {
            addCriterion("brh_nm <=", value, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmLike(String value) {
            addCriterion("brh_nm like", value, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmNotLike(String value) {
            addCriterion("brh_nm not like", value, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmIn(List<String> values) {
            addCriterion("brh_nm in", values, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmNotIn(List<String> values) {
            addCriterion("brh_nm not in", values, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmBetween(String value1, String value2) {
            addCriterion("brh_nm between", value1, value2, "brhNm");
            return (Criteria) this;
        }

        public Criteria andBrhNmNotBetween(String value1, String value2) {
            addCriterion("brh_nm not between", value1, value2, "brhNm");
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