package com.example.mvpdemo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.info.Book;
import com.example.mvpdemo.presenter.compl.BookPresenter;
import com.example.mvpdemo.view.interfaceview.BookView;

/**
 * Created by aiyang on 2018/2/8.
 */

public class RetrofitActivity extends AppCompatActivity {

    private Button button;
    private TextView text;

    private BookPresenter mBookPresenter = new BookPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        button = (Button)findViewById(R.id.button);
        text = (TextView)findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBookPresenter.getSearchBooks("金瓶梅", null, 0, 1);
            }
        });


        mBookPresenter.onCreate();
        mBookPresenter.attachView(mBookView);
    }

    private BookView mBookView = new BookView() {
        @Override
        public void onSuccess(Book mBook) {
            text.setText(mBook.toString());
        }

        @Override
        public void onError(String result) {
            Toast.makeText(RetrofitActivity.this,result, Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mBookPresenter.onStop();
    }
}
