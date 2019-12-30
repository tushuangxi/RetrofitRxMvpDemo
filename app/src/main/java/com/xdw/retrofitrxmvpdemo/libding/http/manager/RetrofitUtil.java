package com.xdw.retrofitrxmvpdemo.libding.http.manager;

import android.content.Context;
import com.google.gson.GsonBuilder;
import com.xdw.retrofitrxmvpdemo.libding.http.RetrofitApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.xdw.retrofitrxmvpdemo.libding.http.RetrofitApiService.BASE_URL;

/**
 */
public class RetrofitUtil {
    private Context mCntext;
    //声明Retrofit对象
    private Retrofit mRetrofit;
    //声明RetrofitApiService对象
    private RetrofitApiService retrofitApiService;
    OkHttpClient client = new OkHttpClient();
    GsonConverterFactory factory = GsonConverterFactory.create(new GsonBuilder().create());

    //由于该对象会被频繁调用，采用单例模式，下面是一种线程安全模式的单例写法
    private volatile static RetrofitUtil instance;

    public static RetrofitUtil getInstance(Context context){
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    instance = new RetrofitUtil(context);
                }
            }
        }
        return instance;
    }
    private RetrofitUtil(Context mContext){
        mCntext = mContext;
        init();
    }

    //初始化Retrofit
    private void init() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        retrofitApiService = mRetrofit.create(RetrofitApiService.class);
    }

    public RetrofitApiService getRetrofitApiService(){
        return retrofitApiService;
    }
}
