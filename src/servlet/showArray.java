package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Service;

public class showArray extends HttpServlet {
	public showArray(){
		super();
	}
	public void init(){
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List value = new ArrayList();
		Service svc = new Service();
		String tableName=  (String) request.getParameter("table_name");
		String attrName = (String) request.getParameter("data_name");
		value = svc.getAttrList(tableName, attrName);
		
		request.getSession().setAttribute("value", value);
		response.sendRedirect("/healthData/DataArray.jsp");
	}
}
