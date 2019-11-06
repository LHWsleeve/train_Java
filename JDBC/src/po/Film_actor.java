package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Film_actor{

	private java.sql.TiamStamp last_update;
	private null actor_id;
	private null film_id;


	public java.sql.TiamStamp getLast_update(){
	return last_update;
	}
	public null getActor_id(){
	return actor_id;
	}
	public null getFilm_id(){
	return film_id;
	}


	public void setLast_update(java.sql.TiamStamp last_update){
	this.last_update=last_update;
	}
	public void setActor_id(null actor_id){
	this.actor_id=actor_id;
	}
	public void setFilm_id(null film_id){
	this.film_id=film_id;
	}


}
