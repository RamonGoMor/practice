import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pro implements ActionListener{
	
	private JTextArea jta;
	private JLabel jl;
	
	public pro(){
		JFrame jf = new JFrame("Pro Program");
		
		jf.setSize(500,500);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
		jl = new JLabel("Output");
		//jp.add(jl);
		jta = new JTextArea(5,50);
		JScrollPane scrollPane1 = new JScrollPane(jta);
		JScrollPane scrollPane = new JScrollPane(jl);
		jp.add(scrollPane);
		jp.add(scrollPane1);
		JButton jb = new JButton("Submit");
		jb.addActionListener(this);
		jp.add(jb);
		jf.add(jp);
		
		
		
		jf.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		String str = "<html><table>";
		try{ 
			Class.forName("com.mysql.cj.jdbc.Driver");  
			//Note: '?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC' is used to fix a timezone error
			//Connection con=DriverManager.getConnection(  "jdbc:mysql://nexus.ramongm.com:3306/cs4530?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","cs4530user","databasesystems");
			Connection con=DriverManager.getConnection(  "jdbc:mysql://10.68.140.245:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","d8tmc","d8tmc");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(jta.getText());
			ResultSetMetaData rsmd=rs.getMetaData();
			int col_count = rsmd.getColumnCount();
			
			for(int x = 1 ; x <= col_count; x++){
				if(x == col_count){
					str += "<td>"+rsmd.getColumnLabel(x)+"</td></tr>";
				}else if(x == 1){
					str += "<tr><td>"+rsmd.getColumnLabel(x)+"</td>";
				}else{
					str += "<td>"+rsmd.getColumnLabel(x)+"</td>";
				}
			}
			//str += String.format("%-10s%-20s%-20s<br />",rsmd.getColumnLabel(1),rsmd.getColumnLabel(2),rsmd.getColumnLabel(3));
			while(rs.next()){
				for(int x = 1 ; x <= col_count; x++){
					if(x == col_count){
						str += "<td>"+rs.getString(x)+"</td></tr>";
					}else if(x == 1){
						str += "<tr><td>"+rs.getString(x)+"</td>";
					}else{
						str += "<td>"+rs.getString(x)+"</td>";
					}
				}
			}
				//str += String.format("%-10d%-20s%-20s<br/>",rs.getInt(1),rs.getString(2),rs.getString(3));
			con.close();
			str += "</table></html>";
			jl.setText(str);
		}catch(Exception e){ jl.setText(e.toString());}
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(()->new pro());
	}
}