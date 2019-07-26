package com.shuxunlianxishouceti02.callback;

public interface CallBack<T,F>{
    void Sueccss(T t);
    void Fail(F f);
}
