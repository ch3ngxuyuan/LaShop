package com.lala.lashop.ui.user.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.ui.user.fragment.ApplyFragment;

import butterknife.BindView;

/**
 * 申请售后
 * Created by JX on 2018/3/27.
 */

public class ApplyActivity extends BaseActivity {

    @BindView(R.id.apply_tab)
    TabLayout tab;
    @BindView(R.id.apply_vp)
    ViewPager vp;

    @Override
    public int setContentView() {
        return R.layout.apply_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("申请售后");

        vp.setAdapter(new MyPaperAdapter(getSupportFragmentManager()));
        tab.setupWithViewPager(vp);
    }

    private class MyPaperAdapter extends FragmentPagerAdapter {

        private String[] titles = {"申请售后", "申请记录"};

        public MyPaperAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ApplyFragment();
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
