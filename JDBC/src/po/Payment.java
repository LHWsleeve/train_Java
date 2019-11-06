package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Payment{

	private null amount;
	private null payment_id;
	private null staff_id;
	private java.sql.TiamStamp last_update;
	private null customer_id;
	private Date payment_date;
	private Integer rental_id;


	public null getAmount(){
	return amount;
	}
	public null getPayment_id(){
	return payment_id;
	}
	public null getStaff_id(){
	return staff_id;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public null getCustomer_id(){
	return customer_id;
	}
	public Date getPayment_date(){
	return payment_date;
	}
	public Integer getRental_id(){
	return rental_id;
	}


	public void setAmount(null amount){
	this.amount=amount;
	}
	public void setPayment_id(null payment_id){
	this.payment_id=payment_id;
	}
	public void setStaff_id(null staff_id){
	this.staff_id=staff_id;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setCustomer_id(null customer_id){
	this.customer_id=customer_id;
	}
	public void setPayment_date(Date payment_date){
	this.payment_date=payment_date;
	}
	public void setRental_id(Integer rental_id){
	this.rental_id=rental_id;
	}


}
