package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Address{

	private String address;
	private String address2;
	private String phone;
	private String district;
	private java.sql.TiamStamp last_update;
	private null address_id;
	private null location;
	private String postal_code;
	private null city_id;


	public String getAddress(){
	return address;
	}
	public String getAddress2(){
	return address2;
	}
	public String getPhone(){
	return phone;
	}
	public String getDistrict(){
	return district;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public null getAddress_id(){
	return address_id;
	}
	public null getLocation(){
	return location;
	}
	public String getPostal_code(){
	return postal_code;
	}
	public null getCity_id(){
	return city_id;
	}


	public void setAddress(String address){
	this.address=address;
	}
	public void setAddress2(String address2){
	this.address2=address2;
	}
	public void setPhone(String phone){
	this.phone=phone;
	}
	public void setDistrict(String district){
	this.district=district;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setAddress_id(null address_id){
	this.address_id=address_id;
	}
	public void setLocation(null location){
	this.location=location;
	}
	public void setPostal_code(String postal_code){
	this.postal_code=postal_code;
	}
	public void setCity_id(null city_id){
	this.city_id=city_id;
	}


}
