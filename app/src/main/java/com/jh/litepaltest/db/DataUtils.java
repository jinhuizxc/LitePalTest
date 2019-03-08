package com.jh.litepaltest.db;

import android.content.Context;

/**
 * Author: Created by Real_Man.
 * Version: 1.0
 * Data: 2016/9/29.
 * Other:
 */

public class DataUtils {

    private static MyOpenHelper mHelper;

    private DataUtils(){
    }

    public static void initHelper(Context context,String name){
        if(mHelper == null){
            mHelper = new MyOpenHelper(context,name);
        }
    }
    public static MyOpenHelper getHelper(){
        if(mHelper == null){
            new RuntimeException("MyOpenHelper is null,No init it");
        }
        return mHelper;
    }
}
