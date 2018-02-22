package com.example.mvpdemo.presenter.compl;

import android.util.Log;
import android.widget.ImageView;

import com.example.mvpdemo.model.Book;
import com.example.mvpdemo.model.Book.BookListBean;
import com.example.mvpdemo.model.BookItemBean;
import com.example.mvpdemo.presenter.IPresenter.IBookPresenter;

import io.reactivex.functions.Consumer;

/**
 * Created by aiyang on 2018/2/8.
 */

public class BookPresenter extends IBookPresenter.BookCustomPresenter{
    private int mStart;
    private int mCount = 30;
    private boolean isLoading;

    public static BookPresenter getInstance() {
        return new BookPresenter();
    }

    @Override
    public void loadLatestBookList() {
        if (mIModel == null || mIView == null)
            return;

        mStart = 0;
        //一次加载20条数据
        mRxManager.register(mIModel.getBookListWithTag(mIView.getBookTags(), mStart, mCount)
                .subscribe(new Consumer<BookListBean>() {
                    @Override
                    public void accept(BookListBean bookListBean) throws Exception {
                        if (mIView == null)
                            return;

                        mStart += mCount;
                        mIView.updateContentList(bookListBean.getBooks());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (mIView == null)
                            return;

                        if (mIView.isVisiable())
                            mIView.showToast("Network error.");

                        mIView.showNetworkError();
                    }
                }));
    }

    @Override
    public void loadMoreBookList() {
        if (!isLoading) {
            isLoading = true;
            //一次加载20条数据
            mRxManager.register(mIModel.getBookListWithTag(mIView.getBookTags(), mStart, mCount)
                    .subscribe(new Consumer<BookListBean>() {
                        @Override
                        public void accept(BookListBean bookListBean) throws
                                Exception {
                            isLoading = false;
                            if (mIView == null)
                                return;

                            if (bookListBean != null && bookListBean.getBooks() != null &&
                                    bookListBean.getBooks().size() > 0) {
                                mStart += mCount;
                                mIView.updateContentList(bookListBean.getBooks());
                            } else {
                                mIView.showNoMoreData();
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            isLoading = false;
                            if (mIView != null) {
                                mIView.showLoadMoreError();
                            }
                        }
                    }));
        }
    }


    @Override
    public void onItemClick(int position, BookItemBean item, ImageView imageView) {
        Log.d("aaa","oh ~ you onClick me...shit~!!!");
    }

    @Override
    public IBookPresenter.IBookCustomModel getModel() {
        return Book.getInstance();
    }

    @Override
    public void onStart() {
    }
}
