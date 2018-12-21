package com.gj.day12recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gj.day12recyclerview.R;
import com.gj.day12recyclerview.User;

import java.util.ArrayList;
import java.util.List;

// ① 创建Adapter
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH>{
    public void addItem(User user) {
        if(user!=null){
            mDatas.add(user);
        }
    }

    //② 创建ViewHolder
    public static class VH extends RecyclerView.ViewHolder{
        public final TextView title;
        private final ImageView avatar;

        public VH(View v) {
            super(v);
            title =  v.findViewById(R.id.title);
            avatar = v.findViewById(R.id.avatar);
        }
    }
    
    private List<User> mDatas;
    public NormalAdapter() {
        //直接写 不能再外边写
        this.mDatas = new ArrayList<>();
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(VH holder, int position) {
        User user = mDatas.get(position);
        holder.title.setText(user.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //item 点击事件
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        return new VH(v);
    }
}
