package com.xdw.retrofitrxmvpdemo.libding.http.manager;

import android.content.Context;

import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import com.xdw.retrofitrxmvpdemo.libding.http.RetrofitApiService;

import java.util.Map;

import rx.Observable;

/**
 * Created by 夏德旺 on 2017/12/8.
 */

//该类用来管理RetrofitApiService中对应的各种API接口，
// 当做Retrofit和presenter中的桥梁，Activity就不用直接和retrofit打交道了
public class DataManager {
    private RetrofitApiService mRetrofitService;
    private volatile static DataManager instance;

    private DataManager(Context context){
        this.mRetrofitService = RetrofitUtil.getInstance(context).getRetrofitApiService();
    }
    //由于该对象会被频繁调用，采用单例模式，下面是一种线程安全模式的单例写法
    public static DataManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager(context);
                }
            }
        }
        return instance;
    }

    public Observable<GetListRsp> getUserInfo(Map<String, String> params){
        return mRetrofitService.getUserInfo(params);
    }
}
