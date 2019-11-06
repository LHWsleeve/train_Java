package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class City{

	private String city;
	private java.sql.TiamStamp last_update;
	private Integer Population;
	private Integer ID;
	private String CountryCode;
	private String District;
	private null country_id;
	private null city_id;
	private String Name;


	public String getCity(){
	return city;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public Integer getPopulation(){
	return Population;
	}
	public Integer getID(){
	return ID;
	}
	public String getCountryCode(){
	return CountryCode;
	}
	public String getDistrict(){
	return District;
	}
	public null getCountry_id(){
	return country_id;
	}
	public null getCity_id(){
	return city_id;
	}
	public String getName(){
	return Name;
	}


	public void setCity(String city){
	this.city=city;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setPopulation(Integer Population){
	this.Population=Population;
	}
	public void setID(Integer ID){
	this.ID=ID;
	}
	public void setCountryCode(String CountryCode){
	this.CountryCode=CountryCode;
	}
	public void setDistrict(String District){
	this.District=District;
	}
	public void setCountry_id(null country_id){
	this.country_id=country_id;
	}
	public void setCity_id(null city_id){
	this.city_id=city_id;
	}
	public void setName(String Name){
	this.Name=Name;
	}


}
