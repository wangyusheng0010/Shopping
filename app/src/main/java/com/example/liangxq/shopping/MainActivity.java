package com.example.liangxq.shopping;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.httplibrary.callback.HttpCallBack;
import com.example.httplibrary.client.HttpClient;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

public class MainActivity extends RxAppCompatActivity implements View.OnClickListener {

    private Disposable disposable;
    private EditText mNameEt;
    private EditText mPswEt;
    private Button mLoginBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mNameEt = (EditText) findViewById(R.id.et_name);
        mPswEt = (EditText) findViewById(R.id.et_psw);
        mLoginBt = (Button) findViewById(R.id.bt_login);
        mLoginBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                String name = mNameEt.getText().toString();
                String psw = mPswEt.getText().toString();
                HashMap<String, Object> map = new HashMap<>();
                map.put("username",name);
                map.put("psw",psw);
                new HttpClient.Builder()
                        .setApiUrl("project/tree/json")
//                        .post()
//                        .setParamser(map)
//                        .setHeadres()
                        .get()
                        .build()
                        .request(new HttpCallBack<ClassifyBean>(){
                            @Override
                            public void onError(String message, int code) {
                                Log.e("wangys", "onError: "+message+code );
                            }

                            @Override
                            public void cancle() {

                            }

                            @Override
                            public void onSuccess(ClassifyBean bean) {
                                Log.e("wangys", "onSuccess: "+bean.toString() );
                            }

                            @Override
                            public ClassifyBean convert(JsonElement result) {
                                return new Gson().fromJson(new Gson().toJson(result),ClassifyBean.class);
                            }
                        });
                break;
            default:
                break;
        }
    }
}
