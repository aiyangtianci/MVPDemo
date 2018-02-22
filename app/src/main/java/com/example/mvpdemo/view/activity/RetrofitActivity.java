package com.example.mvpdemo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mvpdemo.R;
import com.example.mvpdemo.adapter.BookCustomAdapter;
import com.example.mvpdemo.model.Book;
import com.example.mvpdemo.model.BookItemBean;
import com.example.mvpdemo.presenter.IPresenter.IBookPresenter;
import com.example.mvpdemo.presenter.compl.BookPresenter;
import com.example.mvpdemo.utils.DialogUtil;
import com.example.mvpdemo.view.interfaceview.IRetrofitActivityView;

import java.util.List;

/**
 * Created by aiyang on 2018/2/8.
 */

public class RetrofitActivity extends AppCompatActivity implements IRetrofitActivityView,
        IBookPresenter.IBookCustomView,BaseQuickAdapter.RequestLoadMoreListener{

    private Button button;
    private RecyclerView rvBook;

    private BookPresenter mPresenter;
    private Book mModel;
    private BookCustomAdapter mBookCustomAdapter;
    private String mBookTags = "文学";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        initView();

        init();

        initData();
    }

    @Override
    public void initView() {
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        rvBook =(RecyclerView)findViewById(R.id.rv_book);
    }

    @Override
    public void getData() {
         mPresenter.loadLatestBookList();
    }

    @Override
    public void initData() {
        mPresenter = BookPresenter.getInstance();
        if (mPresenter !=null){
            mModel = (Book) mPresenter.getModel();
            if (mModel != null){
                mPresenter.attachMV(mModel,this);
            }
        }
    }

    @Override
    public void init() {
        //初始化一个空list的adapter，网络错误时使用，第一次加载到数据时重新初始化adapter并绑定recycleview
        mBookCustomAdapter = new BookCustomAdapter(R.layout.item_book_custom);
        rvBook.setAdapter(mBookCustomAdapter);
        rvBook.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void updateContentList(List<BookItemBean> list) {
        DialogUtil.showSimpleDialog(this,"数据"+list.size(),list.get(1)+"");
        if (mBookCustomAdapter.getData().size() == 0) {
            initRecycleView(list);
        } else {
            mBookCustomAdapter.addData(list);
        }
    }
    private void initRecycleView(List<BookItemBean> list) {
        mBookCustomAdapter = new BookCustomAdapter(R.layout.item_book_custom, list);
        mBookCustomAdapter.setOnLoadMoreListener(this, rvBook);
        mBookCustomAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.onItemClick(position, (BookItemBean) adapter.getItem(position),
                        (ImageView) view.findViewById(R.id.iv_item_image));
            }
        });
        rvBook.setAdapter(mBookCustomAdapter);
    }

    @Override
    public void onLoadMoreRequested() {
        mBookCustomAdapter.loadMoreComplete();
        mPresenter.loadMoreBookList();
    }

    @Override
    public void showNetworkError() {
//        mBookCustomAdapter.setEmptyView(errorView);
    }

    @Override
    public void showLoadMoreError() {
        mBookCustomAdapter.loadMoreFail();
    }

    @Override
    public void showNoMoreData() {
            mBookCustomAdapter.loadMoreEnd(true);
    }

    @Override
    public String getBookTags() {
        return mBookTags;
    }

    @Override
    public void showToast(String msg) {}

    @Override
    public boolean isVisiable() {
        return false;
    }



}
