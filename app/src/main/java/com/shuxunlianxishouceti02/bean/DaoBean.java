package com.shuxunlianxishouceti02.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DaoBean {
    @Id(autoincrement = true)
    private Long Id;
    @Property
    private String title;
    @Property
    private String content;
    @Property
    private String img;
    @Generated(hash = 1170514770)
    public DaoBean(Long Id, String title, String content, String img) {
        this.Id = Id;
        this.title = title;
        this.content = content;
        this.img = img;
    }
    @Generated(hash = 405743142)
    public DaoBean() {
    }
    public Long getId() {
        return this.Id;
    }
    public void setId(Long Id) {
        this.Id = Id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }

}
