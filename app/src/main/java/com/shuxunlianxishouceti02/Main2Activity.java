package com.shuxunlianxishouceti02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.main2_img)
    ImageView main2Img;
    @BindView(R.id.main2_title)
    TextView main2Title;
    @BindView(R.id.main2_content)
    TextView main2Content;
    private String img;
    private String title;
    private String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        img = intent.getStringExtra("img");
        title = intent.getStringExtra("title");
        content = intent.getStringExtra("content");
        initView();
        //svsdhvndj
    }

    private void initView() {
        main2Title.setText(title);
        main2Content.setText(content);
        Glide.with(Main2Activity.this).load(img).into(main2Img);
    }
}
