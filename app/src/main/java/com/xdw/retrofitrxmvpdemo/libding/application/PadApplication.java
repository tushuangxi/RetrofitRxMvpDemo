package com.xdw.retrofitrxmvpdemo.libding.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by tushuangxi 2019.1.26
 */
public class PadApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //获取context
        mContext = getApplicationContext();
    }
    //创建一个静态的方法，以便获取context对象
    public static Context getContext(){
        return mContext;
    }

}
