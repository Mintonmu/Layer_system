package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//收货地址
public class Address  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//用户
private Integer customerId;
//省
private String province;
//市
private String city;
//区
private String area;
//电话
private String phone;
//联系人
private String lxr;
//详细地址
private String xxdz;
public Integer getCustomerId() {return customerId;}
public void setCustomerId(Integer customerId) {this.customerId = customerId;}
public String getProvince() {return province;}
public void setProvince(String province) {this.province = province;}
public String getCity() {return city;}
public void setCity(String city) {this.city = city;}
public String getArea() {return area;}
public void setArea(String area) {this.area = area;}
public String getPhone() {return phone;}
public void setPhone(String phone) {this.phone = phone;}
public String getLxr() {return lxr;}
public void setLxr(String lxr) {this.lxr = lxr;}
public String getXxdz() {return xxdz;}
public void setXxdz(String xxdz) {this.xxdz = xxdz;}
}