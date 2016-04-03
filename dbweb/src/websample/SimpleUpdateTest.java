package websample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SimpleUpdateTest", urlPatterns = {"/servlet/websample.SimpleUpdateTest"})
public class SimpleUpdateTest extends HttpServlet{

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

      	try{
        	String sql = "UPDATE ACCOUNT"
        		+ " SET MONEY = 5000";

        	int count = DBManager2.simpleUpdate(sql);

            response.setContentType("text/plain; charset=Windows-31J");
            PrintWriter out = response.getWriter();

            out.println("更新しました。件数=" + count);

      	}catch(SQLException e){
    		throw new ServletException(e);
    	}
    }
}
