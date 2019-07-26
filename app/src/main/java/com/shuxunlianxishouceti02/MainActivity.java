package com.shuxunlianxishouceti02;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.shuxunlianxishouceti02.adapter.FragmentVpAdapter;
import com.shuxunlianxishouceti02.fragments.CollectFragment;
import com.shuxunlianxishouceti02.fragments.HomekFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
//曾淼
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main1_vp)
    ViewPager main1Vp;
    @BindView(R.id.main1_tab)
    TabLayout main1Tab;
    private ArrayList<Fragment> fragments;
    private FragmentVpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        fragments.add(new HomekFragment());
        fragments.add(new CollectFragment());
        adapter = new FragmentVpAdapter(getSupportFragmentManager(), fragments);
        main1Vp.setAdapter(adapter);
        main1Tab.addTab(main1Tab.newTab().setText("我的"));
        main1Tab.addTab(main1Tab.newTab().setText("收藏"));
        main1Tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                main1Vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        TabLayout.TabLayoutOnPageChangeListener listener = new TabLayout.TabLayoutOnPageChangeListener(main1Tab);
        main1Vp.addOnPageChangeListener(listener);
    }
}
