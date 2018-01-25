package com.study.xyls.dao.mybatis.domain;

import com.xyls.mybatus_plugin.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationIdentifyLogSysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OperationIdentifyLogSysExample() {
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

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andOperationDetailIsNull() {
            addCriterion("operation_detail is null");
            return (Criteria) this;
        }

        public Criteria andOperationDetailIsNotNull() {
            addCriterion("operation_detail is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDetailEqualTo(String value) {
            addCriterion("operation_detail =", value, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailNotEqualTo(String value) {
            addCriterion("operation_detail <>", value, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailGreaterThan(String value) {
            addCriterion("operation_detail >", value, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailGreaterThanOrEqualTo(String value) {
            addCriterion("operation_detail >=", value, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailLessThan(String value) {
            addCriterion("operation_detail <", value, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailLessThanOrEqualTo(String value) {
            addCriterion("operation_detail <=", value, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailLike(String value) {
            addCriterion("operation_detail like", value, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailNotLike(String value) {
            addCriterion("operation_detail not like", value, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailIn(List<String> values) {
            addCriterion("operation_detail in", values, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailNotIn(List<String> values) {
            addCriterion("operation_detail not in", values, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailBetween(String value1, String value2) {
            addCriterion("operation_detail between", value1, value2, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andOperationDetailNotBetween(String value1, String value2) {
            addCriterion("operation_detail not between", value1, value2, "operationDetail");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNull() {
            addCriterion("module_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("module_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(Integer value) {
            addCriterion("module_id =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(Integer value) {
            addCriterion("module_id <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(Integer value) {
            addCriterion("module_id >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_id >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(Integer value) {
            addCriterion("module_id <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("module_id <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(List<Integer> values) {
            addCriterion("module_id in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(List<Integer> values) {
            addCriterion("module_id not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(Integer value1, Integer value2) {
            addCriterion("module_id between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("module_id not between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andUserCdIsNull() {
            addCriterion("user_cd is null");
            return (Criteria) this;
        }

        public Criteria andUserCdIsNotNull() {
            addCriterion("user_cd is not null");
            return (Criteria) this;
        }

        public Criteria andUserCdEqualTo(String value) {
            addCriterion("user_cd =", value, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdNotEqualTo(String value) {
            addCriterion("user_cd <>", value, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdGreaterThan(String value) {
            addCriterion("user_cd >", value, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdGreaterThanOrEqualTo(String value) {
            addCriterion("user_cd >=", value, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdLessThan(String value) {
            addCriterion("user_cd <", value, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdLessThanOrEqualTo(String value) {
            addCriterion("user_cd <=", value, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdLike(String value) {
            addCriterion("user_cd like", value, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdNotLike(String value) {
            addCriterion("user_cd not like", value, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdIn(List<String> values) {
            addCriterion("user_cd in", values, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdNotIn(List<String> values) {
            addCriterion("user_cd not in", values, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdBetween(String value1, String value2) {
            addCriterion("user_cd between", value1, value2, "userCd");
            return (Criteria) this;
        }

        public Criteria andUserCdNotBetween(String value1, String value2) {
            addCriterion("user_cd not between", value1, value2, "userCd");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andOpTimeIsNull() {
            addCriterion("op_time is null");
            return (Criteria) this;
        }

        public Criteria andOpTimeIsNotNull() {
            addCriterion("op_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpTimeEqualTo(Date value) {
            addCriterion("op_time =", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotEqualTo(Date value) {
            addCriterion("op_time <>", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeGreaterThan(Date value) {
            addCriterion("op_time >", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("op_time >=", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeLessThan(Date value) {
            addCriterion("op_time <", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeLessThanOrEqualTo(Date value) {
            addCriterion("op_time <=", value, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeIn(List<Date> values) {
            addCriterion("op_time in", values, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotIn(List<Date> values) {
            addCriterion("op_time not in", values, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeBetween(Date value1, Date value2) {
            addCriterion("op_time between", value1, value2, "opTime");
            return (Criteria) this;
        }

        public Criteria andOpTimeNotBetween(Date value1, Date value2) {
            addCriterion("op_time not between", value1, value2, "opTime");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdIsNull() {
            addCriterion("module_sub_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdIsNotNull() {
            addCriterion("module_sub_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdEqualTo(Integer value) {
            addCriterion("module_sub_id =", value, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdNotEqualTo(Integer value) {
            addCriterion("module_sub_id <>", value, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdGreaterThan(Integer value) {
            addCriterion("module_sub_id >", value, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("module_sub_id >=", value, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdLessThan(Integer value) {
            addCriterion("module_sub_id <", value, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdLessThanOrEqualTo(Integer value) {
            addCriterion("module_sub_id <=", value, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdIn(List<Integer> values) {
            addCriterion("module_sub_id in", values, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdNotIn(List<Integer> values) {
            addCriterion("module_sub_id not in", values, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdBetween(Integer value1, Integer value2) {
            addCriterion("module_sub_id between", value1, value2, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubIdNotBetween(Integer value1, Integer value2) {
            addCriterion("module_sub_id not between", value1, value2, "moduleSubId");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailIsNull() {
            addCriterion("module_sub_detail is null");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailIsNotNull() {
            addCriterion("module_sub_detail is not null");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailEqualTo(String value) {
            addCriterion("module_sub_detail =", value, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailNotEqualTo(String value) {
            addCriterion("module_sub_detail <>", value, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailGreaterThan(String value) {
            addCriterion("module_sub_detail >", value, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailGreaterThanOrEqualTo(String value) {
            addCriterion("module_sub_detail >=", value, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailLessThan(String value) {
            addCriterion("module_sub_detail <", value, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailLessThanOrEqualTo(String value) {
            addCriterion("module_sub_detail <=", value, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailLike(String value) {
            addCriterion("module_sub_detail like", value, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailNotLike(String value) {
            addCriterion("module_sub_detail not like", value, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailIn(List<String> values) {
            addCriterion("module_sub_detail in", values, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailNotIn(List<String> values) {
            addCriterion("module_sub_detail not in", values, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailBetween(String value1, String value2) {
            addCriterion("module_sub_detail between", value1, value2, "moduleSubDetail");
            return (Criteria) this;
        }

        public Criteria andModuleSubDetailNotBetween(String value1, String value2) {
            addCriterion("module_sub_detail not between", value1, value2, "moduleSubDetail");
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