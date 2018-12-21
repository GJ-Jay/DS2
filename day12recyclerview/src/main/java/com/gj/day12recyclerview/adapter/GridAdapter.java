package com.gj.day12recyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gj.day12recyclerview.R;
import com.gj.day12recyclerview.User;

import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.VH> {

    private final ArrayList<User> mDatas;

    public void addItem(User user) {
        if(user!=null){
            mDatas.add(user);
        }
    }


    public GridAdapter() {
        mDatas = new ArrayList<>();
    }

    public static class VH extends RecyclerView.ViewHolder{

        private final TextView title;
        private final ImageView avatar;

        public VH(@NonNull View itemView) {
            super(itemView);
            //初始化子布局组件
            title = itemView.findViewById(R.id.title);
            avatar = itemView.findViewById(R.id.avatar);
        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //注意这一步设置视图
//        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
//                R.layout.recycle_grid_item,viewGroup,false);
        View view = View.inflate(viewGroup.getContext(),R.layout.recycle_grid_item,null);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int position) {
        //获取数据 并设置数据
        User user = mDatas.get(position);
        vh.title.setText(user.getName());
        vh.itemView.setOnClickListener(new View.OnClickListener() {
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


}
