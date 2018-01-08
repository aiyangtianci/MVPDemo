package com.example.mvpdemo.presenter.IPresenter;

import android.content.Context;
import android.widget.EditText;
import android.widget.ProgressBar;

import java.util.List;

/**
 * Created by aiyang on 2018/1/8.
 */

public interface IMainActivityPresenter {

    void submitData(Context context , List<EditText> editList, ProgressBar progressBar);

    void initData(List<EditText> editList);
}
