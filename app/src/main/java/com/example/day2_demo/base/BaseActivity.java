package com.example.day2_demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends SimpleActivity{
   protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        presenter=initPresenter();
        super.onCreate(savedInstanceState);
        if (presenter!=null){
            presenter.getView((V) this);
        }
    }

    public void showProgressBar(){

    }

    public void hideProgressBar(){

    }

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.ondetach();
        }
    }
}
