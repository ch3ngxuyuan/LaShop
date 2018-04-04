package com.lala.lashop.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lala.lashop.R;
import com.lala.lashop.ui.cate.adapter.ColorsAdapter;
import com.lala.lashop.ui.cate.adapter.GuisAdapter;
import com.lala.lashop.ui.cate.bean.ShopInfoBean;
import com.lala.lashop.utils.PhoneResolution;
import com.lala.lashop.utils.SupportMultipleScreensUtil;

/**
 * 选择尺寸，颜色
 * Created by JX on 2018/4/2.
 */

public class ColorGuisPopup extends PopupWindow {

    private ShopInfoBean shopInfoBean;
    private Context context;

    private RecyclerView rvGuis;
    private RecyclerView rvColor;
    private EditText etCount;

    private GuisAdapter guisAdapter;
    private ColorsAdapter colorsAdapter;

    public ColorGuisPopup(Context context, ShopInfoBean shopInfoBean) {
        super(context);
        this.context = context;
        this.shopInfoBean = shopInfoBean;

        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_color_guis, null);
        SupportMultipleScreensUtil.scale(view);
        this.setContentView(view);
        this.setHeight(PhoneResolution.getPhoneHeight((Activity) context) / 2);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();

        rvGuis = view.findViewById(R.id.rv_guis);
        rvColor = view.findViewById(R.id.rv_color);
        etCount = view.findViewById(R.id.et_count);

        guisAdapter = new GuisAdapter(R.layout.colorguis_rv_item, shopInfoBean.getGuis());
        colorsAdapter = new ColorsAdapter(R.layout.colorguis_rv_item, shopInfoBean.getColors());
        guisAdapter.bindToRecyclerView(rvGuis);
        colorsAdapter.bindToRecyclerView(rvColor);

        guisAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                guisAdapter.setSelectPos(position);
            }
        });

        colorsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                colorsAdapter.setSelectPos(position);
            }
        });

        rvGuis.setLayoutManager(new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL));
        rvColor.setLayoutManager(new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL));

        ColorDrawable dw = new ColorDrawable(0x000000);
        this.setBackgroundDrawable(dw);
        this.setAnimationStyle(R.style.bottom_popup_animation);
    }

    public void showPopupWindow(View parent) {
        showAtLocation(parent, Gravity.BOTTOM, 0, 0);

        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = 0.7f;
        ((Activity) context).getWindow().setAttributes(lp);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = 1f;
        ((Activity) context).getWindow().setAttributes(lp);
    }

    public String getColor() {
        return colorsAdapter.getColor();
    }

    public String getGuis() {
        return guisAdapter.getGuis();
    }

    public String getCount() {
        return etCount.getText().toString();
    }

}
