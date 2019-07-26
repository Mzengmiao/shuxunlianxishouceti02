package com.shuxunlianxishouceti02.presenter;

import com.shuxunlianxishouceti02.bean.NewsBean;
import com.shuxunlianxishouceti02.callback.CallBack;
import com.shuxunlianxishouceti02.molder.ImpMolder;
import com.shuxunlianxishouceti02.view.NewsView;

public class ImpPresenter implements NewPresenter, CallBack<NewsBean, String> {
    private ImpMolder impMolder;
    private NewsView newsView;

    public ImpPresenter(ImpMolder impMolder, NewsView newsView) {
        this.impMolder = impMolder;
        this.newsView = newsView;
    }

    @Override
    public void getData() {
        if (impMolder!=null){
            impMolder.getData(this);
        }
    }

    @Override
    public void Sueccss(NewsBean newsBean) {
        if (newsView!=null){
            newsView.Sueccss(newsBean);
        }
    }

    @Override
    public void Fail(String s) {
        if (newsView!=null){
            newsView.Fail(s);
        }
    }
}
