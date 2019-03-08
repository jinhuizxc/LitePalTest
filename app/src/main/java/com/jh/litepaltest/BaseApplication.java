package com.jh.litepaltest;

import android.app.Application;

import org.litepal.LitePal;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化LitePal数据库
        LitePal.initialize(this);

    }
}
