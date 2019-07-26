package com.example.day2_demo.utiles;

import com.example.day2_demo.bean.ListData;

import java.util.List;

public interface Contract {
    interface MainView{

        void showSuccess(List<ListData> listData);

        void showError(String error);
    }


    interface MainPresenter{
        void http();
    }


    interface MainModle{
        interface CallBack{
            void showSuccess(List<ListData>listData);

            void showError(String error);
        }
        void getData(CallBack callBack);
    }
}
