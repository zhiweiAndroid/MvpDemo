package sinaflashmoney.credit.sina.com.mvpdemo.service.presenter;

import android.content.Intent;

import sinaflashmoney.credit.sina.com.mvpdemo.service.view.View;


/**
 * Created by Administrator on 2017/12/8 0008.
 */

public interface Presenter {
    void onCreat();
    void onStart();
    void onStop();
    void pause();
    void attachView(View view);
    void attachIncomingIntent(Intent intent);



}
