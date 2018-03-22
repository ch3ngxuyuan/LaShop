package com.lala.lashop.ui.home.bean;

import java.util.List;

/**
 * Created by JX on 2018/3/22.
 */

public class HomeBean {

    private List<CategoryBean> category;
    private List<?> tg;
    private List<?> jp;
    private List<?> qg;

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public List<?> getJp() {
        return jp;
    }

    public void setJp(List<?> jp) {
        this.jp = jp;
    }

    public List<?> getQg() {
        return qg;
    }

    public void setQg(List<?> qg) {
        this.qg = qg;
    }
}
