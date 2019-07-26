package com.example.day2_demo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.day2_demo.base.BaseActivity;
import com.example.day2_demo.bean.ListData;
import com.example.day2_demo.presenter.ImpPresenter;
import com.example.day2_demo.utiles.Contract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<Contract.MainView, ImpPresenter> implements Contract.MainView {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected ImpPresenter initPresenter() {
        return new ImpPresenter();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewAndData() {
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(this);
        recycler.setAdapter(recyclerAdapter);

        presenter.http();
    }

    @Override
    public void showSuccess(List<ListData> listData) {
        recyclerAdapter.getData(listData);
    }

    private static final String TAG = "tag";
    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: ========"+error);
    }

}
