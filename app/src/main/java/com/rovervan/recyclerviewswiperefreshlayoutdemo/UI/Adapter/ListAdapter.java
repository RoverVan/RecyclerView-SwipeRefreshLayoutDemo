package com.rovervan.recyclerviewswiperefreshlayoutdemo.UI.Adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rovervan.recyclerviewswiperefreshlayoutdemo.Bean.VideoInfo;
import com.rovervan.recyclerviewswiperefreshlayoutdemo.R;

import java.util.List;

/**
 * Created by Rover on 16/8/10.
 */
public class ListAdapter extends BaseQuickAdapter<VideoInfo> {

    public ListAdapter(Context context,List<VideoInfo> data) {
        super(R.layout.item_list,data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, VideoInfo videoInfo) {

        baseViewHolder.setText(R.id.title,videoInfo.getTitle());//设置标题
        String cate_and_length = videoInfo.getCate()+"/"+videoInfo.getLength();
        baseViewHolder.setText(R.id.cate_and_length,cate_and_length);//设置分类和时长
        Glide.with(mContext)
                .load(videoInfo.getImgurl())
                .error(android.R.color.black)
                .crossFade()
                .into((ImageView) baseViewHolder.getView(R.id.imageview));//设置封面图片
    }
}
