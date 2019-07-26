package com.shuxunlianxishouceti02.molder;

import com.shuxunlianxishouceti02.bean.NewsBean;
import com.shuxunlianxishouceti02.callback.CallBack;

public interface NewMolder {
    void getData(CallBack<NewsBean,String> callBack);
}
