package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.*;
import jdbc.ConnectDataBase;

public class Service {
	private Connection dbCon;
	private Statement st;
	private ResultSet rs;
	private String sql;
	private List list;
	
	public String getAttrValue(String tableName,String attrName){
		String value = "";
		dbCon = ConnectDataBase.getMysqlConnection();
		try {
			st = dbCon.createStatement();
			sql = "select "+attrName+" from "+tableName;
			rs = st.executeQuery(sql);
			rs.next();
			value = rs.getString(attrName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	public List getAttrList(String tableName,String attrName){
		List values = new ArrayList();
		dbCon = ConnectDataBase.getMysqlConnection();
		sql = "select "+attrName+" from "+tableName;
		try {
			st = dbCon.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				values.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return values;
	}
	
	public void insertValue(String Hypertension_id,int Systolic_pressure, int Diastolic_pressure,double weight,double Constitutional_index,
			int Daily_smoking_quantity,int Daily_alcohol_consumption,int Sports_time)
	{
		String sql = "insert into hypertension_records(Health_record_id,Hypertension_id,Systolic_pressure,Diastolic_pressure,weight,Constitutional_index,Daily_smoking_quantity,Daily_alcohol_consumption,Sports_time)"
				+ " values('100001',"+Hypertension_id+","+Systolic_pressure+","+Diastolic_pressure+","+weight+","
				+Constitutional_index+","+Daily_smoking_quantity+","+Daily_alcohol_consumption+","+Sports_time+");";
		dbCon = ConnectDataBase.getMysqlConnection();
		try {
			st = dbCon.createStatement();
			int s = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
