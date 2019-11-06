package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Actor{

	private java.sql.TiamStamp last_update;
	private String last_name;
	private null actor_id;
	private String first_name;


	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public String getLast_name(){
	return last_name;
	}
	public null getActor_id(){
	return actor_id;
	}
	public String getFirst_name(){
	return first_name;
	}


	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setLast_name(String last_name){
	this.last_name=last_name;
	}
	public void setActor_id(null actor_id){
	this.actor_id=actor_id;
	}
	public void setFirst_name(String first_name){
	this.first_name=first_name;
	}


}
