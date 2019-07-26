package com.example.day2_demo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day2_demo.R;
import com.example.day2_demo.bean.ListData;
import com.example.day2_demo.utiles.Contract;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends BaseFragment<MyFragment,ImpFragmentPresenter> implements Contract.MainView {

    @Override
    protected ImpFragmentPresenter getPresenter() {
        return new ImpFragmentPresenter();
    }

    @Override
    protected void initViewAnData() {

    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_my;
    }

    @Override
    public void showSuccess(List<ListData> listData) {

    }

    @Override
    public void showError(String error) {

    }
}
