package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//购物车
public class Shopcar  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//产品
private Integer productId;
//数量
private Integer num;
//
private Integer customerId;
public Integer getProductId() {return productId;}
public void setProductId(Integer productId) {this.productId = productId;}
public Integer getNum() {return num;}
public void setNum(Integer num) {this.num = num;}
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
}