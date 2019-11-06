package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Customer{

	private null store_id;
	private java.sql.TiamStamp last_update;
	private null address_id;
	private String last_name;
	private null active;
	private null customer_id;
	private Date create_date;
	private String first_name;
	private String email;


	public null getStore_id(){
	return store_id;
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
	public null getCustomer_id(){
	return customer_id;
	}
	public Date getCreate_date(){
	return create_date;
	}
	public String getFirst_name(){
	return first_name;
	}
	public String getEmail(){
	return email;
	}


	public void setStore_id(null store_id){
	this.store_id=store_id;
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
	public void setCustomer_id(null customer_id){
	this.customer_id=customer_id;
	}
	public void setCreate_date(Date create_date){
	this.create_date=create_date;
	}
	public void setFirst_name(String first_name){
	this.first_name=first_name;
	}
	public void setEmail(String email){
	this.email=email;
	}


}
