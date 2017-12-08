package sinaflashmoney.credit.sina.com.mvpdemo.service.view;

import sinaflashmoney.credit.sina.com.mvpdemo.service.entity.Book;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public interface BookView extends View{
    void onSuccess(Book mBook);
    void onError(String result);
}
