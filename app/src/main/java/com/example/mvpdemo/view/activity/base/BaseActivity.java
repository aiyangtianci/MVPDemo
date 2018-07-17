package com.example.mvpdemo.view.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.utils.DialogUtil;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Created by aiyang on 2018/7/3.
 */

public abstract class BaseActivity<T extends BaseConstract.IBasePersenter> extends RxAppCompatActivity implements BaseConstract.IBaseView{
    FrameLayout mRootView;
    RelativeLayout rl;
    private Unbinder unbinder;

    protected T mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        createView();
        init(mRootView, savedInstanceState);
        attachView();
    }

    private void createView(){
        rl = findViewById(R.id.title_rl);
        mRootView = findViewById(R.id.view_content);
        View view = LayoutInflater.from(this).inflate(setContentView(), mRootView);
        unbinder = ButterKnife.bind(this, view);
    }

    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
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

    @Override
    public void showProgress() {
        DialogUtil.showProgress(this,"请求中。。");
    }

    @Override
    public void hideProgress() {
        DialogUtil.dismissProgress();
    }

    @Override
    public void showFaild(String onError) {
        DialogUtil.showSimpleDialog(this,"错误提示",onError,null);
    }

    //接口隔离原则：使用多个隔离的接口，比使用单个接口要好，目的就是降低类之间的耦合度，便于软件升级和维护。
    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }
}

