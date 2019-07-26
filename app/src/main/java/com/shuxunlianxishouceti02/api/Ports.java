package com.shuxunlianxishouceti02.api;

import com.shuxunlianxishouceti02.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Ports {
    String baseUrl="http://news-at.zhihu.com/";
    @GET("api/4/news/hot")
    Observable<NewsBean>getData();
}
