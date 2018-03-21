package com.lala.lashop.ui.cate.presenter;

import com.lala.lashop.base.mvp.BasePresenter;
import com.lala.lashop.ui.cate.model.CateModel;
import com.lala.lashop.ui.cate.view.CateView;

/**
 * Created by JX on 2018/3/21.
 */

public class CatePresenter extends BasePresenter<CateView> {

    private CateModel mModel;

    public CatePresenter() {
        mModel = new CateModel();
    }
}
