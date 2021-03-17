package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//收藏
public class Sc  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//用户
private Integer customerId;
//产品
private Integer productId;
//日期
private Date insertDate;
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
public Integer getProductId() {return productId;}
public void setProductId(Integer productId) {this.productId = productId;}
public Date getInsertDate() {return insertDate;}
public void setInsertDate(Date insertDate) {this.insertDate = insertDate;}
}