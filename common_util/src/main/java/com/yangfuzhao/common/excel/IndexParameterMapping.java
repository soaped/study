package com.yangfuzhao.common.excel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * excel 表格与参数的映射关系
 * Created with IntelliJ IDEA.
 * User: ipaynow0929
 * Date: 16-10-31
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class IndexParameterMapping {


    @AllArgsConstructor
    @NoArgsConstructor
    public enum WzMerchantNature{
        STATE_OWNED_ENTERPRISES("国有企业"),
        FOREIGN_FUNDED_ENTERPRISES("三资企业"),
        PRIVATE_ENTERPRISE("私营企业"),
        COLLECTIVE_ENTERPRISE("集体企业");
        @Getter
        private String name;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public enum WzBatchRegisterExcel{
        MCH_ID(0,"聚合商户号"),
        AGENCY(1,"代理机构号"),
        EMAIL(2,"登录邮箱"),
        MERCHANT_NAME(3,"商户名称"),
        MERCHANT_ALIS(4,"商户简称"),
        MERCHANT_AREA(5,"地区码"),
        BANK_NAME(6,"开户行"),
        REVACT_BANK_NO(7,"开户联行号"),
        BANK_ACCOUT_NAME(8,"结算账号名"),
        BANK_ACCOUT(9,"银行账号"),
        WX_ACCOUNT(10,"商户微信号"),
        SERVICE_PHONE(11,"客服电话"),
        CONTACT(12,"联系人"),
        CONTACT_PHONE(13,"联系电话"),
        CONTACT_EMAIL(14,"联系人邮箱"),
        BUSINESS(15,"经营类目"),
        MERCHANT_NATURE(16,"商户性质"),
        OPEN_YEAR(17,"经营年限"),
        CONTRACT_NO(18,"合同编号"),
        CONTRACT_LICENCE(19,"营业执照"),
        BUSINESS_START_DATE(20,"营业执照起始时间"),
        BUSINESS_END_DATE(21,"营业执照结束时间"),
        WX_COST_RATE(22,"商户费率"),
        COMPANY_FLAG(23,"账号性质"),
        CYCLE(24,"结算方式"),
        SELECTED(25,"是否生效或者切户"),
        WZ_SUB_ID(26,"微众返回商户号"),
        MESSAGE(27,"返回消息"),
        ;
        @Getter
        private int cellNum;
        @Getter
        private String value;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    public enum BatchCreateBranchExcel{
        CNAPS_CODE(0,"联行号"),
        CLEAR_BANK_CNAPS_CODE(1,"清算联行号"),
        SUBBRANCH_NAME(2,"支行名"),
        BANK_CNAPS_CODE(3,"总行联行号"),
        RREATE_BRANCH_DETAIL(4,"返回消息"),
        ;
        @Getter
        private int cellNum;
        @Getter
        private String value;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public enum CmbcBatchRegisterExcel{
        MCH_SUB_ID(1,"子商户号"),
        EMAIL(2,"商户邮箱"),
        MERCHANT_SUB_NAME(3,"子商户全称"),
        MERCHANT_SUB_SHORT_NAME(4,"子商户号简称"),
        LIC_NO(5,"营业执照号"),
        ADDRESS(6,"商户地址"),
        LAW_MAN(7,"法人"),
        LAW_CERT(8,"法人身份证"),
        CONTCR_NM(9,"联系人姓名"),
        CONTCR_TEL(10,"联系人手机号"),
        CONTCR_EML(11, "联系人邮箱"),
        CONTCR_MOBILE(12,"联系人电话"),
        KF_TEL(13,"客服电话"),
        ORG_CODE(14,"组织机构号"),
        ZFB_CATEGORY(15,"支付宝经营类目"),
        WX_CATEGORY(16,"微信经营类目"),
        PROVINCE_CODE(17,"省地区码"),
        CITY_CODE(18,"市地区码"),
        DISTRICT_CODE(19,"区县地区码"),
        ACC_NO(20, "收款人账户号"),
        ACC_NAME(21,"收款人账号名"),
        BANK_TYPE(22,"账号联行号"),
        BANK_NAME(23, "开户行名称"),
        T1_DRAW_FEE(24,"T1单笔提现手续费"),
        T1_TRADE_RATE(25,"T1交易手续费扣率"),
        NOW_SUB_ID(26,"现在支付子号"),
        MERCHANT_CODE(27,"民生商户号"),
        CHANNEL_MERCHANT_CODE(28,"民生渠道商户号"),
        MESSAGE_SUB(29,"子商户入驻消息"),
        MESSAGE(27,"签约民生消息"),
        ;
        @Getter
        private int cellNum;
        @Getter
        private String value;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    public enum BatchRegisterType{
        CITIC_ZFB_TYPE("0001"),//中信支付宝
        CITIC_WX_TYPE("0002"),//中信微信
        CMBC_ZFB_TPTE("cmbc_zfb_sub"),//民生子商户支付宝
        CMBC_WX_TPTE("cmbc_wx_sub"),//民生子商户微信
        CREATE_APP("app"),//创建应用
        MERCHANT_REGISTER("register"),//商户入驻
        CREATE_BRANCH("branch"),//创建联行号
        WZ_WX_TYPE("wz_wx"),//微众银行微信渠道
        ;
        @Getter
        private String type;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    public enum CiticBatchRegisterExcel{
        MCH_ID(0,"商户号"),
        MERCHT_BELG_CHNL_ID(1, "商户归属渠道编号"),
        EMAIL(2, "登录邮箱"),
        MERCHT_FULL_NM(3, "商户全称"),
        MERCHT_SHT_NM(4, "商户简称"),
        MCHNT_PROPERTY(5, "商户性质"),
        ARTIF(6, "法人姓名"),
        ARTIF_ID(7, "法人身份证号"),
        BUSI_LIC_NO(8,"营业执照号"),
        CUST_SERV_TEL(9, "客服电话"),
        CONTCR_NM(10,"联系人姓名"),
        CONTCR_TEL(11,"联系人手机号"),
        CONTCR_MOBL_NUM(12,"联系人电话"),
        CONTCR_EML(13, "邮箱"),
        OPR_CLS(14, "经营类目"),
        MERCHT_MEMO(15,"商户备注"),
        PROV(16, "联系人所在省"),
        URBN(17, "联系人所在市"),
        DISTRICT(18, "联系人所在区县"),
        DTL_ADDR(19, "详细地址"),
        ACCT_NM(20, "结算户名"),
        OPN_BNK(21, "开户行名"),
        IS_NT_CITIC(22,"是否中信"),
        ACCT_TYP(23, "账号类型"),
        PAY_IBANK_NUM(24,"支付联行号"),
        ACCT_NUM(25, "结算账户号"),
        PAY_TYP_FEE_RATE(26, "支付类型费率"),
        ROUTER_TYPE_ID(27, "路由类型"),
        SELECTED(28,"是否生效或者切户"),
        MESSAGE(29 ,"签约消息");
        @Getter
        private int cellNum;
        @Getter
        private String value;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    public enum CreateAppExcel{
        /**创建应用*/
        MERCHANT_ID(0,"商户号"),
        APP_DEVICE_ID(1,"设备ID"),
        APP_NAME(2,"应用名称"),
        APP_URL(3,"URL"),
        APP_INDUSTRY_ID(4,"行业"),
        APP_DESCRIPTION(5,"应用描述"),
        APP_ENABLE(6,"是否启用"),
        APP_ID_KEY(7,"应用id/key");

        @Getter
        private int cellNum;
        @Getter
        private String value;

    }

    @AllArgsConstructor
    public enum RegisterExcel{
        MAX_FILE_NAME_LENGTH(28,"文件名长度不能超过28"),
        /**商户基本信息*/
        USERNAME(0,"登录名称(邮箱)"),
        MERCHANT_NAME(1,"商户名称"),
        MERCHANT_SHORT_NAME(2,"商户简称"),
        MERCHANT_ADDRESS(3,"商户地址"),
        MERCHANT_TYPE(4,"类型(1个人/2企业)"),
        MCH_STATUS(5,"商户激活状态"),
        REAL_STATUS(6,"实名认证状态"),
        LINKMAN (7,"联系人姓名"),
        LINKMAN_PHONE(8,"联系人电话"),
        LINKMAN_EMAIL(9,"联系人邮箱"),
        KF_TEL(10,"客服电话"),
        AREA_CODE(11,"地区码"),
        LAWMAN(12,"法人姓名"),
        LAW_CERT(13,"法人身份证"),
        LAW_CERT_VALIDITY(14,"法人身份证有效期"),
        LAW_PHONE(15,"法人电话"),
        COMPANY_FIX_TEL(16,"公司固定电话"),
        MAIN_BUSINESS(17,"主营业务"),
        LIC_NO(18,"营业执照"),
        TAX_NO(19,"税务登记"),
        OPEN_NO(20,"开户许可证"),
        ORG_NO(21,"组织结构代码"),
        ORG_ID(22,"机构号"),
        WEB_SITE(23,"网站地址"),

        /**商户卡信息*/
        BRANCH_NO(24,"卡联行号"),
        SUB_BRANCH_NAME(25,"支行名称"),
        CARD_NAME(26,"银行卡账户名"),
        CARD_NO(27,"银行卡号"),
        CARD_PHONE (28,"银行卡预留电话"),
        CARD_CITY(29,"卡地区码"),
        MERRCHAN_ERROR(32,"错误信息"),
        ;

        @Getter
        private int cellNum;
        @Getter
        private String value;

    }

    public enum excelNum{
        //商户入驻
        IPAYNOW_MCHID(0,"聚合商户号"),
        YES_OR_NO(1,"是否执行(1是0否)"),

        BRANCH_NO(2,"卡联行号"),
        SUB_BRANCH_NAME(3,"支行名称"),
        CARD_NAME(4,"银行卡账户名"),
        CARD_NO(5,"银行卡号"),
        CARD_PHONE (6,"银行卡"),
        CARD_CITY(7,"卡地区码"),
        USERNAME(8,"登录名称(邮箱)"),
        MERCHANT_NAME(9,"商户名称"),
        MERCHANT_SHORT_NAME(10,"商户简称"),
        MERCHANT_ADDRESS(11,"商户地址"),
        MERCHANT_TYPE(12,"类型(1个人/2企业)"),
        REAL_STATUS(13,"实名认证状态"),
        LINKMAN (14,"负责人姓名"),
        LINKMAN_PHONE(15,"负责人电话"),
        LINKMAN_EMAIL(16,"负责人邮箱"),
        KF_TEL(17,"客服电话"),
        AREA_CODE(18,"地区码"),
        LAWMAN(19,"法人姓名"),
        LAW_CERT(20,"法人身份证"),
        LAW_CERT_VALIDITY(21,"法人身份证有效期"),
        LAW_PHONE(22,"法人电话"),
        COMPANY_FIX_TEL(23,"公司固定电话"),
        MAIN_BUSINESS(24,"主营业务"),
        LIC_NO(25,"营业执照"),
        TAX_NO(26,"税务登记"),
        OPEN_NO(27,"开户许可证"),
        ORG_NO(28,"组织结构代码"),
        ORG_ID(29,"机构号"),
        PAY_PASSWD(30,"支付密码"),
        WEB_SITE(31,"网站地址"),
        MERRCHAN_ERROR(32,"错误信息"),

        //签约支付宝对应列
        ZFB_CHANNEL_OF_MERCHANT(33,"商户归属渠道"),
        ZFB_CATERGORY(34,"支付宝经营类"),
        ZFB_IS_CITIC(35,"是否中信银行"),
        ZFB_CITIC_BRANCH_NO(36,"中信银行网点号"),
        ZFB_PAY_TYPE_FEE_RATE(37,"支付宝费率"),
        ZFB_MERCHANT_MEMO(38,"支付宝备注"),
        ZFB_ERROR(39,"签约支付宝错误信息"),

        //创建应用
        APP_DEVICE_ID(40,"设备ID"),
        APP_NAME(41,"应用名称"),
        APP_URL(42,"URL"),
        APP_INDUSTRY_ID(43,"行业"),
        APP_DESCRIPTION(44,"应用描述"),
        APP_ENABLE(45,"是否启用"),
        APP_ERROR(46,"创建应用错误信息"),

        //中信签约微信
        WX_CHANNEL_OF_MERCHANT(47,"商户归属渠道"),
        WX_CATERGORY(48,"微信经营类"),
        WX_IS_CITIC(49,"是否中信银行"),
        WX_CITIC_BRANCH_NO(50,"中信银行网点号"),
        WX_PAY_TYPE_FEE_RATE(51,"中信微信费率"),
        WX_MERCHANT_MEMO(52,"微信备注"),
        WX_ERROR(53,"签约微信错误信息"),

        //批量添加联行号
        BATCH_BRANCH(54,"联行号"),
        BACTH_SUB_BRANCH_NAME(55,"支行名称"),
        CLEAR_BANK_CNAPS_CODE(56,"清除码"),
        ADD_BRANCH_ERROR(57,"添加联行号错误信息"),
        MAX_RATE(99,"0.08"),
        ZFB_MIN_RATE(0,"0.002"),
        WX_MIN_RATE(0,"0.003"),
        MAX_FILE_NAME_LENGTH(28,"文件名长度不能超过28");

        private excelNum(int cellNum, String value) {
            this.cellNum = cellNum;
            this.value = value;
        }

        @Getter
        private int cellNum;
        @Getter
        private String value;
    }

    public enum Device {
        PHONE("01","手机"),
        PC("02","电脑"),
        PAD("03","平板"),
        SCANED_PAY("05","被扫支付"),
        PHONE_WEB_PAGE("06","手机网页"),
        PUBLIC_NO("0600","公众号"),
        H5_WEB_PAGE("0601","H5网页"),
        PAYEE_CARD("0602","收款卡牌"),
        NEW_STAND_CODE("0603","新立码"),
        PUBLIC_NO_WEB_PAGE("0604","公众号网页"),
        IPAYNOW_CARD("0608","跨境支付"),
        NEW_CHECKSTAND("07","现在收银台"),
        SCAN_PAY("08","主扫支付"),
        NOOPSYCHE_POS("09","智能POS"),
        ERP_PLATFORM("10","ERP平台"),
        POS_MACHINE("11","POS机"),
        TL("TL","所有设备");

        public static Device getExcelNumByDeviceId(String deviceId){
            for(Device  device : Device.values()){
               if(deviceId.equals(device.getDeviceId())){
                  return device;
               }
            }
            return null;
        }


        private Device(String deviceId, String appName) {
            this.deviceId = deviceId;
            this.appName = appName;
        }

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        private String deviceId;

        private String appName;
    }
}
