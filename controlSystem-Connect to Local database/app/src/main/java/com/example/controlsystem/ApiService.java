package com.example.controlsystem;


import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @Description: TODO
 * @date 2018/3/27
 */

public interface ApiService {
    @GET("getAuthor")
    Observable<String> getData();
    /**
     * http://gank.io/api/data/福利/1/1
     * 这个方法和上面的请求下来的数据是一样的，只是一个用string，一个用类
     * @return
     */
    @GET("http://192.168.4.2/esp/notification.php")  //换成你们自己的数据接口。如果有参数传递，参考下面login的接口
    Observable<Meizi> getAuthorModel();

    @GET("http://192.168.4.2/esp/notification.php")
    Observable<ResponseBody> login(@Query("user_name") String username, @Query("password") String password);
}
