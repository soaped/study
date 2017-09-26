package com.study.yfz.dao.mybatis.domain;

import com.ipaynow.npacc.mybatis_plugin.Page;
import java.util.ArrayList;
import java.util.List;

public class OperationIdentifyPermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OperationIdentifyPermissionExample() {
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

        public Criteria andPmsnNameIsNull() {
            addCriterion("pmsn_name is null");
            return (Criteria) this;
        }

        public Criteria andPmsnNameIsNotNull() {
            addCriterion("pmsn_name is not null");
            return (Criteria) this;
        }

        public Criteria andPmsnNameEqualTo(String value) {
            addCriterion("pmsn_name =", value, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameNotEqualTo(String value) {
            addCriterion("pmsn_name <>", value, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameGreaterThan(String value) {
            addCriterion("pmsn_name >", value, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameGreaterThanOrEqualTo(String value) {
            addCriterion("pmsn_name >=", value, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameLessThan(String value) {
            addCriterion("pmsn_name <", value, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameLessThanOrEqualTo(String value) {
            addCriterion("pmsn_name <=", value, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameLike(String value) {
            addCriterion("pmsn_name like", value, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameNotLike(String value) {
            addCriterion("pmsn_name not like", value, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameIn(List<String> values) {
            addCriterion("pmsn_name in", values, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameNotIn(List<String> values) {
            addCriterion("pmsn_name not in", values, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameBetween(String value1, String value2) {
            addCriterion("pmsn_name between", value1, value2, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnNameNotBetween(String value1, String value2) {
            addCriterion("pmsn_name not between", value1, value2, "pmsnName");
            return (Criteria) this;
        }

        public Criteria andPmsnDescIsNull() {
            addCriterion("pmsn_desc is null");
            return (Criteria) this;
        }

        public Criteria andPmsnDescIsNotNull() {
            addCriterion("pmsn_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPmsnDescEqualTo(String value) {
            addCriterion("pmsn_desc =", value, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescNotEqualTo(String value) {
            addCriterion("pmsn_desc <>", value, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescGreaterThan(String value) {
            addCriterion("pmsn_desc >", value, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescGreaterThanOrEqualTo(String value) {
            addCriterion("pmsn_desc >=", value, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescLessThan(String value) {
            addCriterion("pmsn_desc <", value, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescLessThanOrEqualTo(String value) {
            addCriterion("pmsn_desc <=", value, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescLike(String value) {
            addCriterion("pmsn_desc like", value, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescNotLike(String value) {
            addCriterion("pmsn_desc not like", value, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescIn(List<String> values) {
            addCriterion("pmsn_desc in", values, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescNotIn(List<String> values) {
            addCriterion("pmsn_desc not in", values, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescBetween(String value1, String value2) {
            addCriterion("pmsn_desc between", value1, value2, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andPmsnDescNotBetween(String value1, String value2) {
            addCriterion("pmsn_desc not between", value1, value2, "pmsnDesc");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginIsNull() {
            addCriterion("ignore_login is null");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginIsNotNull() {
            addCriterion("ignore_login is not null");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginEqualTo(Integer value) {
            addCriterion("ignore_login =", value, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginNotEqualTo(Integer value) {
            addCriterion("ignore_login <>", value, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginGreaterThan(Integer value) {
            addCriterion("ignore_login >", value, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginGreaterThanOrEqualTo(Integer value) {
            addCriterion("ignore_login >=", value, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginLessThan(Integer value) {
            addCriterion("ignore_login <", value, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginLessThanOrEqualTo(Integer value) {
            addCriterion("ignore_login <=", value, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginIn(List<Integer> values) {
            addCriterion("ignore_login in", values, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginNotIn(List<Integer> values) {
            addCriterion("ignore_login not in", values, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginBetween(Integer value1, Integer value2) {
            addCriterion("ignore_login between", value1, value2, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnoreLoginNotBetween(Integer value1, Integer value2) {
            addCriterion("ignore_login not between", value1, value2, "ignoreLogin");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionIsNull() {
            addCriterion("ignore_permission is null");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionIsNotNull() {
            addCriterion("ignore_permission is not null");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionEqualTo(Integer value) {
            addCriterion("ignore_permission =", value, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionNotEqualTo(Integer value) {
            addCriterion("ignore_permission <>", value, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionGreaterThan(Integer value) {
            addCriterion("ignore_permission >", value, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("ignore_permission >=", value, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionLessThan(Integer value) {
            addCriterion("ignore_permission <", value, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionLessThanOrEqualTo(Integer value) {
            addCriterion("ignore_permission <=", value, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionIn(List<Integer> values) {
            addCriterion("ignore_permission in", values, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionNotIn(List<Integer> values) {
            addCriterion("ignore_permission not in", values, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionBetween(Integer value1, Integer value2) {
            addCriterion("ignore_permission between", value1, value2, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andIgnorePermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("ignore_permission not between", value1, value2, "ignorePermission");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelIsNull() {
            addCriterion("permission_level is null");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelIsNotNull() {
            addCriterion("permission_level is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelEqualTo(Integer value) {
            addCriterion("permission_level =", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelNotEqualTo(Integer value) {
            addCriterion("permission_level <>", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelGreaterThan(Integer value) {
            addCriterion("permission_level >", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("permission_level >=", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelLessThan(Integer value) {
            addCriterion("permission_level <", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelLessThanOrEqualTo(Integer value) {
            addCriterion("permission_level <=", value, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelIn(List<Integer> values) {
            addCriterion("permission_level in", values, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelNotIn(List<Integer> values) {
            addCriterion("permission_level not in", values, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelBetween(Integer value1, Integer value2) {
            addCriterion("permission_level between", value1, value2, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("permission_level not between", value1, value2, "permissionLevel");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIsNull() {
            addCriterion("permission_group is null");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIsNotNull() {
            addCriterion("permission_group is not null");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupEqualTo(String value) {
            addCriterion("permission_group =", value, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupNotEqualTo(String value) {
            addCriterion("permission_group <>", value, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupGreaterThan(String value) {
            addCriterion("permission_group >", value, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupGreaterThanOrEqualTo(String value) {
            addCriterion("permission_group >=", value, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupLessThan(String value) {
            addCriterion("permission_group <", value, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupLessThanOrEqualTo(String value) {
            addCriterion("permission_group <=", value, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupLike(String value) {
            addCriterion("permission_group like", value, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupNotLike(String value) {
            addCriterion("permission_group not like", value, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupIn(List<String> values) {
            addCriterion("permission_group in", values, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupNotIn(List<String> values) {
            addCriterion("permission_group not in", values, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupBetween(String value1, String value2) {
            addCriterion("permission_group between", value1, value2, "permissionGroup");
            return (Criteria) this;
        }

        public Criteria andPermissionGroupNotBetween(String value1, String value2) {
            addCriterion("permission_group not between", value1, value2, "permissionGroup");
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