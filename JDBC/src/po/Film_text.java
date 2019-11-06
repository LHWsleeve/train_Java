package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Film_text{

	private null description;
	private Integer film_id;
	private String title;


	public null getDescription(){
	return description;
	}
	public Integer getFilm_id(){
	return film_id;
	}
	public String getTitle(){
	return title;
	}


	public void setDescription(null description){
	this.description=description;
	}
	public void setFilm_id(Integer film_id){
	this.film_id=film_id;
	}
	public void setTitle(String title){
	this.title=title;
	}


}
