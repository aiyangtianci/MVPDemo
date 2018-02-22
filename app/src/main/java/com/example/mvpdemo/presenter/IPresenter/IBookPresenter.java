package com.example.mvpdemo.presenter.IPresenter;

import android.widget.ImageView;

import com.example.mvpdemo.model.Book;
import com.example.mvpdemo.view.base.BasePresenter;
import com.example.mvpdemo.model.BookItemBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by aiyang on 2018/2/8.
 */

public interface IBookPresenter {

    abstract class BookCustomPresenter extends BasePresenter<IBookCustomModel,IBookCustomView> {
        /**
         * 加载最新的book list
         */
        public abstract void loadLatestBookList();

        /**
         * 加载更多book list
         */
        public abstract void loadMoreBookList();

        /**
         * item点击事件
         *
         * @param position  position
         * @param item      item
         * @param imageView imageView
         */
        public abstract void onItemClick(int position, BookItemBean item, ImageView imageView);
    }

    interface IBookCustomModel  {
        /**
         * 根据tag获取图书
         *
         * @param tag   搜索关键字
         * @param start 从多少开始，如从"0"开始
         * @param count 一次请求的数目 最多100
         * @return Observable
         */
        Observable<Book.BookListBean> getBookListWithTag(String tag, int start, int count);
    }


    interface IBookCustomView  {
        /**
         * 更新界面list
         *
         * @param list list
         */
        void updateContentList(List<BookItemBean> list);

        /**
         * 显示网络错误
         */
        void showNetworkError();

        /**
         * 显示加载更多错误
         */
        void showLoadMoreError();

        /**
         * 显示没有更多数据
         */
        void showNoMoreData();

        /**
         * 返回定制book tags
         *
         * @return 定制book tags
         */
        String getBookTags();

        /**
         * 显示toast消息
         *
         * @param msg 要显示的toast消息字符串
         */
        void showToast(String msg);

        /**
         * 返回当前页面是否可见
         * @return 当前页面是否可见
         */
        boolean isVisiable();
    }

}
