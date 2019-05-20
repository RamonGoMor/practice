import java.sql.*;
class test{
	public static void main(String args[]){ 
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver");  
			//Note: '?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC' is used to fix a timezone error
			Connection con=DriverManager.getConnection(  "jdbc:mysql://nexus.ramongm.com:3306/cs4530?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","cs4530user","databasesystems");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from emp");
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println(String.format("\n%-10s%-20s%-20s\n",rsmd.getColumnLabel(1),rsmd.getColumnLabel(2),rsmd.getColumnLabel(3)));
			while(rs.next())
				System.out.println(String.format("%-10d%-20s%-20s",rs.getInt(1),rs.getString(2),rs.getString(3)));
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}