package com.study.xyls.dao.mybatis.domain;

import com.ipaynow.npacc.mybatis_plugin.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationIdentifyLogModifyPassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OperationIdentifyLogModifyPassExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsrCdIsNull() {
            addCriterion("usr_cd is null");
            return (Criteria) this;
        }

        public Criteria andUsrCdIsNotNull() {
            addCriterion("usr_cd is not null");
            return (Criteria) this;
        }

        public Criteria andUsrCdEqualTo(String value) {
            addCriterion("usr_cd =", value, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdNotEqualTo(String value) {
            addCriterion("usr_cd <>", value, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdGreaterThan(String value) {
            addCriterion("usr_cd >", value, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdGreaterThanOrEqualTo(String value) {
            addCriterion("usr_cd >=", value, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdLessThan(String value) {
            addCriterion("usr_cd <", value, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdLessThanOrEqualTo(String value) {
            addCriterion("usr_cd <=", value, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdLike(String value) {
            addCriterion("usr_cd like", value, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdNotLike(String value) {
            addCriterion("usr_cd not like", value, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdIn(List<String> values) {
            addCriterion("usr_cd in", values, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdNotIn(List<String> values) {
            addCriterion("usr_cd not in", values, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdBetween(String value1, String value2) {
            addCriterion("usr_cd between", value1, value2, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrCdNotBetween(String value1, String value2) {
            addCriterion("usr_cd not between", value1, value2, "usrCd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdIsNull() {
            addCriterion("usr_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUsrPwdIsNotNull() {
            addCriterion("usr_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUsrPwdEqualTo(String value) {
            addCriterion("usr_pwd =", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdNotEqualTo(String value) {
            addCriterion("usr_pwd <>", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdGreaterThan(String value) {
            addCriterion("usr_pwd >", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdGreaterThanOrEqualTo(String value) {
            addCriterion("usr_pwd >=", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdLessThan(String value) {
            addCriterion("usr_pwd <", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdLessThanOrEqualTo(String value) {
            addCriterion("usr_pwd <=", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdLike(String value) {
            addCriterion("usr_pwd like", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdNotLike(String value) {
            addCriterion("usr_pwd not like", value, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdIn(List<String> values) {
            addCriterion("usr_pwd in", values, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdNotIn(List<String> values) {
            addCriterion("usr_pwd not in", values, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdBetween(String value1, String value2) {
            addCriterion("usr_pwd between", value1, value2, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andUsrPwdNotBetween(String value1, String value2) {
            addCriterion("usr_pwd not between", value1, value2, "usrPwd");
            return (Criteria) this;
        }

        public Criteria andLstMdDtIsNull() {
            addCriterion("lst_md_dt is null");
            return (Criteria) this;
        }

        public Criteria andLstMdDtIsNotNull() {
            addCriterion("lst_md_dt is not null");
            return (Criteria) this;
        }

        public Criteria andLstMdDtEqualTo(Date value) {
            addCriterion("lst_md_dt =", value, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtNotEqualTo(Date value) {
            addCriterion("lst_md_dt <>", value, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtGreaterThan(Date value) {
            addCriterion("lst_md_dt >", value, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtGreaterThanOrEqualTo(Date value) {
            addCriterion("lst_md_dt >=", value, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtLessThan(Date value) {
            addCriterion("lst_md_dt <", value, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtLessThanOrEqualTo(Date value) {
            addCriterion("lst_md_dt <=", value, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtIn(List<Date> values) {
            addCriterion("lst_md_dt in", values, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtNotIn(List<Date> values) {
            addCriterion("lst_md_dt not in", values, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtBetween(Date value1, Date value2) {
            addCriterion("lst_md_dt between", value1, value2, "lstMdDt");
            return (Criteria) this;
        }

        public Criteria andLstMdDtNotBetween(Date value1, Date value2) {
            addCriterion("lst_md_dt not between", value1, value2, "lstMdDt");
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