package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class showValue extends HttpServlet {
	public showValue(){
		super();
	}
	public void init(){
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String value ="";
		Service svc = new Service();
		String tableName=  (String) request.getParameter("table_name");
		String attrName = (String) request.getParameter("data_name");
		value = svc.getAttrValue(tableName, attrName);
		
		
		request.getSession().setAttribute("value", value);
		response.sendRedirect("/healthData/DataJson.jsp");
	}
}
