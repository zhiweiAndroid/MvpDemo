package sinaflashmoney.credit.sina.com.mvpdemo.service.manager;

import android.content.Context;

import rx.Observable;
import sinaflashmoney.credit.sina.com.mvpdemo.service.RetrofitHelper;
import sinaflashmoney.credit.sina.com.mvpdemo.service.RetrofitService;
import sinaflashmoney.credit.sina.com.mvpdemo.service.entity.Book;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class DataManager {

    private RetrofitService mRetrofitService;
    public DataManager(Context context){
        this.mRetrofitService= RetrofitHelper.getInstance(context).getService();

    }

    public Observable<Book> getSearchBook(String name,String tag,int start ,int count){
        return mRetrofitService.getSerchBook(name,tag,start,count);
    }

}
