package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//库存
public class Kc  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//产品
private Integer productId;
//库存数量
private Integer kcNum;
//日期
private Date insertDate;
public Integer getProductId() {return productId;}
public void setProductId(Integer productId) {this.productId = productId;}
public Integer getKcNum() {return kcNum;}
public void setKcNum(Integer kcNum) {this.kcNum = kcNum;}
public Date getInsertDate() {return insertDate;}
public void setInsertDate(Date insertDate) {this.insertDate = insertDate;}
}