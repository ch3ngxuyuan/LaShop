package com.lala.lashop.ui.user.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.lala.lashop.R;
import com.lala.lashop.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by JX on 2018/4/19.
 */

public class UserEditActivity extends BaseActivity {

    public static final String CONTENT = "content";

    @BindView(R.id.et_content)
    EditText etContent;

    private String content;

    @Override
    public int setContentView() {
        return R.layout.user_edit_activity;
    }

    @Override
    public void onCreate() {
        getToolbar().setTitle("编辑资料");
        getToolbar().setRightText("保存")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String str = etContent.getText().toString();
                        if (TextUtils.isEmpty(str)) {
                            toast("内容不能为空");
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(CONTENT, str);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    }
                });

        content = getIntent().getStringExtra(CONTENT);

        if (!TextUtils.isEmpty(content)) {
            etContent.setText(content);
        }
    }
}
