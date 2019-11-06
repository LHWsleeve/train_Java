package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Person{

	private java.sql.TiamStamp date;
	private String name;
	private Integer Id;
	private null MyInfo;
	private Integer age;


	public java.sql.TiamStamp getDate(){
	return date;
	}
	public String getName(){
	return name;
	}
	public Integer getId(){
	return Id;
	}
	public null getMyInfo(){
	return MyInfo;
	}
	public Integer getAge(){
	return age;
	}


	public void setDate(java.sql.TiamStamp date){
	this.date=date;
	}
	public void setName(String name){
	this.name=name;
	}
	public void setId(Integer Id){
	this.Id=Id;
	}
	public void setMyInfo(null MyInfo){
	this.MyInfo=MyInfo;
	}
	public void setAge(Integer age){
	this.age=age;
	}


}
