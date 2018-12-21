package com.gj.day12recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.gj.day12recyclerview.adapter.GridAdapter;
import com.gj.day12recyclerview.adapter.NormalAdapter;

public class RecycleGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //①类似于ListView的linearLayoutManager的线性布局，水平排练:横向滑动ScrollView
        //②类似于GridView的网格布局
        //三。瀑布流StaggeredGridLayoutManager罗列混排布局
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                this,2);
        gridLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);

        recyclerView.setLayoutManager(gridLayoutManager);
        GridAdapter normalAdapter = new GridAdapter();

        for (int i = 0; i <10 ; i++) {
            User user = new User();
            user.setName("张"+i);
            normalAdapter.addItem(user);
        }
        //设置Adapter
        recyclerView.setAdapter(normalAdapter);

        recyclerView.setItemAnimator( new DefaultItemAnimator());
    }
}
