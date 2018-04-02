package com.lala.lashop.ui.home.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.cate.ShopInfoActivity;
import com.lala.lashop.ui.home.bean.ShopsBean;

import java.util.List;

/**
 * Created by JX on 2018/3/30.
 */

public class HomeSubShopAdapter extends BaseAdapter<ShopsBean> {

    public HomeSubShopAdapter(int layoutResId, @Nullable List<ShopsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, final ShopsBean item) {
        holder.loadImage(R.id.home_shop_sub_iv, ApiPath.IMG_URL + item.getSp_simg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShopInfoActivity.class);
                intent.putExtra(ShopInfoActivity.SHOP_ID, item.getId());
                mContext.startActivity(intent);
            }
        });
    }
}
