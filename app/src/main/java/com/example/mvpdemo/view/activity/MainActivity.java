package com.example.mvpdemo.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.entity.Book;
import com.example.mvpdemo.presenter.IPresenter.ImainPresenter;
import com.example.mvpdemo.presenter.compl.MainPresentImpl;
import com.example.mvpdemo.view.activity.base.BaseActivity;
import com.example.mvpdemo.view.interfaceview.MainView;

public class MainActivity extends BaseActivity<MainPresentImpl> implements View.OnClickListener , MainView{

    private TextView text_response;
    private Button getButton;



    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(View view ,Bundle savedInstanceState) {
        setTitle("首页");
        setBack(true);
        initView();
        mPresenter = new MainPresentImpl(this,this);
    }

    private void initView() {
        text_response = findViewById(R.id.text_response);
        getButton = findViewById(R.id.button_get);
        getButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_get){
            mPresenter.getSearchBooks("少年维特的烦恼",null,0,1);
        }
    }

    @Override
    public void setBooksUISuccess(Book book) {
        text_response.setText(book.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
