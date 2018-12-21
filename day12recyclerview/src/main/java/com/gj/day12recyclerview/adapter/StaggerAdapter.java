package com.gj.day12recyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gj.day12recyclerview.R;
import com.gj.day12recyclerview.User;

import java.util.ArrayList;

public class StaggerAdapter extends RecyclerView.Adapter<StaggerAdapter.VH> {

    Context context;
    private final ArrayList<User> list;

    public StaggerAdapter(Context context) {
        list = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //创建添加视图view
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_stagger_item,
                viewGroup,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        //获取数据
        User user = list.get(i);
        vh.title.setText(user.getName());//赋值
        //加载图片imageview一定要在布局加上android:adjustViewBounds="true"
        //第一个参数context  第二个参数 路径 第三个参数 控件
        Glide.with(context).load(user.getAvatar()).into(vh.avatar);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(User user) {
        if(user!=null){
            list.add(user);
        }
    }

    class VH extends RecyclerView.ViewHolder{

        private final ImageView avatar;
        private final TextView title;

        public VH(@NonNull View itemView) {
            super(itemView);
            //初始化组件
            avatar = itemView.findViewById(R.id.avatar);
            title = itemView.findViewById(R.id.title);
        }
    }
}
