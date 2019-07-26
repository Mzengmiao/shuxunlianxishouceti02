package com.shuxunlianxishouceti02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shuxunlianxishouceti02.R;
import com.shuxunlianxishouceti02.bean.DaoBean;

import java.util.ArrayList;

public class CollectAdapter extends RecyclerView.Adapter<CollectAdapter.ViewHolder> {
    private Context context;
    private ArrayList<DaoBean> mlist;

    public CollectAdapter(Context context, ArrayList<DaoBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    public void setMlist(ArrayList<DaoBean> mlist) {
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.home_item, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.title.setText(mlist.get(i).getTitle());
        viewHolder.content.setText(mlist.get(i).getContent());
        Glide.with(context).load(mlist.get(i).getImg()).into(viewHolder.img);

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView title;
        private final TextView content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
        }
    }

}
