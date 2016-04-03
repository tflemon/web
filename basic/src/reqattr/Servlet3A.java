package reqattr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet3A", urlPatterns = { "/servlet/reqattr.Servlet3A" })
public class Servlet3A extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        SampleBean bean = new SampleBean();
        bean.setMessage("そうでっか");
        request.setAttribute("bean", bean);

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/result.jsp");

        dispatcher.forward(request, response);
    }
}
