package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//信息交流
public class Message  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//用户
private Integer customerId;
//内容
private String messageContent;
//
private Integer types;
//时间
private Date insertDate;
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
public String getMessageContent() {return messageContent;}
public void setMessageContent(String messageContent) {this.messageContent = messageContent;}
public Integer getTypes() {return types;}
public void setTypes(Integer types) {this.types = types;}
public Date getInsertDate() {return insertDate;}
public void setInsertDate(Date insertDate) {this.insertDate = insertDate;}
}