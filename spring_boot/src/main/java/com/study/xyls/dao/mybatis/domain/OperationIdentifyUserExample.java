package com.study.xyls.dao.mybatis.domain;

import com.ipaynow.npacc.mybatis_plugin.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OperationIdentifyUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OperationIdentifyUserExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andUsrNmIsNull() {
            addCriterion("usr_nm is null");
            return (Criteria) this;
        }

        public Criteria andUsrNmIsNotNull() {
            addCriterion("usr_nm is not null");
            return (Criteria) this;
        }

        public Criteria andUsrNmEqualTo(String value) {
            addCriterion("usr_nm =", value, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmNotEqualTo(String value) {
            addCriterion("usr_nm <>", value, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmGreaterThan(String value) {
            addCriterion("usr_nm >", value, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmGreaterThanOrEqualTo(String value) {
            addCriterion("usr_nm >=", value, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmLessThan(String value) {
            addCriterion("usr_nm <", value, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmLessThanOrEqualTo(String value) {
            addCriterion("usr_nm <=", value, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmLike(String value) {
            addCriterion("usr_nm like", value, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmNotLike(String value) {
            addCriterion("usr_nm not like", value, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmIn(List<String> values) {
            addCriterion("usr_nm in", values, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmNotIn(List<String> values) {
            addCriterion("usr_nm not in", values, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmBetween(String value1, String value2) {
            addCriterion("usr_nm between", value1, value2, "usrNm");
            return (Criteria) this;
        }

        public Criteria andUsrNmNotBetween(String value1, String value2) {
            addCriterion("usr_nm not between", value1, value2, "usrNm");
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

        public Criteria andUsrSexIsNull() {
            addCriterion("usr_sex is null");
            return (Criteria) this;
        }

        public Criteria andUsrSexIsNotNull() {
            addCriterion("usr_sex is not null");
            return (Criteria) this;
        }

        public Criteria andUsrSexEqualTo(Integer value) {
            addCriterion("usr_sex =", value, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexNotEqualTo(Integer value) {
            addCriterion("usr_sex <>", value, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexGreaterThan(Integer value) {
            addCriterion("usr_sex >", value, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("usr_sex >=", value, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexLessThan(Integer value) {
            addCriterion("usr_sex <", value, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexLessThanOrEqualTo(Integer value) {
            addCriterion("usr_sex <=", value, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexIn(List<Integer> values) {
            addCriterion("usr_sex in", values, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexNotIn(List<Integer> values) {
            addCriterion("usr_sex not in", values, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexBetween(Integer value1, Integer value2) {
            addCriterion("usr_sex between", value1, value2, "usrSex");
            return (Criteria) this;
        }

        public Criteria andUsrSexNotBetween(Integer value1, Integer value2) {
            addCriterion("usr_sex not between", value1, value2, "usrSex");
            return (Criteria) this;
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

        public Criteria andDeptCdIsNull() {
            addCriterion("dept_cd is null");
            return (Criteria) this;
        }

        public Criteria andDeptCdIsNotNull() {
            addCriterion("dept_cd is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCdEqualTo(Integer value) {
            addCriterion("dept_cd =", value, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdNotEqualTo(Integer value) {
            addCriterion("dept_cd <>", value, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdGreaterThan(Integer value) {
            addCriterion("dept_cd >", value, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_cd >=", value, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdLessThan(Integer value) {
            addCriterion("dept_cd <", value, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_cd <=", value, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdIn(List<Integer> values) {
            addCriterion("dept_cd in", values, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdNotIn(List<Integer> values) {
            addCriterion("dept_cd not in", values, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdBetween(Integer value1, Integer value2) {
            addCriterion("dept_cd between", value1, value2, "deptCd");
            return (Criteria) this;
        }

        public Criteria andDeptCdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_cd not between", value1, value2, "deptCd");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIsNull() {
            addCriterion("expired_date is null");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIsNotNull() {
            addCriterion("expired_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredDateEqualTo(Date value) {
            addCriterionForJDBCDate("expired_date =", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expired_date <>", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expired_date >", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expired_date >=", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateLessThan(Date value) {
            addCriterionForJDBCDate("expired_date <", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expired_date <=", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIn(List<Date> values) {
            addCriterionForJDBCDate("expired_date in", values, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expired_date not in", values, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expired_date between", value1, value2, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expired_date not between", value1, value2, "expiredDate");
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

        public Criteria andUsrMobIsNull() {
            addCriterion("usr_mob is null");
            return (Criteria) this;
        }

        public Criteria andUsrMobIsNotNull() {
            addCriterion("usr_mob is not null");
            return (Criteria) this;
        }

        public Criteria andUsrMobEqualTo(String value) {
            addCriterion("usr_mob =", value, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobNotEqualTo(String value) {
            addCriterion("usr_mob <>", value, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobGreaterThan(String value) {
            addCriterion("usr_mob >", value, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobGreaterThanOrEqualTo(String value) {
            addCriterion("usr_mob >=", value, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobLessThan(String value) {
            addCriterion("usr_mob <", value, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobLessThanOrEqualTo(String value) {
            addCriterion("usr_mob <=", value, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobLike(String value) {
            addCriterion("usr_mob like", value, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobNotLike(String value) {
            addCriterion("usr_mob not like", value, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobIn(List<String> values) {
            addCriterion("usr_mob in", values, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobNotIn(List<String> values) {
            addCriterion("usr_mob not in", values, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobBetween(String value1, String value2) {
            addCriterion("usr_mob between", value1, value2, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrMobNotBetween(String value1, String value2) {
            addCriterion("usr_mob not between", value1, value2, "usrMob");
            return (Criteria) this;
        }

        public Criteria andUsrEmailIsNull() {
            addCriterion("usr_email is null");
            return (Criteria) this;
        }

        public Criteria andUsrEmailIsNotNull() {
            addCriterion("usr_email is not null");
            return (Criteria) this;
        }

        public Criteria andUsrEmailEqualTo(String value) {
            addCriterion("usr_email =", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailNotEqualTo(String value) {
            addCriterion("usr_email <>", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailGreaterThan(String value) {
            addCriterion("usr_email >", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailGreaterThanOrEqualTo(String value) {
            addCriterion("usr_email >=", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailLessThan(String value) {
            addCriterion("usr_email <", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailLessThanOrEqualTo(String value) {
            addCriterion("usr_email <=", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailLike(String value) {
            addCriterion("usr_email like", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailNotLike(String value) {
            addCriterion("usr_email not like", value, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailIn(List<String> values) {
            addCriterion("usr_email in", values, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailNotIn(List<String> values) {
            addCriterion("usr_email not in", values, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailBetween(String value1, String value2) {
            addCriterion("usr_email between", value1, value2, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andUsrEmailNotBetween(String value1, String value2) {
            addCriterion("usr_email not between", value1, value2, "usrEmail");
            return (Criteria) this;
        }

        public Criteria andAdminIsNull() {
            addCriterion("admin is null");
            return (Criteria) this;
        }

        public Criteria andAdminIsNotNull() {
            addCriterion("admin is not null");
            return (Criteria) this;
        }

        public Criteria andAdminEqualTo(Integer value) {
            addCriterion("admin =", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotEqualTo(Integer value) {
            addCriterion("admin <>", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThan(Integer value) {
            addCriterion("admin >", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin >=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThan(Integer value) {
            addCriterion("admin <", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminLessThanOrEqualTo(Integer value) {
            addCriterion("admin <=", value, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminIn(List<Integer> values) {
            addCriterion("admin in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotIn(List<Integer> values) {
            addCriterion("admin not in", values, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminBetween(Integer value1, Integer value2) {
            addCriterion("admin between", value1, value2, "admin");
            return (Criteria) this;
        }

        public Criteria andAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("admin not between", value1, value2, "admin");
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

        public Criteria andRegTimeIsNull() {
            addCriterion("reg_time is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            addCriterion("reg_time =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            addCriterion("reg_time <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            addCriterion("reg_time >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reg_time >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            addCriterion("reg_time <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("reg_time <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Date> values) {
            addCriterion("reg_time in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            addCriterion("reg_time not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            addCriterion("reg_time between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("reg_time not between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimesIsNull() {
            addCriterion("login_times is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimesIsNotNull() {
            addCriterion("login_times is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimesEqualTo(Integer value) {
            addCriterion("login_times =", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesNotEqualTo(Integer value) {
            addCriterion("login_times <>", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesGreaterThan(Integer value) {
            addCriterion("login_times >", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_times >=", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesLessThan(Integer value) {
            addCriterion("login_times <", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesLessThanOrEqualTo(Integer value) {
            addCriterion("login_times <=", value, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesIn(List<Integer> values) {
            addCriterion("login_times in", values, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesNotIn(List<Integer> values) {
            addCriterion("login_times not in", values, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesBetween(Integer value1, Integer value2) {
            addCriterion("login_times between", value1, value2, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andLoginTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("login_times not between", value1, value2, "loginTimes");
            return (Criteria) this;
        }

        public Criteria andInitPwdIsNull() {
            addCriterion("init_pwd is null");
            return (Criteria) this;
        }

        public Criteria andInitPwdIsNotNull() {
            addCriterion("init_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andInitPwdEqualTo(String value) {
            addCriterion("init_pwd =", value, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdNotEqualTo(String value) {
            addCriterion("init_pwd <>", value, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdGreaterThan(String value) {
            addCriterion("init_pwd >", value, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdGreaterThanOrEqualTo(String value) {
            addCriterion("init_pwd >=", value, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdLessThan(String value) {
            addCriterion("init_pwd <", value, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdLessThanOrEqualTo(String value) {
            addCriterion("init_pwd <=", value, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdLike(String value) {
            addCriterion("init_pwd like", value, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdNotLike(String value) {
            addCriterion("init_pwd not like", value, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdIn(List<String> values) {
            addCriterion("init_pwd in", values, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdNotIn(List<String> values) {
            addCriterion("init_pwd not in", values, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdBetween(String value1, String value2) {
            addCriterion("init_pwd between", value1, value2, "initPwd");
            return (Criteria) this;
        }

        public Criteria andInitPwdNotBetween(String value1, String value2) {
            addCriterion("init_pwd not between", value1, value2, "initPwd");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNull() {
            addCriterion("lock_status is null");
            return (Criteria) this;
        }

        public Criteria andLockStatusIsNotNull() {
            addCriterion("lock_status is not null");
            return (Criteria) this;
        }

        public Criteria andLockStatusEqualTo(Integer value) {
            addCriterion("lock_status =", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotEqualTo(Integer value) {
            addCriterion("lock_status <>", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThan(Integer value) {
            addCriterion("lock_status >", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("lock_status >=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThan(Integer value) {
            addCriterion("lock_status <", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusLessThanOrEqualTo(Integer value) {
            addCriterion("lock_status <=", value, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusIn(List<Integer> values) {
            addCriterion("lock_status in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotIn(List<Integer> values) {
            addCriterion("lock_status not in", values, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusBetween(Integer value1, Integer value2) {
            addCriterion("lock_status between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLockStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("lock_status not between", value1, value2, "lockStatus");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeIsNull() {
            addCriterion("last_lock_time is null");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeIsNotNull() {
            addCriterion("last_lock_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeEqualTo(Date value) {
            addCriterion("last_lock_time =", value, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeNotEqualTo(Date value) {
            addCriterion("last_lock_time <>", value, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeGreaterThan(Date value) {
            addCriterion("last_lock_time >", value, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_lock_time >=", value, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeLessThan(Date value) {
            addCriterion("last_lock_time <", value, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_lock_time <=", value, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeIn(List<Date> values) {
            addCriterion("last_lock_time in", values, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeNotIn(List<Date> values) {
            addCriterion("last_lock_time not in", values, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeBetween(Date value1, Date value2) {
            addCriterion("last_lock_time between", value1, value2, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andLastLockTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_lock_time not between", value1, value2, "lastLockTime");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
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