package com.example.day2_demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day2_demo.base.BasePresenter;

public abstract class BaseFragment<V,P extends BasePresenter<V>> extends SimpleFragment{
    protected P mpresenter;

    @Override
    protected void initPre() {
        mpresenter=getPresenter();
        if (mpresenter!=null){
            mpresenter.getView((V) this);
        }
    }

    protected abstract P getPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mpresenter!=null){
            mpresenter.ondetach();
        }
    }
}
