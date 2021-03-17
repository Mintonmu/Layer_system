package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//订单
public class Order  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//用户
private Integer customerId;
//订单详细
private String productDetail;
//订单总价格
private String allPrice;
//状态
private String status;
//订单编号
private String orderNum;
//物流信息
private String pl;
//日期
private Date insertDate;
//
private Integer userId;
//
private String orderDate;
//地址
private String address;
//联系人
private String lxr;
//联系方式
private String lxfs;
//评价
private String pj;
//回复
private String back;
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
public String getProductDetail() {return productDetail;}
public void setProductDetail(String productDetail) {this.productDetail = productDetail;}
public String getAllPrice() {return allPrice;}
public void setAllPrice(String allPrice) {this.allPrice = allPrice;}
public String getStatus() {return status;}
public void setStatus(String status) {this.status = status;}
public String getOrderNum() {return orderNum;}
public void setOrderNum(String orderNum) {this.orderNum = orderNum;}
public String getPl() {return pl;}
public void setPl(String pl) {this.pl = pl;}
public Date getInsertDate() {return insertDate;}
public void setInsertDate(Date insertDate) {this.insertDate = insertDate;}
public Integer getUserId() {return userId;}
public void setUserId(Integer userId) {this.userId = userId;}
public String getOrderDate() {return orderDate;}
public void setOrderDate(String orderDate) {this.orderDate = orderDate;}
public String getAddress() {return address;}
public void setAddress(String address) {this.address = address;}
public String getLxr() {return lxr;}
public void setLxr(String lxr) {this.lxr = lxr;}
public String getLxfs() {return lxfs;}
public void setLxfs(String lxfs) {this.lxfs = lxfs;}
public String getPj() {return pj;}
public void setPj(String pj) {this.pj = pj;}
public String getBack() {return back;}
public void setBack(String back) {this.back = back;}
}