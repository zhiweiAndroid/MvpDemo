package sinaflashmoney.credit.sina.com.mvpdemo.service.presenter;

import android.content.Context;
import android.content.Intent;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import sinaflashmoney.credit.sina.com.mvpdemo.service.entity.Book;
import sinaflashmoney.credit.sina.com.mvpdemo.service.manager.DataManager;
import sinaflashmoney.credit.sina.com.mvpdemo.service.view.BookView;
import sinaflashmoney.credit.sina.com.mvpdemo.service.view.View;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class BookPresenter implements Presenter {
    private Context mContext;
    private DataManager manager;
    private CompositeSubscription compositeSubscription;
    private BookView bookview;
    private Book mBook;
    public BookPresenter (Context mContext){
        this.mContext = mContext;
    }

    @Override
    public void onCreat() {
        manager =new DataManager(mContext);
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
         if (compositeSubscription.hasSubscriptions()){
             compositeSubscription.unsubscribe();
         }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(View view) {
        bookview = (BookView) view;

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }
    public void getSearchBooks(String name,String tag,int start,int count){
        compositeSubscription.add(manager.getSearchBook(name,tag,start,count)
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Book>() {
                    @Override
                    public void onCompleted() {
                        if (mBook != null){
                            bookview.onSuccess(mBook);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        bookview.onError("请求失败!!");
                    }

                    @Override
                    public void onNext(Book book) {
                          mBook=book;
                    }
                })
        );




    }


}
