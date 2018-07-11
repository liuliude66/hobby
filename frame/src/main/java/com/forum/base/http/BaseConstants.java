package com.forum.base.http;

/**
 * @author Administrator
 * @date 2018\4\3 0003
 * 描述：常量类
 */

public interface BaseConstants {

    long REQUEST_TIME_OUT_SECOND = 30;

    /*=================SharedPreference keys start==================*/
    //UUID
    String KEY_UUID = "sp_uuid";
    //UUID
    String KEY_NORMAL_DOMAIN = "key_normal_domain";
    //UUID
    String KEY_UNNORMAL_DOMAIN = "key_nunormal_domain";
    //SESSION_ID
    String KEY_SESSION_ID = "sp_session_id";
    //用户ID
    String KEY_SP_USER_ID = "sp_user_id";
    //用户名
    String KEY_SP_ACCOUNT = "sp_account";
    //账户密码
    String KEY_SP_PASSWORD = "sp_password";
    //用户余额
    String KEY_SP_BALANCE = "sp_balance";
    //是否正式账号
    String KEY_IS_VISITOR_ACCOUNT = "key_is_visitor_account";
    //完整用户信息
    String KEY_USER_INFO = "key_user_info";
    //lotteryId
    String KEY_LOTTERY_ID = "key_lottery_id";
    /*==================SharedPreference keys end=================*/

    interface LotteryId {
        int FC_3D = 18;
        int PLS = 2;
        int SH_SSL = 10;
        int XJ_SSC = 12;
        int SD_11X5 = 14;
        int SH_11X5 = 15;
        int JX_11X5 = 13;
        int GD_11X5 = 5;
        int LUCKY_28 = 17;
        int PC_DD = 7;
        int AH_QUICK3 = 1;
        int MARK_SIX = 9;
        int SF_KP10 = 8;
        int BJ_KP10 = 3;
        int SF_SSC = 6;
        int CQ_SSC = 4;
        int FOOTBALL = 100001;
        int BASKETBALL = 100002;
    }
}
