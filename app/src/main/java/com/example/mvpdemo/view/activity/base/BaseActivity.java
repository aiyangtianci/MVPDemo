package com.example.mvpdemo.view.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.mvpdemo.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Created by aiyang on 2018/7/3.
 */

public abstract class BaseActivity extends RxAppCompatActivity{
    FrameLayout mRootView;

    RelativeLayout rl;
    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        rl = findViewById(R.id.title_rl);
        mRootView = findViewById(R.id.view_content);
        View view = LayoutInflater.from(this).inflate(setContentView(), mRootView);
        unbinder = ButterKnife.bind(this, view);
        init(view, savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 设置布局
     *
     * @return
     */
    protected abstract int setContentView();

    /**
     * 子类初始化
     *
     * @param savedInstanceState
     */
    protected abstract void init(View view, Bundle savedInstanceState);

    /**
     * 设置标题
     *
     * @param str
     */
    protected void setTitle(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            rl.setVisibility(View.VISIBLE);
            TextView title_view = findViewById(R.id.title);
            title_view.setText(str);
        }
    }

    /**
     * 显示返回按钮
     *
     * @param show
     */
    protected void setBack(boolean show) {
        TextView back_view = findViewById(R.id.back);
        if (show) {
            back_view.setVisibility(View.VISIBLE);
            back_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

    /**
     * 普通页面跳转
     */
    protected void openActivity(Class<?> Action) {
        startActivity(new Intent(this, Action));
    }

}
