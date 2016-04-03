package dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ForwardServlet2", urlPatterns = { "/servlet/dispatch.ForwardServlet2" })
public class ForwardServlet2 extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request
                //.getRequestDispatcher("/forward_ok.jsp");
        		.getRequestDispatcher("/angular_test.html");

        dispatcher.forward(request, response);
    }
}
