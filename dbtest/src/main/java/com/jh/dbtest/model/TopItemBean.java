package com.jh.dbtest.model;


import org.litepal.crud.LitePalSupport;

/**
 * Created by 1 on 2017/10/17.
 */

public class TopItemBean extends LitePalSupport {
    /**
     * uniquekey : 8bf358dcbb02c0392e25428ec6f80707
     * title : 贵阳老太坐车丢十万元，民警调近百监控全城走访三天两夜找回
     * date : 2017-10-17 09:45
     * category : 头条
     * author_name : 贵阳晚报
     * url : http://mini.eastday.com/mobile/171017094556300.html
     * thumbnail_pic_s : http://03.imgmini.eastday.com/mobile/20171017/20171017094556_e03c77b9924d77e2f4d18b9128e7a574_4_mwpm_03200403.jpg
     * thumbnail_pic_s02 : http://03.imgmini.eastday.com/mobile/20171017/20171017094556_e03c77b9924d77e2f4d18b9128e7a574_3_mwpm_03200403.jpg
     * thumbnail_pic_s03 : http://03.imgmini.eastday.com/mobile/20171017/20171017094556_e03c77b9924d77e2f4d18b9128e7a574_1_mwpm_03200403.jpg
     */

    private String uniquekey;
    private String title;
    private String date;
    private String category;
    private String author_name;
    private String url;
    private String thumbnail_pic_s;
    private String thumbnail_pic_s02;
    private String thumbnail_pic_s03;

    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
    }

    public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
    }

    public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
    }

    public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
    }
}