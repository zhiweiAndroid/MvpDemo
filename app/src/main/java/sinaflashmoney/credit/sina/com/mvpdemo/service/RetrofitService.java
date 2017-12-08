package sinaflashmoney.credit.sina.com.mvpdemo.service;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import sinaflashmoney.credit.sina.com.mvpdemo.service.entity.Book;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

/**
 * GET ----------查找资源（查）
 * POST --------修改资源（改）
 * PUT ----------上传文件（增）
 * DELETE ----删除文件（删）
 * HEAD--------只请求页面的首部
 */
public interface RetrofitService {

    @GET("book/search")
    Observable<Book> getSerchBook(@Query("q") String name,
                                  @Query("tag") String tag,
                                  @Query("start") int start,
                                  @Query("count") int count);

}
