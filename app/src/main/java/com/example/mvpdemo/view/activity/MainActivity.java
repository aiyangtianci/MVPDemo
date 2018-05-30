package com.example.mvpdemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.mvpdemo.R;
import com.example.mvpdemo.presenter.IPresenter.IMainActivityPresenter;
import com.example.mvpdemo.presenter.compl.MainActivityPresenterCompl;
import com.example.mvpdemo.view.interfaceview.IMainActivityView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivityView,View.OnClickListener{

    private IMainActivityPresenter mainActivityPresenter ;
    private List<EditText> editList ;
    private ProgressBar progressBar ;
    private Button btn_submit;
    private Button btn_clean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                submitData();
                break;
            case R.id.clean:
                initData();
                break;
        }
    }

    @Override
    public void initView() {
        editList.add((EditText) findViewById(R.id.age));
        editList.add((EditText) findViewById(R.id.gender));
        editList.add((EditText) findViewById(R.id.name));
        editList.add((EditText) findViewById(R.id.hobby));
        progressBar = (ProgressBar) findViewById(R.id.submit_pro);
        btn_clean = (Button) findViewById(R.id.clean);
        btn_submit = (Button) findViewById(R.id.submit);
        btn_submit.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
        progressBar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public void submitData() {
        mainActivityPresenter.submitData(this,editList,progressBar);
    }

    @Override
    public void initData() {
        mainActivityPresenter.initData(editList);
    }

    @Override
    public void init() {
        mainActivityPresenter = new MainActivityPresenterCompl();
        editList = new ArrayList<>();
    }
}
