package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Country{

	private String country;
	private String Code2;
	private Integer IndepYear;
	private Double GNPOld;
	private Double LifeExpectancy;
	private Double GNP;
	private String HeadOfState;
	private Integer Capital;
	private String Code;
	private String Name;
	private String LocalName;
	private String GovernmentForm;
	private null Continent;
	private java.sql.TiamStamp last_update;
	private Double SurfaceArea;
	private String Region;
	private Integer Population;
	private null country_id;


	public String getCountry(){
	return country;
	}
	public String getCode2(){
	return Code2;
	}
	public Integer getIndepYear(){
	return IndepYear;
	}
	public Double getGNPOld(){
	return GNPOld;
	}
	public Double getLifeExpectancy(){
	return LifeExpectancy;
	}
	public Double getGNP(){
	return GNP;
	}
	public String getHeadOfState(){
	return HeadOfState;
	}
	public Integer getCapital(){
	return Capital;
	}
	public String getCode(){
	return Code;
	}
	public String getName(){
	return Name;
	}
	public String getLocalName(){
	return LocalName;
	}
	public String getGovernmentForm(){
	return GovernmentForm;
	}
	public null getContinent(){
	return Continent;
	}
	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public Double getSurfaceArea(){
	return SurfaceArea;
	}
	public String getRegion(){
	return Region;
	}
	public Integer getPopulation(){
	return Population;
	}
	public null getCountry_id(){
	return country_id;
	}


	public void setCountry(String country){
	this.country=country;
	}
	public void setCode2(String Code2){
	this.Code2=Code2;
	}
	public void setIndepYear(Integer IndepYear){
	this.IndepYear=IndepYear;
	}
	public void setGNPOld(Double GNPOld){
	this.GNPOld=GNPOld;
	}
	public void setLifeExpectancy(Double LifeExpectancy){
	this.LifeExpectancy=LifeExpectancy;
	}
	public void setGNP(Double GNP){
	this.GNP=GNP;
	}
	public void setHeadOfState(String HeadOfState){
	this.HeadOfState=HeadOfState;
	}
	public void setCapital(Integer Capital){
	this.Capital=Capital;
	}
	public void setCode(String Code){
	this.Code=Code;
	}
	public void setName(String Name){
	this.Name=Name;
	}
	public void setLocalName(String LocalName){
	this.LocalName=LocalName;
	}
	public void setGovernmentForm(String GovernmentForm){
	this.GovernmentForm=GovernmentForm;
	}
	public void setContinent(null Continent){
	this.Continent=Continent;
	}
	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setSurfaceArea(Double SurfaceArea){
	this.SurfaceArea=SurfaceArea;
	}
	public void setRegion(String Region){
	this.Region=Region;
	}
	public void setPopulation(Integer Population){
	this.Population=Population;
	}
	public void setCountry_id(null country_id){
	this.country_id=country_id;
	}


}
