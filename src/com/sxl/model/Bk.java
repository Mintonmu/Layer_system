package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//分类
public class Bk  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//分类名称
private String bkName;
public String getBkName() {return bkName;}
public void setBkName(String bkName) {this.bkName = bkName;}
}