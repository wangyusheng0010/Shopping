package com.example.liangxq.shopping.app;

import android.app.Application;

import com.example.httplibrary.HttpConstant;
import com.example.httplibrary.HttpGlobalConfig;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.app
 * 文件名：ShopApplication
 * 创建者：liangxq
 * 创建时间：2020/8/1  14:12
 * 描述：TODO
 */
public class ShopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        HttpGlobalConfig.getInsance()
//                .setBaseUrl("https://www.wanandroid.com/")
//                .setTimeout(HttpConstant.TIME_OUT)
//                .setShowLog(true)
//                .setTimeUnit(HttpConstant.TIME_UNIT)
//                .initReady(this);
        HttpGlobalConfig.getInsance()
                .setBaseUrl("https://www.wanandroid.com/")
                .setShowLog(true)
                .setTimeout(HttpConstant.TIME_OUT)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);
    }
}
