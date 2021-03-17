package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//我的消息
public class Wdxx  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//我
private Integer customerId;
//标题
private String title;
//图片
private String pic;
//内容
private String content;
//赞
private Integer zan;
//发布日期
private Date insertDate;
//游客是否可见
private String nologin;
//
private Integer bkId;
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
public String getTitle() {return title;}
public void setTitle(String title) {this.title = title;}
public String getPic() {return pic;}
public void setPic(String pic) {this.pic = pic;}
public String getContent() {return content;}
public void setContent(String content) {this.content = content;}
public Integer getZan() {return zan;}
public void setZan(Integer zan) {this.zan = zan;}
public Date getInsertDate() {return insertDate;}
public void setInsertDate(Date insertDate) {this.insertDate = insertDate;}
public String getNologin() {return nologin;}
public void setNologin(String nologin) {this.nologin = nologin;}
public Integer getBkId() {return bkId;}
public void setBkId(Integer bkId) {this.bkId = bkId;}
}