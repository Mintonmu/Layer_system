package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//消息
public class Xiaoxi  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//用户
private Integer customerId;
//标题
private String title;
//内容
private String content;
//日期
private Date insertDate;
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
public String getTitle() {return title;}
public void setTitle(String title) {this.title = title;}
public String getContent() {return content;}
public void setContent(String content) {this.content = content;}
public Date getInsertDate() {return insertDate;}
public void setInsertDate(Date insertDate) {this.insertDate = insertDate;}
}