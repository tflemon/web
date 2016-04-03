package websample;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SelectServlet3", urlPatterns = {"/servlet/websample.SelectServlet3"})
public class SelectServlet3 extends HttpServlet{

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        AccountDAO dao = new AccountDAO();
        List list = dao.findAll();

		request.setAttribute("list", list);

        request.getRequestDispatcher("/select.jsp")
		    .forward(request, response);
    }
}
