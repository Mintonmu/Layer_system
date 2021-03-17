package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//标签
public class Bq  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//标签
private String bqName;
public String getBqName() {return bqName;}
public void setBqName(String bqName) {this.bqName = bqName;}
}