package session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SessionListServlet", urlPatterns = { "/servlet/session.SessionListServlet" })
public class SessionListServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String keyParam = request.getParameter("key");
        String valueParam = request.getParameter("value");

        HttpSession session = request.getSession();
        if(keyParam != null){
        	session.setAttribute(keyParam, valueParam);
        }

        response.setContentType("text/html; charset=Windows-31J");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form action=\"\">");
        out.println("key <input type=\"text\" name=\"key\"><br>");
        out.println("value <input type=\"text\" name=\"value\"><br>");
        out.println("<input type=\"submit\" value=\"登録\">");
        out.println("</form>");



        Enumeration names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            String key = (String)names.nextElement();
            Object value = session.getAttribute(key);
            out.println(key + "=" + value + "<br>");
        }

        out.println("</body></html>");
    }

}
