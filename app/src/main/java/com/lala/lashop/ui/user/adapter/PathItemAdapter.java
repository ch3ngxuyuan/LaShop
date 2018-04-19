package com.lala.lashop.ui.user.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseAdapter;
import com.lala.lashop.base.BaseViewHolder;
import com.lala.lashop.http.ApiPath;
import com.lala.lashop.ui.cate.ShopInfoActivity;
import com.lala.lashop.ui.user.bean.PathBean;

import java.util.List;

/**
 * Created by JX on 2018/4/19.
 */

public class PathItemAdapter extends BaseAdapter<PathBean> {

    public PathItemAdapter(int layoutResId, @Nullable List<PathBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, final PathBean item) {
        holder.loadImage(R.id.iv_image, ApiPath.IMG_URL + item.getShop_img());
        holder.setText(R.id.tv_title, item.getShop_name());
        holder.setText(R.id.tv_price, "￥" + item.getShop_price());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShopInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ShopInfoActivity.SHOP_ID, item.getShopid());
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });
    }
}
