package com.example.day2_demo.model;

import android.util.Log;

import com.example.day2_demo.base.BaseObserver;
import com.example.day2_demo.base.HttpManager;
import com.example.day2_demo.bean.BaseResponse;
import com.example.day2_demo.bean.ListData;
import com.example.day2_demo.utiles.Contract;
import com.example.day2_demo.utiles.MyService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ImpModel extends BaseObserver<BaseResponse<List<ListData>>> implements Contract.MainModle {

    private static final String TAG = "tag";
    @Override
    protected <T> void getSuccess(T t) {

    }

    @Override
    protected <T> void getError(T s) {

    }

    @Override
    public void getData(final CallBack callBack) {
        HttpManager.getInstance().getServer(MyService.class).getData("wxarticle/chapters/json")
                .compose(HttpManager.getInstance().<BaseResponse<List<ListData>>>getFormer())
                .compose(HttpManager.getInstance().<List<ListData>>changeResult())
                .subscribe(new Observer<List<ListData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ListData> listData) {
                        callBack.showSuccess(listData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.showError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
