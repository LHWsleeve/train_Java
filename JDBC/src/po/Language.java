package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Language{

	private java.sql.TiamStamp last_update;
	private String name;
	private null language_id;


	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public String getName(){
	return name;
	}
	public null getLanguage_id(){
	return language_id;
	}


	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setName(String name){
	this.name=name;
	}
	public void setLanguage_id(null language_id){
	this.language_id=language_id;
	}


}
