package com.xdw.retrofitrxmvpdemo.libding.http;

import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**

 */
public interface RetrofitApiService {

    String BASE_URL="http://api.zhuishushenqi.com";

    @GET("/cats/lv2/statistics/")
    Observable<GetListRsp> getUserInfo(@QueryMap Map<String, String> params);

}
