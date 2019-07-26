package com.example.day2_demo.presenter;

import com.example.day2_demo.MainActivity;
import com.example.day2_demo.base.BasePresenter;
import com.example.day2_demo.bean.ListData;
import com.example.day2_demo.model.ImpModel;
import com.example.day2_demo.utiles.Contract;

import java.util.List;

public class ImpPresenter extends BasePresenter<Contract.MainView> implements Contract.MainPresenter {
    ImpModel impModel;
    public ImpPresenter(){
        impModel=new ImpModel();
    }
    @Override
    public void http() {
        impModel.getData(new Contract.MainModle.CallBack() {
            @Override
            public void showSuccess(List<ListData> listData) {
                iView.showSuccess(listData);
            }

            @Override
            public void showError(String error) {
                iView.showError(error);
            }
        });
    }
}
