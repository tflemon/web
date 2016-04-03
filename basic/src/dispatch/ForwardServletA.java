package dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ForwardServletA", urlPatterns = { "/servlet/dispatch.ForwardServletA" })
public class ForwardServletA extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("call ForwardServletA");

        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/servlet/dispatch.ForwardServletB");

        dispatcher.forward(request, response);
    }
}
