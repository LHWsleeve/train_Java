package po;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Job_grades{

	private String grade_level;
	private Integer lowest_sal;
	private Integer highest_sal;


	public String getGrade_level(){
	return grade_level;
	}
	public Integer getLowest_sal(){
	return lowest_sal;
	}
	public Integer getHighest_sal(){
	return highest_sal;
	}


	public void setGrade_level(String grade_level){
	this.grade_level=grade_level;
	}
	public void setLowest_sal(Integer lowest_sal){
	this.lowest_sal=lowest_sal;
	}
	public void setHighest_sal(Integer highest_sal){
	this.highest_sal=highest_sal;
	}


}
