package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Rental{

	private null inventory_id;
	private null staff_id;
	private java.sql.TiamStamp last_update;
	private Date rental_date;
	private null customer_id;
	private Integer rental_id;
	private Date return_date;


	public null getInventory_id(){
	return inventory_id;
	}
	public null getStaff_id(){
	return staff_id;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public Date getRental_date(){
	return rental_date;
	}
	public null getCustomer_id(){
	return customer_id;
	}
	public Integer getRental_id(){
	return rental_id;
	}
	public Date getReturn_date(){
	return return_date;
	}


	public void setInventory_id(null inventory_id){
	this.inventory_id=inventory_id;
	}
	public void setStaff_id(null staff_id){
	this.staff_id=staff_id;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setRental_date(Date rental_date){
	this.rental_date=rental_date;
	}
	public void setCustomer_id(null customer_id){
	this.customer_id=customer_id;
	}
	public void setRental_id(Integer rental_id){
	this.rental_id=rental_id;
	}
	public void setReturn_date(Date return_date){
	this.return_date=return_date;
	}


}
