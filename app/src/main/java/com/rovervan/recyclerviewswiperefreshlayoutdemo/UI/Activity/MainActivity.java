package com.rovervan.recyclerviewswiperefreshlayoutdemo.UI.Activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rovervan.recyclerviewswiperefreshlayoutdemo.Bean.VideoInfo;
import com.rovervan.recyclerviewswiperefreshlayoutdemo.R;
import com.rovervan.recyclerviewswiperefreshlayoutdemo.UI.Adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{


    RecyclerView listPost;
    ListAdapter listAdapter;
    List<VideoInfo> data= new ArrayList<VideoInfo>();
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //该方法模拟从服务器请求数据
        requestForData(data);

        listPost = (RecyclerView) findViewById(R.id.recyclerview);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefreshlayout);

        listAdapter = new ListAdapter(this,data);
        listAdapter.openLoadMore(10, true);
        listAdapter.openLoadAnimation();

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listPost.setLayoutManager(linearLayoutManager);
        listPost.setAdapter(listAdapter);

        refreshLayout.setOnRefreshListener(this);

    }

    List<VideoInfo> requestForData(List<VideoInfo> data){

        data.add(new VideoInfo("demo1","cate1","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/red.jpg"));
        data.add(new VideoInfo("demo2","cate2","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/black.jpg"));
        data.add(new VideoInfo("demo3","cate1","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/orange.jpg"));
        data.add(new VideoInfo("demo4","cate2","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/red.jpg"));
        data.add(new VideoInfo("demo5","cate1","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/black.jpg"));
        data.add(new VideoInfo("demo6","cate2","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/orange.jpg"));
        data.add(new VideoInfo("demo7","cate1","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/red.jpg"));
        data.add(new VideoInfo("demo8","cate2","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/black.jpg"));
        data.add(new VideoInfo("demo9","cate1","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/orange.jpg"));
        data.add(new VideoInfo("demo10","cate2","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/red.jpg"));
        data.add(new VideoInfo("demo11","cate1","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/black.jpg"));
        data.add(new VideoInfo("demo12","cate2","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/orange.jpg"));
        return data;
    }

    @Override
    public void onRefresh() {
        List<VideoInfo> data = new ArrayList<VideoInfo>();
        data.add(new VideoInfo("我是刷新出来的","cate1","4'12","http://ossfordemo.oss-cn-shenzhen.aliyuncs.com/android/rvwsrl/orange.jpg"));
        data = requestForData(data);
        listAdapter.setNewData(data);
        listAdapter.openLoadMore(10, true);
        refreshLayout.setRefreshing(false);
    }

}
