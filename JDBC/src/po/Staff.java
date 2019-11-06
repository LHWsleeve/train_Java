package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Staff{

	private null store_id;
	private String password;
	private null staff_id;
	private java.sql.TiamStamp last_update;
	private null address_id;
	private String last_name;
	private null active;
	private String first_name;
	private java.sql.blob picture;
	private String email;
	private String username;


	public null getStore_id(){
	return store_id;
	}
	public String getPassword(){
	return password;
	}
	public null getStaff_id(){
	return staff_id;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public null getAddress_id(){
	return address_id;
	}
	public String getLast_name(){
	return last_name;
	}
	public null getActive(){
	return active;
	}
	public String getFirst_name(){
	return first_name;
	}
	public java.sql.blob getPicture(){
	return picture;
	}
	public String getEmail(){
	return email;
	}
	public String getUsername(){
	return username;
	}


	public void setStore_id(null store_id){
	this.store_id=store_id;
	}
	public void setPassword(String password){
	this.password=password;
	}
	public void setStaff_id(null staff_id){
	this.staff_id=staff_id;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setAddress_id(null address_id){
	this.address_id=address_id;
	}
	public void setLast_name(String last_name){
	this.last_name=last_name;
	}
	public void setActive(null active){
	this.active=active;
	}
	public void setFirst_name(String first_name){
	this.first_name=first_name;
	}
	public void setPicture(java.sql.blob picture){
	this.picture=picture;
	}
	public void setEmail(String email){
	this.email=email;
	}
	public void setUsername(String username){
	this.username=username;
	}


}
