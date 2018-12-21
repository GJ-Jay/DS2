package com.gj.day12recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.gj.day12recyclerview.adapter.NormalAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1、导依赖
        //①初始化组件 类似于listView 的LinearLayoutManager的线性布局,
        // 水平排列：横向滑动scrollview
        //②类似于GridView的网格布局
        //三。 瀑布流StaggeredGridLayoutManager罗列混排布局
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        //先创建线性布局
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);

        NormalAdapter normalAdapter = new NormalAdapter();
        for (int i = 0; i <10 ; i++) {
            User user = new User();
            user.setName("张"+i);
            normalAdapter.addItem(user);
        }
        //设置Adapter
        recyclerView.setAdapter(normalAdapter);
        //设置分隔线
//        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        //设置增加或删除条目的动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
