package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "DBManager", urlPatterns = {"/fw.DBManager"})
public class DBManager  {

	public static Connection getConnection() {
		try {
        /*	InitialContext ctx = new InitialContext();
        	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myds");
        	Connection con = ds.getConnection();*/
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

	    System.out.println(sql);

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


	/**
	 * 検索SQLを発行して、結果をオブジェクトのListに入れて返す。
	 * ResultSetからListへの変換は、ResultSetBeanMappingが行う
	 */
	public static List simpleFind(String sql, ResultSetBeanMapping mapping)
	throws SQLException{

		Connection con = null;
	    Statement smt = null;
	    try{
	        con = DBManager.getConnection();
	        smt = con.createStatement();
	        ResultSet rs = smt.executeQuery(sql);

	        List list = new ArrayList();
	        while(rs.next()) {

	            Object bean = mapping.createFromResultSet(rs);

	            list.add(bean);
	        }

	        return list;

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