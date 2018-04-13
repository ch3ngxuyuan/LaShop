package com.lala.lashop.ui.shop.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JX on 2018/4/13.
 */

public class JieSuanBean implements Parcelable {

    private String order_id;
    private String sp_id;
    private String sp_count;
    private String sp_simg;
    private String sp_title;
    private String sp_price;
    private String yunfei;
    private String color;
    private String gui;

    public JieSuanBean(String order_id, String sp_id, String sp_count, String sp_simg, String sp_title, String sp_price, String yunfei, String color, String gui) {
        this.order_id = order_id;
        this.sp_id = sp_id;
        this.sp_count = sp_count;
        this.sp_simg = sp_simg;
        this.sp_title = sp_title;
        this.sp_price = sp_price;
        this.yunfei = yunfei;
        this.color = color;
        this.gui = gui;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getSp_id() {
        return sp_id;
    }

    public void setSp_id(String sp_id) {
        this.sp_id = sp_id;
    }

    public String getSp_count() {
        return sp_count;
    }

    public void setSp_count(String sp_count) {
        this.sp_count = sp_count;
    }

    public String getSp_simg() {
        return sp_simg;
    }

    public void setSp_simg(String sp_simg) {
        this.sp_simg = sp_simg;
    }

    public String getSp_title() {
        return sp_title;
    }

    public void setSp_title(String sp_title) {
        this.sp_title = sp_title;
    }

    public String getSp_price() {
        return sp_price;
    }

    public void setSp_price(String sp_price) {
        this.sp_price = sp_price;
    }

    public String getYunfei() {
        return yunfei;
    }

    public void setYunfei(String yunfei) {
        this.yunfei = yunfei;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGui() {
        return gui;
    }

    public void setGui(String gui) {
        this.gui = gui;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.order_id);
        dest.writeString(this.sp_id);
        dest.writeString(this.sp_count);
        dest.writeString(this.sp_simg);
        dest.writeString(this.sp_title);
        dest.writeString(this.sp_price);
        dest.writeString(this.yunfei);
        dest.writeString(this.color);
        dest.writeString(this.gui);
    }

    protected JieSuanBean(Parcel in) {
        this.order_id = in.readString();
        this.sp_id = in.readString();
        this.sp_count = in.readString();
        this.sp_simg = in.readString();
        this.sp_title = in.readString();
        this.sp_price = in.readString();
        this.yunfei = in.readString();
        this.color = in.readString();
        this.gui = in.readString();
    }

    public static final Parcelable.Creator<JieSuanBean> CREATOR = new Parcelable.Creator<JieSuanBean>() {
        @Override
        public JieSuanBean createFromParcel(Parcel source) {
            return new JieSuanBean(source);
        }

        @Override
        public JieSuanBean[] newArray(int size) {
            return new JieSuanBean[size];
        }
    };
}
