package com.gj.day12recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.gj.day12recyclerview.adapter.GridAdapter;
import com.gj.day12recyclerview.adapter.StaggerAdapter;

public class RecycleStaggerActivity extends AppCompatActivity {

    private StaggerAdapter staggerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //①类似于ListView的linearLayoutManager的线性布局，水平排练:横向滑动ScrollView
        //②类似于GridView的网格布局
        //三。瀑布流StaggeredGridLayoutManager罗列混排布局
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(
              2,StaggeredGridLayoutManager.VERTICAL  );

        //设置布局管理器
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        staggerAdapter = new StaggerAdapter(this);

        String[] avatarArray = new String[]{
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544442373811&di=848a4182d8f35674317cd145fa09fa88&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Fface%2Faf5068ab80526f8d4a9acb8907277b534c633d07.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1545037250&di=866ab32daebc69e66bcb041b97340fb7&imgtype=jpg&er=1&src=http%3A%2F%2Fhellorfimg.zcool.cn%2Fpreview%2F293300162.jpg",
                "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1544452449351&di=9063f14cfc8d124e7ed08c635f677d19&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Ff9dcd100baa1cd11a438a2e9b312c8fcc2ce2d69.jpg"};

        for (int i = 0; i <30 ; i++) {
            User user = new User();
            user.setName("张"+i);
            user.setAvatar(avatarArray[i%avatarArray.length]);
            staggerAdapter.addItem(user);
        }
        //设置Adapter
        recyclerView.setAdapter(staggerAdapter);

        recyclerView.setItemAnimator( new DefaultItemAnimator());
    }
}
