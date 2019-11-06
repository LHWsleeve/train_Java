package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Inventory{

	private null store_id;
	private null inventory_id;
	private java.sql.TiamStamp last_update;
	private null film_id;


	public null getStore_id(){
	return store_id;
	}
	public null getInventory_id(){
	return inventory_id;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public null getFilm_id(){
	return film_id;
	}


	public void setStore_id(null store_id){
	this.store_id=store_id;
	}
	public void setInventory_id(null inventory_id){
	this.inventory_id=inventory_id;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setFilm_id(null film_id){
	this.film_id=film_id;
	}


}
