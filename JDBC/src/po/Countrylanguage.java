package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Countrylanguage{

	private String Language;
	private Double Percentage;
	private null IsOfficial;
	private String CountryCode;


	public String getLanguage(){
	return Language;
	}
	public Double getPercentage(){
	return Percentage;
	}
	public null getIsOfficial(){
	return IsOfficial;
	}
	public String getCountryCode(){
	return CountryCode;
	}


	public void setLanguage(String Language){
	this.Language=Language;
	}
	public void setPercentage(Double Percentage){
	this.Percentage=Percentage;
	}
	public void setIsOfficial(null IsOfficial){
	this.IsOfficial=IsOfficial;
	}
	public void setCountryCode(String CountryCode){
	this.CountryCode=CountryCode;
	}


}
