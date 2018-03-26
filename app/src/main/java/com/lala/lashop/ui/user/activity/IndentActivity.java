package com.lala.lashop.ui.user.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.user.fragment.IndentFragment;

import butterknife.BindView;

/**
 * 我的订单
 * Created by JX on 2018/3/23.
 */

public class IndentActivity extends BaseActivity {

    @BindView(R.id.indent_tbl)
    TabLayout tbl;
    @BindView(R.id.indent_vp)
    ViewPager vp;

    @Override
    public int setContentView() {
        return R.layout.indent_activity;
    }

    @Override
    public void onCreate() {
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tbl.setupWithViewPager(vp);
        tbl.setTabMode(TabLayout.MODE_SCROLLABLE);
        vp.setOffscreenPageLimit(2);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        private String[] titles = {"全部", "待付款", "待收货"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new IndentFragment();
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
