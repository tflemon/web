package websample;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "DBManager", urlPatterns = {"/servlet/websample.DBManager"})
public class DBManager  {

	public static Connection getConnection() {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    Connection con = DriverManager.getConnection(
		    		"jdbc:mysql://localhost/test", "root", "password");

		    return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public static void main(String[] args) throws Exception {
        Connection con = getConnection();
        System.out.println("con=" + con);
        con.close();
    }

}
