package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//订单详情
public class Orderlist  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//用户
private Integer customerId;
//订单
private Integer orderId;
//菜品
private Integer productId;
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
public Integer getOrderId() {return orderId;}
public void setOrderId(Integer orderId) {this.orderId = orderId;}
public Integer getProductId() {return productId;}
public void setProductId(Integer productId) {this.productId = productId;}
}