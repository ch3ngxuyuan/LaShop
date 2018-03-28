package com.lala.lashop.ui.cate.activity;

import android.widget.TextView;

import com.lala.lashop.R;
import com.lala.lashop.app.App;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.base.mvp.CreatePresenter;
import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.ui.cate.presenter.ShopInfoPresenter;
import com.lala.lashop.ui.cate.view.ShopInfoView;
import com.lala.lashop.ui.home.bean.BannerBean;
import com.lala.lashop.ui.home.bean.ShopsBean;
import com.lala.lashop.utils.BannerImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 商品详情
 * Created by JX on 2018/3/28.
 */

@CreatePresenter(ShopInfoPresenter.class)
public class ShopInfoActivity extends BaseActivity<ShopInfoView, ShopInfoPresenter> implements ShopInfoView {

    public static final String SHOP_ID = "shopid";

    @BindView(R.id.shopinfo_banner)
    Banner banner;
    @BindView(R.id.shopinfo_tv_title)
    TextView tvTitle;
    @BindView(R.id.shopinfo_tv_des)
    TextView tvDes;
    @BindView(R.id.shopinfo_tv_price)
    TextView tvPrice;

    private String shopid; //商品id

    @Override
    public int setContentView() {
        return R.layout.shopinfo_activity;
    }

    @Override
    public void onCreate() {
        shopid = getIntent().getStringExtra(SHOP_ID);

        banner.setImageLoader(new BannerImageLoader());
        banner.setIndicatorGravity(BannerConfig.CENTER);

        getPresenter().getShopInfo();
    }

    @Override
    public void setData(ShopInfoBean data) {
        List<String> images = new ArrayList<>();
        for (ShopsBean bean : data.getShopPhoto()) {
            images.add(bean.getSp_img());
        }
        banner.setImages(images);
        banner.start();

        ShopsBean shopsBean = data.getShop();

        tvTitle.setText(shopsBean.getSp_title());
        tvDes.setText(shopsBean.getSp_discontent());
        tvPrice.setText("￥" + shopsBean.getSp_mprice());
    }

    @Override
    public String getShopId() {
        return shopid;
    }

    @Override
    public String getUserId() {
        return App.getUser() != null ? App.getUser().getUser_id() : "";
    }
}
