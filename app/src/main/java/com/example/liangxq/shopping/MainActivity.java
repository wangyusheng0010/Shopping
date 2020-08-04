package com.example.liangxq.shopping;

import android.os.Bundle;
import android.util.Log;

import com.example.httplibrary.HttpManager;
import com.example.httplibrary.callback.HttpCallBack;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.disposable.RequestManagerIml;
import com.example.httplibrary.server.ApiServer;
import com.example.liangxq.shopping.app.Demo;
import com.example.liangxq.shopping.app.Response;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends RxAppCompatActivity {

    private Disposable disposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HttpClient.Builder()
                .setApiUrl("article/listproject/0/json")
                .post()
                .setJsonBody("",true)
                .build()
                .request(new HttpCallBack<Demo>() {
            @Override
            public void onSuccess(Demo demo) {
                Log.e("liangxq", "onSuccess:88888 "+demo.toString() );
            }
            @Override
            public Demo convert(JsonElement result) {
                return new Gson().fromJson(new Gson().toJson(result),Demo.class);
            }

            @Override
            public void onError(String message, int code) {
                Log.e("liangxq", "onError: "+message );
            }
            @Override
            public void cancle() {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
