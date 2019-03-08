package com.jh.dbtest;

import com.google.gson.Gson;
import com.jh.dbtest.model.TopBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 1 on 2017/10/17.
 * top数据请求的类
 */

public class TopDataController {

    private GetTopDataListener mGetTopDataListener;

    public void getTopNetData(String testUrl) {
        OkHttpUtils.get().url(testUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                if (mGetTopDataListener != null) {
                    mGetTopDataListener.getTopDataError(e);
                }
            }

            @Override
            public void onResponse(String response, int id) {
                TopBean topBean = new Gson().fromJson(response, TopBean.class);
                if (topBean != null) {
                    if (mGetTopDataListener != null) {
                        mGetTopDataListener.getTopDataSuccess(topBean);
                    }
                }
            }
        });
    }


    public void setGetTopDataListener(GetTopDataListener getTopDataListener) {
        this.mGetTopDataListener = getTopDataListener;
    }

    public interface GetTopDataListener {

        void getTopDataSuccess(TopBean topBean);

        void getTopDataError(Exception e);
    }
}
