package com.shuxunlianxishouceti02.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shuxunlianxishouceti02.R;
import com.shuxunlianxishouceti02.adapter.CollectAdapter;
import com.shuxunlianxishouceti02.bean.DaoBean;
import com.shuxunlianxishouceti02.utils.DaoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends Fragment {


    @BindView(R.id.collect_rlw)
    RecyclerView collectRlw;
    Unbinder unbinder;
    private ArrayList<DaoBean>mList=new ArrayList<>();
    private CollectAdapter adapter;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            initData();
        }else {
            mList.clear();
        }
    }



    public CollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_collect, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }
    private void initData() {
        List<DaoBean> query = DaoUtils.getDaoUtils().query();
        mList.addAll(query);
        adapter.setMlist(mList);
        adapter.notifyDataSetChanged();
    }
    private void initView() {
        collectRlw.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CollectAdapter(getActivity(), mList);
        collectRlw.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
