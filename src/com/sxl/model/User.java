package com.sxl.model;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

//普通员工
public class User  extends BaseBean{
//主键
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
//账号
private String username;
//密码
private String password;
//姓名
private String name;
//擅长领域
private String gh;
//手机
private String mobile;
public String getUsername() {return username;}
public void setUsername(String username) {this.username = username;}
public String getPassword() {return password;}
public void setPassword(String password) {this.password = password;}
public String getName() {return name;}
public void setName(String name) {this.name = name;}
public String getGh() {return gh;}
public void setGh(String gh) {this.gh = gh;}
public String getMobile() {return mobile;}
public void setMobile(String mobile) {this.mobile = mobile;}
}