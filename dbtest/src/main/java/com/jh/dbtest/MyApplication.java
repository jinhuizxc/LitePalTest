package com.jh.dbtest;

import android.app.Application;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

/**
 * Created by 1 on 2017/10/17.
 *  自己的Application
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
