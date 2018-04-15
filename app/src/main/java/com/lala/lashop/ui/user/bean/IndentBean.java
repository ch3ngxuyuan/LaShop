package com.lala.lashop.ui.user.bean;

import java.util.List;

/**
 * Created by JX on 2018/3/26.
 */

public class IndentBean {

    /**
     * orid : 0
     * or_count_noping : 0
     * or_count_all : 0
     * or_count_noshou : 0
     * pagination : [{"a_id":"","aadm":"","aadmname":"","actid":"","adate":"","addr":"","admin_id":"10030","c_id":"","clds":[],"color":"卡其色","comment_body":"","distribution":"","dmark":"","enddate":"","fa_date":"","groupid":"20140808080808","gui":"均码","haveping":"0","id":"283","isFanli":0,"islimit":"","isorder":"","isscore":"0","jmark":"","lang_id":"","limit":"","m_date":"2018-04-15 11:00:23","name":"","nowcount":"993","openid":"","or_date":"2018-04-15 11:00:23","or_flag":"0","order_id":"180413202627135","payStatus":"10042","pay_pwd":"","payway":"","phone":"","prepay_id":"","profit":"","sa":null,"selected":true,"shou_date":"","smark":"","sp":null,"sp_count":"9","sp_dealer":"","sp_grounding":"1","sp_id":"1597","sp_postage":"0","sp_price":"180.00","sp_simg":"/upload/20170210/170240902.jpg","sp_title":"Diller情侣杯","sp_total":"1620.00","tmark":"","twuliu":"","twuliuid":"","u_account":"15777777777","u_delete":"0","u_id":"","u_phone":"","uadm":"","uadmname":"","udate":"","vir":"","virid":"","wuliu":"","wuliuid":"","wxpay":"","youfei":"","youmo":"0","yunfei":"0.00"},{"a_id":"","aadm":"","aadmname":"","actid":"","adate":"","addr":"","admin_id":"10030","c_id":"","clds":[],"color":"","comment_body":"","distribution":"","dmark":"","enddate":"","fa_date":"","groupid":"20140808080808","gui":"","haveping":"0","id":"284","isFanli":0,"islimit":"","isorder":"","isscore":"0","jmark":"","lang_id":"","limit":"","m_date":"","name":"","nowcount":"998","openid":"","or_date":"2018-04-13 20:41:46","or_flag":"0","order_id":"180413204146595","payStatus":"10042","pay_pwd":"","payway":"","phone":"","prepay_id":"","profit":"","sa":null,"selected":true,"shou_date":"","smark":"","sp":null,"sp_count":"1","sp_dealer":"","sp_grounding":"1","sp_id":"1590","sp_postage":"0","sp_price":"800.00","sp_simg":"/upload/20170209/093558871.jpg","sp_title":"梵宇景德镇韩式陶瓷","sp_total":"800.00","tmark":"","twuliu":"","twuliuid":"","u_account":"15777777777","u_delete":"0","u_id":"","u_phone":"","uadm":"","uadmname":"","udate":"","vir":"","virid":"","wuliu":"","wuliuid":"","wxpay":"","youfei":"","youmo":"0","yunfei":"0.00"}]
     * panduan : null
     * or_count_nopay : 0
     */

    private String orid;
    private int or_count_noping;
    private int or_count_all;
    private int or_count_noshou;
    private int or_count_nopay;
    private List<IndentItemBean> pagination;

    public String getOrid() {
        return orid;
    }

    public void setOrid(String orid) {
        this.orid = orid;
    }

    public int getOr_count_noping() {
        return or_count_noping;
    }

    public void setOr_count_noping(int or_count_noping) {
        this.or_count_noping = or_count_noping;
    }

    public int getOr_count_all() {
        return or_count_all;
    }

    public void setOr_count_all(int or_count_all) {
        this.or_count_all = or_count_all;
    }

    public int getOr_count_noshou() {
        return or_count_noshou;
    }

    public void setOr_count_noshou(int or_count_noshou) {
        this.or_count_noshou = or_count_noshou;
    }

    public int getOr_count_nopay() {
        return or_count_nopay;
    }

    public void setOr_count_nopay(int or_count_nopay) {
        this.or_count_nopay = or_count_nopay;
    }

    public List<IndentItemBean> getPagination() {
        return pagination;
    }

    public void setPagination(List<IndentItemBean> pagination) {
        this.pagination = pagination;
    }
}
