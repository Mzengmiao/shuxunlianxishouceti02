package com.shuxunlianxishouceti02.utils;

import com.shuxunlianxishouceti02.app.NewApp;
import com.shuxunlianxishouceti02.bean.DaoBean;
import com.shuxunlianxishouceti02.db.DaoBeanDao;
import com.shuxunlianxishouceti02.db.DaoMaster;
import com.shuxunlianxishouceti02.db.DaoSession;

import java.util.List;

public class DaoUtils {
    private static DaoUtils daoUtils;
    private final DaoBeanDao daoBeanDao;

    public DaoUtils() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(NewApp.getNewApp(), "Newaaaa.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        daoBeanDao = daoSession.getDaoBeanDao();
    }

    public static DaoUtils getDaoUtils() {
        if (daoUtils==null){
            synchronized (DaoUtils.class){
                if (daoUtils==null){
                    daoUtils=new DaoUtils();
                }
            }
        }
        return daoUtils;
    }
    public long insert(DaoBean daoBean){
        if (!has(daoBean)){
            return daoBeanDao.insert(daoBean);
        }
        return -1;
    }
    public List<DaoBean> query(){
        return daoBeanDao.queryBuilder().list();
    }
    public  boolean has(DaoBean daoBean){
        List<DaoBean> list = daoBeanDao.queryBuilder().where(DaoBeanDao.Properties.Title.eq(daoBean.getTitle())).list();
        if (list.size()>0){
            return true;
        }
        return false;
    }
}
