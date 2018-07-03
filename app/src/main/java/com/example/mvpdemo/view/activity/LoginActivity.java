package com.example.mvpdemo.view.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.info.UserInfo;
import com.example.mvpdemo.presenter.IPresenter.ILoginPresenter;
import com.example.mvpdemo.presenter.compl.LoginPresentImpl;
import com.example.mvpdemo.utils.DialogUtil;
import com.example.mvpdemo.view.activity.base.BaseActivity;
import com.example.mvpdemo.view.interfaceview.LoginView;

/**
 * Created by aiyang on 2018/7/3.
 * 登陆页面
 */

public class LoginActivity extends BaseActivity implements LoginView,View.OnClickListener{
    EditText name;
    EditText pwd;
    Button submit;

    ILoginPresenter presenter;
    @Override
    protected int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("登录");
        setBack(false);
        initView();

        presenter = new LoginPresentImpl(this,new UserInfo());


    }

    private void initView() {
        name = findViewById(R.id.name);
        pwd = findViewById(R.id.pwd);
        submit =findViewById(R.id.submit);
        submit.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submit){
            String account = name.getText().toString().trim();
            String password =  pwd.getText().toString().trim();

            if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(password)){
                presenter.loginSubmit(account, password);
            }else {
                DialogUtil.showSimpleDialog(this,"错误提示","账户密码不能为空",null);
            }

        }
    }

    @Override
    public void showProgress() {
        DialogUtil.showProgress(this,"登陆中");
    }

    @Override
    public void hideProgress() {
        DialogUtil.dismissProgress();
    }

    @Override
    public void loginSuccess() {
        DialogUtil.showSimpleDialog(this, "登陆成功", "验证通过，是否进入到首页？", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                openActivity(MainActivity.class);
            }
        });
    }

    @Override
    public void loginFail() {
        DialogUtil.showSimpleDialog(this,"错误提示","账户密码不正确",null);
    }


}
