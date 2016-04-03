package reqattr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletB", urlPatterns = { "/servlet/reqattr.ServletB" })
public class ServletB extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String message = (String)request.getAttribute("message");

        response.setContentType("text/plain; charset=Windows-31J");
        response.getWriter().println("message=" + message);
    }

}
