package com.lala.lashop;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import com.lala.lashop.base.BaseActivity;
import com.lala.lashop.fragment.CateFragment;
import com.lala.lashop.fragment.HomeFragment;
import com.lala.lashop.fragment.ShopFragment;
import com.lala.lashop.fragment.UserFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    @BindView(R.id.rg_bottom)
    RadioGroup rgBottom;

    private FragmentManager fragmentManager;
    private HomeFragment homeFragment;
    private CateFragment cateFragment;
    private ShopFragment shopFragment;
    private UserFragment userFragment;

    private int mark = R.id.rb_home;
    private Fragment markFragment;

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate() {
        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        cateFragment = new CateFragment();
        shopFragment = new ShopFragment();
        userFragment = new UserFragment();
//
        fragmentManager.beginTransaction().replace(R.id.main_content, homeFragment).commit();
        markFragment = homeFragment;

        rgBottom.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                setTabSelection(R.id.rb_home, homeFragment);
                break;
            case R.id.rb_cate:
                setTabSelection(R.id.rb_cate, cateFragment);
                break;
            case R.id.rb_shop:
                setTabSelection(R.id.rb_shop, shopFragment);
                break;
            case R.id.rb_user:
                setTabSelection(R.id.rb_user, userFragment);
                break;
        }
    }

    /**
     * @param id 按钮Id
     * @param to 要切换的fragment
     */
    private void setTabSelection(int id, Fragment to) {
        if (id != mark) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (!to.isAdded()) {
                transaction.hide(markFragment).add(R.id.main_content, to).commitAllowingStateLoss();
            } else {
                transaction.hide(markFragment).show(to).commitAllowingStateLoss();
            }
            markFragment = to;
            mark = id;
        }
    }

    private long clickTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if ((System.currentTimeMillis() - clickTime) > 2000) {
                toast("再按一次退出程序");
                clickTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}