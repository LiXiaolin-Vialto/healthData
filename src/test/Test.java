package test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import service.Service;

public class Test {
	
	public static void main(String[] args){
		List value=new ArrayList();
		Service svc=new Service();
		value=svc.getAttrList("hypertension_records", "Systolic_pressure");
		
//		Service svc=new Service();
//		String Hypertension_id;
//		int Systolic_pressure;
//		int Diastolic_pressure;
//		double weight;
//		double Constitutional_index;
//		int Daily_smoking_quantity;
//		int Daily_alcohol_consumption;
//		int Sports_time;
//		DecimalFormat df = new DecimalFormat("0.0");
//		for(int i=3;i<30;i++){
//			Hypertension_id = (i<10?"10000"+i:"1000"+i);
//			Systolic_pressure = (int) (90+Math.random()*30);
//			Diastolic_pressure = (int)(50+Math.random()*40);
//			weight =Double.valueOf(df.format(60+Math.random()*10) );
//			Constitutional_index = Double.valueOf(df.format(weight/(1.80*1.80)));
//			Daily_smoking_quantity = (int) (Math.random()*10);
//			Daily_alcohol_consumption = (int)(Math.random()*200);
//			Sports_time = (int)(Math.random()*60)+60;
//			
//			//System.out.println(Hypertension_id+","+Systolic_pressure+","+Diastolic_pressure+","+weight+","
//				//	+Constitutional_index+","+Daily_smoking_quantity+","+Daily_alcohol_consumption+","+Sports_time);
//			svc.insertValue(Hypertension_id, Systolic_pressure, Diastolic_pressure, weight, Constitutional_index, Daily_smoking_quantity, Daily_alcohol_consumption, Sports_time);
//		}
	}
}
