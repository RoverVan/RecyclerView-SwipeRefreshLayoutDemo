package com.rovervan.recyclerviewswiperefreshlayoutdemo.Bean;

/**
 * Created by Rover on 16/8/10.
 */
public class VideoInfo {
    private String title;
    private String cate;
    private String length;
    private String imgurl;

    public VideoInfo(String title, String cate, String length, String imgurl) {
        this.title = title;
        this.cate = cate;
        this.length = length;
        this.imgurl = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
