package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Category{

	private null category_id;
	private java.sql.TiamStamp last_update;
	private String name;


	public null getCategory_id(){
	return category_id;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public String getName(){
	return name;
	}


	public void setCategory_id(null category_id){
	this.category_id=category_id;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setName(String name){
	this.name=name;
	}


}
