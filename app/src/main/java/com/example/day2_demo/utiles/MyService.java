package com.example.day2_demo.utiles;

import android.arch.lifecycle.LiveData;

import com.example.day2_demo.bean.BaseResponse;
import com.example.day2_demo.bean.ListData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MyService {
    String url="https://www.wanandroid.com/";
    @GET
    Observable<BaseResponse<List<ListData>>> getData(@Url String s);

}
