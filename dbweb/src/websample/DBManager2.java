package websample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "DBManager2", urlPatterns = {"/servlet/websample.DBManager2"})
public class DBManager2  {

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


	/**
	 * 更新SQLを発行する
	 */
	public static int simpleUpdate(String sql)
	throws SQLException{

	    Connection con = null;
	    Statement smt = null;
	    try{
	        con = DBManager.getConnection();
	    	smt = con.createStatement();
	    	return smt.executeUpdate(sql);
	    }finally{
            if (smt != null) {
                try {smt.close();} catch (SQLException igonre) {}
            }
            if (con != null) {
                try {con.close();} catch (SQLException igonre) {}
            }
	    }
	}


	public static void main(String[] args) throws Exception {
        Connection con = getConnection();
        System.out.println("con=" + con);
        con.close();
    }

}
