package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//积分兑换产品
public class Jfdh  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//积分产品名称
private String jfName;
//积分数量
private Integer jfCost;
//产品图片
private String jfPic;
public String getJfName() {return jfName;}
public void setJfName(String jfName) {this.jfName = jfName;}
public Integer getJfCost() {return jfCost;}
public void setJfCost(Integer jfCost) {this.jfCost = jfCost;}
public String getJfPic() {return jfPic;}
public void setJfPic(String jfPic) {this.jfPic = jfPic;}
}