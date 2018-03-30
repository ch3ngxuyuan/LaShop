package com.lala.lashop.ui.user.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JX on 2018/3/20.
 */

public class AddressBean implements Parcelable {

    /**
     * aadm :
     * aadmname :
     * adate :
     * addressDetail : 测试详细地址
     * area : 鄂托克旗
     * areaName :
     * city : 鄂尔多斯市
     * cityName :
     * fullName : 测试收货人
     * groupid :
     * id : 1035
     * islimit :
     * isorder :
     * m_id :
     * mobile : 123456789011
     * post :
     * prov : 内蒙古自治区
     * provincialName :
     * sequence :
     * uadm :
     * uadmname :
     * udate :
     * user_id : 10030
     */

    private String aadm;
    private String aadmname;
    private String adate;
    private String addressDetail;
    private String area;
    private String areaName;
    private String city;
    private String cityName;
    private String fullName;
    private String groupid;
    private String id;
    private String islimit;
    private String isorder;
    private String m_id;
    private String mobile;
    private String post;
    private String prov;
    private String provincialName;
    private String sequence;
    private String uadm;
    private String uadmname;
    private String udate;
    private String user_id;

    public String getAadm() {
        return aadm;
    }

    public void setAadm(String aadm) {
        this.aadm = aadm;
    }

    public String getAadmname() {
        return aadmname;
    }

    public void setAadmname(String aadmname) {
        this.aadmname = aadmname;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIslimit() {
        return islimit;
    }

    public void setIslimit(String islimit) {
        this.islimit = islimit;
    }

    public String getIsorder() {
        return isorder;
    }

    public void setIsorder(String isorder) {
        this.isorder = isorder;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getProvincialName() {
        return provincialName;
    }

    public void setProvincialName(String provincialName) {
        this.provincialName = provincialName;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getUadm() {
        return uadm;
    }

    public void setUadm(String uadm) {
        this.uadm = uadm;
    }

    public String getUadmname() {
        return uadmname;
    }

    public void setUadmname(String uadmname) {
        this.uadmname = uadmname;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
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
        dest.writeString(this.aadm);
        dest.writeString(this.aadmname);
        dest.writeString(this.adate);
        dest.writeString(this.addressDetail);
        dest.writeString(this.area);
        dest.writeString(this.areaName);
        dest.writeString(this.city);
        dest.writeString(this.cityName);
        dest.writeString(this.fullName);
        dest.writeString(this.groupid);
        dest.writeString(this.id);
        dest.writeString(this.islimit);
        dest.writeString(this.isorder);
        dest.writeString(this.m_id);
        dest.writeString(this.mobile);
        dest.writeString(this.post);
        dest.writeString(this.prov);
        dest.writeString(this.provincialName);
        dest.writeString(this.sequence);
        dest.writeString(this.uadm);
        dest.writeString(this.uadmname);
        dest.writeString(this.udate);
        dest.writeString(this.user_id);
    }

    public AddressBean() {
    }

    protected AddressBean(Parcel in) {
        this.aadm = in.readString();
        this.aadmname = in.readString();
        this.adate = in.readString();
        this.addressDetail = in.readString();
        this.area = in.readString();
        this.areaName = in.readString();
        this.city = in.readString();
        this.cityName = in.readString();
        this.fullName = in.readString();
        this.groupid = in.readString();
        this.id = in.readString();
        this.islimit = in.readString();
        this.isorder = in.readString();
        this.m_id = in.readString();
        this.mobile = in.readString();
        this.post = in.readString();
        this.prov = in.readString();
        this.provincialName = in.readString();
        this.sequence = in.readString();
        this.uadm = in.readString();
        this.uadmname = in.readString();
        this.udate = in.readString();
        this.user_id = in.readString();
    }

    public static final Parcelable.Creator<AddressBean> CREATOR = new Parcelable.Creator<AddressBean>() {
        @Override
        public AddressBean createFromParcel(Parcel source) {
            return new AddressBean(source);
        }

        @Override
        public AddressBean[] newArray(int size) {
            return new AddressBean[size];
        }
    };
}
