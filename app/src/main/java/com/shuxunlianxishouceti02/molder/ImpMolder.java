package com.shuxunlianxishouceti02.molder;

import com.shuxunlianxishouceti02.api.Ports;
import com.shuxunlianxishouceti02.bean.NewsBean;
import com.shuxunlianxishouceti02.callback.CallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpMolder implements NewMolder {
    @Override
    public void getData(final CallBack<NewsBean, String> callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Ports.baseUrl)
                .build();
        Ports ports = retrofit.create(Ports.class);
        Observable<NewsBean> data = ports.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        if (newsBean!=null){
                            callBack.Sueccss(newsBean);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.Fail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
