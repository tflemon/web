package reqattr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet2A", urlPatterns = { "/servlet/reqattr.Servlet2A" })
public class Servlet2A extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        SampleBean bean = new SampleBean();
        bean.setMessage("ぼちぼちでんなぁ");
        request.setAttribute("bean", bean);


        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/servlet/reqattr.Servlet2B");

        dispatcher.forward(request, response);
    }
}
