package cn.wolfcode.accountbook.util;
import java.math.BigDecimal;

public class Constants {
    /**
     * 手机号长度
     */
    public static final int LENGTH_PHONE = 11;

    /**
     * 密码最小长度
     */
    public static final int MIN_LENGTH_PASSWORD = 6;
    /**
     * 密码最小长度
     */
    public static final int MAX_LENGTH_PASSWORD = 16;
    /**
     * 验证码长度
     */
    public static final int LENGTH_VERIFYCODE = 4;

    /**
     * 验证码有效时间：秒
     */
    public static final int VERIFYCODE_VALID_SECOND = 300;
    /**
     * 验证码发送间隔时间：秒
     */
    public static final long VERIFYCODE_SEND_INTERVAL_SECOND = 10;

    //零
    public static final BigDecimal ZERO = new BigDecimal("0.0000");

    //显示精度
    public static final int SCALE_SHOW = 2;

    //保存精度
    public static final int SCALE_STORE = 4;

    //计算精度
    public static final int SCALE_CAL = 8;

    //初始信用额度
    public static final BigDecimal BORROW_LIMIT = new BigDecimal("5000.0000");

    //最小借款金额
    public static final BigDecimal BORROW_MIN_AMOUNT = new BigDecimal("1000.00");

    //最小利率
    public static final BigDecimal BORROW_MIN_RATE = new BigDecimal("5.00");

    //最大利率
    public static final BigDecimal BORROW_MAX_RATE = new BigDecimal("20.00");

    //最小投标限制
    public static final BigDecimal BORROW_MIN_BID_AMOUNT = new BigDecimal("50.00");


    // ---------------------借款状态---------------------------
    public final static int BIDREQUEST_STATE_APPLY = 11;//待申请中
    public final static int BIDREQUEST_STATE_PUBLISH_PENDING = 0;   // 待发布
    public final static int BIDREQUEST_STATE_BIDDING = 1;           // 招标中,同债权标的转让中
    public final static int BIDREQUEST_STATE_UNDO = 2;              // 已撤销,同债权标的已撤销
    public final static int BIDREQUEST_STATE_BIDDING_OVERDUE = 3;   // 流标
    public final static int BIDREQUEST_STATE_APPROVE_PENDING_1 = 4; // 满标1审
    public final static int BIDREQUEST_STATE_APPROVE_PENDING_2 = 5; // 满标2审
    public final static int BIDREQUEST_STATE_REJECTED = 6;          // 满标审核被拒绝
    public final static int BIDREQUEST_STATE_PAYING_BACK = 7;       // 还款中
    public final static int BIDREQUEST_STATE_COMPLETE_PAY_BACK = 8; // 已还清,同债权标的已认购
    public final static int BIDREQUEST_STATE_PAY_BACK_OVERDUE = 9;  // 逾期
    public final static int BIDREQUEST_STATE_PUBLISH_REFUSE = 10;   // 发标审核拒绝状态

    // --------------------还款类型---------------------------

    // 按月分期还款(等额本息)
    public final static int RETURN_TYPE_MONTH_INTEREST_PRINCIPAL = 0;

    // 按月到期还款(每月还利息,到期还本息)
    public final static int RETURN_TYPE_MONTH_INTEREST = 1;
    // --------------借款类型------------------------------
    //普通信用标
    public final static int BIDREQUEST_TYPE_NORMAL = 0;
    //债权标
    public final static int BIDREQUEST_TYPE_TRANSFER = 1;

    /** =============================账户流水类型================================ */

    // 资金流水类别：线下充值
    // 可用余额增加
    public final static int ACCOUNT_ACTIONTYPE_RECHARGE_OFFLINE = 0;

    // 资金流水类别：提现成功
    // 冻结金额减少
    public final static int ACCOUNT_ACTIONTYPE_WITHDRAW = 1;

    // 资金流水类别：成功借款
    // 可用余额增加
    public final static int ACCOUNT_ACTIONTYPE_BIDREQUEST_SUCCESSFUL = 2;

    // 资金流水类别：成功投标
    // 冻结金额减少
    public final static int ACCOUNT_ACTIONTYPE_BID_SUCCESSFUL = 3;

    // 资金流水类别：还款
    // 可用余额减少
    public final static int ACCOUNT_ACTIONTYPE_RETURN_MONEY = 4;

    // 资金流水类别：回款
    // 可用余额增加
    public final static int ACCOUNT_ACTIONTYPE_CALLBACK_MONEY = 5;

    // 资金流水类别：支付平台管理费
    // 可用余额减少
    public final static int ACCOUNT_ACTIONTYPE_CHARGE = 6;

    // 资金流水类别：利息管理费
    // 可用余额减少
    public final static int ACCOUNT_ACTIONTYPE_INTEREST_SHARE = 7;

    // 资金流水类别：提现手续费
    // 冻结金额减少
    public final static int ACCOUNT_ACTIONTYPE_WITHDRAW_MANAGE_CHARGE = 8;

    // 资金流水类别：充值手续费
    // 可用余额减少
    public final static int ACCOUNT_ACTIONTYPE_RECHARGE_CHARGE = 9;

    // 资金流水类别：投标冻结金额
    // 冻结金额增加 可用余额减少
    public final static int ACCOUNT_ACTIONTYPE_BID_FREEZED = 10;

    // 资金流水类别：取消投标冻结金额
    // 标审核失败
    // 冻结金额减少
    // 可用余额增加
    public final static int ACCOUNT_ACTIONTYPE_BID_UNFREEZED = 11;

    // 资金流水类别：提现申请冻结金额
    // 冻结金额增加
    // 可用余额减少
    public final static int ACCOUNT_ACTIONTYPE_WITHDRAW_FREEZED = 12;

    // 资金流水类别:提现申请失败取消冻结金额
    // 冻结金额减少
    // 可用余额增加
    public final static int ACCOUNT_ACTIONTYPE_WITHDRAW_UNFREEZED = 13;
    //成功转让流水
    public final static int ACCOUNT_ACTIONTYPE_TRANSFER_SUCCESS = 14;

    public final static int ACCOUNT_ACTIONTYPE_SUBSCRIBE_SUCCESS = 15;

    //线上充值
    public final static int ACCOUNT_ACTIONTYPE_RECHARGE_ONLINE = 16;

    /** =========还款状态=============== */

    // 正常待还
    public final static int PAYMENT_STATE_NORMAL = 0;

    // 已还
    public final static int PAYMENT_STATE_DONE = 1;

    // 逾期
    public final static int PAYMENT_STATE_OVERDUE = 2;


    /** ============系统账户流水类型============= */

    // 系统账户收到账户管理费（借款管理费）
    public final static int SYSTEM_ACCOUNT_ACTIONTYPE_MANAGE_CHARGE = 1;

    // 系统账户收到利息管理费
    public final static int SYSTEM_ACCOUNT_ACTIONTYPE_INTREST_MANAGE_CHARGE = 2;

    // 系统账户收到提现手续费
    public final static int SYSTEM_ACCOUNT_ACTIONTYPE_WITHDRAW_MANAGE_CHARGE = 3;

}
