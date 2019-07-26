package com.example.day2_demo.base;


import java.lang.ref.WeakReference;

public  class BasePresenter <V>{
    WeakReference<V> weakReference;

    protected V iView;

    public void getView(V view){
        weakReference = new WeakReference<>(view);
        iView= weakReference.get();
    }

    public void ondetach(){
        if (weakReference!=null){
            weakReference.clear();
        }
    }

}
