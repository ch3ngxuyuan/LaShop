package com.lala.lashop.ui.shop.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JX on 2018/4/12.
 */

public class InvoiceBean implements Parcelable {

    /**
     * adate : 2018-04-15 16:07:42.0
     * head : 测试名称
     * id : 1
     * moren : 1
     * taxnumber : 123456799
     * user_id : 10030
     */

    private String adate;
    private String head;
    private String id;
    private String moren;
    private String taxnumber;
    private String user_id;

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoren() {
        return moren;
    }

    public void setMoren(String moren) {
        this.moren = moren;
    }

    public String getTaxnumber() {
        return taxnumber;
    }

    public void setTaxnumber(String taxnumber) {
        this.taxnumber = taxnumber;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.adate);
        dest.writeString(this.head);
        dest.writeString(this.id);
        dest.writeString(this.moren);
        dest.writeString(this.taxnumber);
        dest.writeString(this.user_id);
    }

    public InvoiceBean() {
    }

    protected InvoiceBean(Parcel in) {
        this.adate = in.readString();
        this.head = in.readString();
        this.id = in.readString();
        this.moren = in.readString();
        this.taxnumber = in.readString();
        this.user_id = in.readString();
    }

    public static final Parcelable.Creator<InvoiceBean> CREATOR = new Parcelable.Creator<InvoiceBean>() {
        @Override
        public InvoiceBean createFromParcel(Parcel source) {
            return new InvoiceBean(source);
        }

        @Override
        public InvoiceBean[] newArray(int size) {
            return new InvoiceBean[size];
        }
    };
}
