package com.example.day2_demo.base;

import com.example.day2_demo.utiles.APIException;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract  class BaseObserver<T> implements Observer<T> {
      CompositeDisposable compositeDisposable=  new CompositeDisposable();

      @Override
      public void onSubscribe(Disposable d) {
            compositeDisposable.add(d);
      }

      @Override
      public void onNext(T t) {
            getSuccess(t);
      }

      @Override
      public void onError(Throwable e) {
            if (e instanceof APIException){
                  APIException apiException= (APIException) e;
                  int errorCode = apiException.getErrorCode();
                  switch (errorCode){
                        case 1:
                  }
                  getError(apiException.getErrorMsg());
            }else if(e instanceof HttpException){
                  getError(e.getMessage());
            }
            if (compositeDisposable!=null){
                  compositeDisposable.clear();
            }
      }

      @Override
      public void onComplete() {
            if (compositeDisposable!=null){
                  compositeDisposable.clear();
            }
      }

      protected   abstract <T> void getSuccess(T t);
      protected  abstract <T> void getError(T s);
}
