package passwordrack.SignUp;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class SignUpDataSaving {
	
	private String url;
	private String username;
	private String password;
	
	public void setDataSubmit(String Name,String Username,String Password,String Email,String Mobileno)
	{
		try {
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			username = "system";
			password = "manager"; 

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connect = DriverManager.getConnection(url,username,password);
			PreparedStatement p = connect.prepareStatement("insert into PasswordRack values(?,?,?,?,?)");
			p.setString(1, Name);
			p.setString(2, Username);
			p.setString(3, Password);
			p.setString(4, Email);
			p.setString(5, Mobileno);
			p.execute();
			
			JOptionPane.showMessageDialog(null, "Saved Data Successfully!!");
	}
	
	catch(Exception e) {
		e.printStackTrace();
		}
	}
}

