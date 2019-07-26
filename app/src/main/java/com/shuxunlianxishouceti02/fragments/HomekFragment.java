package com.shuxunlianxishouceti02.fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuxunlianxishouceti02.Main2Activity;
import com.shuxunlianxishouceti02.R;
import com.shuxunlianxishouceti02.adapter.HomeAdapter;
import com.shuxunlianxishouceti02.bean.DaoBean;
import com.shuxunlianxishouceti02.bean.NewsBean;
import com.shuxunlianxishouceti02.molder.ImpMolder;
import com.shuxunlianxishouceti02.presenter.ImpPresenter;
import com.shuxunlianxishouceti02.utils.DaoUtils;
import com.shuxunlianxishouceti02.view.NewsView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomekFragment extends Fragment implements NewsView<NewsBean, String>, HomeAdapter.OnItemClickListener, HomeAdapter.OnItemLongClickListener {


    @BindView(R.id.home_rlw)
    RecyclerView homeRlw;
    Unbinder unbinder;
    private ArrayList<NewsBean.RecentBean> mlist = new ArrayList<>();
    private HomeAdapter adapter;

    public HomekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_homek, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        initData();
        return inflate;
    }

    private void initData() {
        ImpPresenter impPresenter = new ImpPresenter(new ImpMolder(), this);
        impPresenter.getData();
    }

    private void initView() {
        homeRlw.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HomeAdapter(getActivity(), mlist);
        homeRlw.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void Sueccss(NewsBean newsBean) {
        mlist.addAll(newsBean.getRecent());
        adapter.setMlist(mlist);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void Fail(String s) {
        Log.e("TAG", s);
    }

    @Override
    public void OnItem(int i) {
        NewsBean.RecentBean recentBean = mlist.get(i);
        Intent intent = new Intent(getActivity(), Main2Activity.class);
        intent.putExtra("img", recentBean.getThumbnail());
        intent.putExtra("title", recentBean.getTitle());
        intent.putExtra("content", recentBean.getUrl());
        startActivity(intent);
    }

    @Override
    public void OnLongItem(int i) {
        final NewsBean.RecentBean recentBean = mlist.get(i);
        new AlertDialog.Builder(getActivity())
                .setTitle("温馨提示")
                .setMessage("是否添加到数据库")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        DaoBean daoBean = new DaoBean();
                        daoBean.setId(null);
                        daoBean.setTitle(recentBean.getTitle());
                        daoBean.setContent(recentBean.getUrl());
                        daoBean.setImg(recentBean.getThumbnail());
                        DaoUtils.getDaoUtils().insert(daoBean);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("no", null)
                .show();
    }
}
