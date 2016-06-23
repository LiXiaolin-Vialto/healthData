package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class ConnectDataBase {
	
	private static String sql_url;
	
	public static Connection con;
	public static PreparedStatement ps;
	public static Statement st;
	public static ResultSet rs;
	public static Connection getMysqlConnection(){
		con=null;
		sql_url = "jdbc:mysql://localhost:3306/healthdata?user=root&characterEncoding=gb2312";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(sql_url);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
}
