package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Store{

	private null store_id;
	private null manager_staff_id;
	private java.sql.TiamStamp last_update;
	private null address_id;


	public null getStore_id(){
	return store_id;
	}
	public null getManager_staff_id(){
	return manager_staff_id;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public null getAddress_id(){
	return address_id;
	}


	public void setStore_id(null store_id){
	this.store_id=store_id;
	}
	public void setManager_staff_id(null manager_staff_id){
	this.manager_staff_id=manager_staff_id;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setAddress_id(null address_id){
	this.address_id=address_id;
	}


}
