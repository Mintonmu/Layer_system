package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//评论
public class Pinglun  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//评论信息
private Integer wdxxId;
//评论人
private Integer customerId;
//评论内容
private String content;
//评论日期
private Date insertDate;
public Integer getWdxxId() {return wdxxId;}
public void setWdxxId(Integer wdxxId) {this.wdxxId = wdxxId;}
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
public String getContent() {return content;}
public void setContent(String content) {this.content = content;}
public Date getInsertDate() {return insertDate;}
public void setInsertDate(Date insertDate) {this.insertDate = insertDate;}
}