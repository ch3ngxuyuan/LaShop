package com.lala.lashop.ui.shop.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JX on 2018/4/12.
 */

public class ConfirmBean implements Parcelable {


    /**
     * total : 180.00
     * order : {"a_id":"","aadm":"","aadmname":"","actid":"","adate":"","addr":"","admin_id":"10030","c_id":"","clds":[],"color":"卡其色","comment_body":"","distribution":"","dmark":"","enddate":"","fa_date":"","groupid":"20140808080808","gui":"均码","haveping":"","id":"281","isFanli":0,"islimit":"","isorder":"","isscore":"","jmark":"","lang_id":"","limit":"","m_date":"","name":"","nowcount":"","openid":"","or_date":"2018-04-12 22:53:05.0","or_flag":"0","order_id":"180412225305872","payStatus":"10042","pay_pwd":"","payway":"","phone":"","prepay_id":"","profit":"","sa":null,"selected":true,"shou_date":"","smark":"","sp":null,"sp_count":"1","sp_dealer":"","sp_grounding":"","sp_id":"1597","sp_postage":"0","sp_price":"180.00","sp_simg":"/upload/20170210/170240902.jpg","sp_title":"Diller情侣杯","sp_total":"180.00","tmark":"","twuliu":"","twuliuid":"","u_account":"","u_delete":"0","u_id":"","u_phone":"","uadm":"","uadmname":"","udate":"","vir":"","virid":"","wuliu":"","wuliuid":"","wxpay":"","youfei":"","youmo":"","yunfei":"0.00"}
     * mrlist : [{"a_id":"","aadm":"","aadmname":"","actid":"","adate":"","addr":"","admin_id":"10030","c_id":"","clds":[],"color":"卡其色","comment_body":"","distribution":"","dmark":"","enddate":"","fa_date":"","groupid":"20140808080808","gui":"均码","haveping":"","id":"281","isFanli":0,"islimit":"","isorder":"","isscore":"","jmark":"","lang_id":"","limit":"","m_date":"","name":"","nowcount":"993","openid":"","or_date":"2018-04-12 22:53:05","or_flag":"0","order_id":"180412225305872","payStatus":"10042","pay_pwd":"","payway":"","phone":"","prepay_id":"","profit":"","sa":null,"selected":true,"shou_date":"","smark":"","sp":null,"sp_count":"1","sp_dealer":"","sp_grounding":"","sp_id":"1597","sp_postage":"0","sp_price":"180.00","sp_simg":"/upload/20170210/170240902.jpg","sp_title":"Diller情侣杯","sp_total":"180.00","tmark":"","twuliu":"","twuliuid":"","u_account":"15777777777","u_delete":"0","u_id":"","u_phone":"","uadm":"","uadmname":"","udate":"","vir":"","virid":"","wuliu":"","wuliuid":"","wxpay":"","youfei":"","youmo":"","yunfei":"0.00"}]
     * yunfei : 0.00
     */

    private String total;
    private OrderBean order;
    private String yunfei;
    private List<MrlistBean> mrlist;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public String getYunfei() {
        return yunfei;
    }

    public void setYunfei(String yunfei) {
        this.yunfei = yunfei;
    }

    public List<MrlistBean> getMrlist() {
        return mrlist;
    }

    public void setMrlist(List<MrlistBean> mrlist) {
        this.mrlist = mrlist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.total);
        dest.writeParcelable(this.order, flags);
        dest.writeString(this.yunfei);
        dest.writeList(this.mrlist);
    }

    public ConfirmBean() {
    }

    protected ConfirmBean(Parcel in) {
        this.total = in.readString();
        this.order = in.readParcelable(OrderBean.class.getClassLoader());
        this.yunfei = in.readString();
        this.mrlist = new ArrayList<MrlistBean>();
        in.readList(this.mrlist, MrlistBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<ConfirmBean> CREATOR = new Parcelable.Creator<ConfirmBean>() {
        @Override
        public ConfirmBean createFromParcel(Parcel source) {
            return new ConfirmBean(source);
        }

        @Override
        public ConfirmBean[] newArray(int size) {
            return new ConfirmBean[size];
        }
    };
}
