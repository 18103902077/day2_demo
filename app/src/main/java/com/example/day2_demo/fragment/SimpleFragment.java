package com.example.day2_demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleFragment extends Fragment {

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), null);
        bind = ButterKnife.bind(getActivity());
        initPre();
        initViewAnData();
        return view;
    }

    protected abstract void initPre();

    protected abstract void initViewAnData();

    protected abstract int initLayout();

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
