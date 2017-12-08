package sinaflashmoney.credit.sina.com.mvpdemo.service;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class RetrofitHelper {

    private Context mContext;
    OkHttpClient client=new OkHttpClient();
    GsonConverterFactory factory=GsonConverterFactory.create(new GsonBuilder().create());
    private static RetrofitHelper instance=null;
    private Retrofit retrofit=null;
    public RetrofitHelper(Context context) {
        mContext=context;
        init();
    }

    private void init() {
        resetApp();

    }

    private void resetApp() {
        retrofit=new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


    }

    public static RetrofitHelper getInstance(Context context){
        if (instance==null){
            instance=new RetrofitHelper(context);
        }
        return instance;
    }

   public RetrofitService getService(){
       return retrofit.create(RetrofitService.class);
   }










}
