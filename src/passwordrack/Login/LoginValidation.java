package passwordrack.Login;

import java.sql.*;

import javax.swing.JOptionPane;

public class LoginValidation {
	
	private String url;
	private String username;
	private String password;
	
	public int checkValidation(String Username1, String Password1)
	{
		int i = 0;
		try {
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			username = "system";
			password = "manager";
			
			String sql = "select Username,Password from PasswordRackAccounts where Username = '"+Username1+"' AND Password = '"+Password1+"'";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connect = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connect.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				i=1;
			
			connect.close();
		}
		
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return i;
	}
	
}
