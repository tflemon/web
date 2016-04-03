package fw;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "EncodingFilter", urlPatterns = {"/fw.EncodingFilter"})
public class EncodingFilter implements Filter {

    public void init(FilterConfig filterConfig)
            throws ServletException {
        //何もしない
    }

    public void doFilter(ServletRequest request,
            ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        //System.out.println("calls EncodingFilter#doFitler()");

        request.setCharacterEncoding("Windows-31J");
        chain.doFilter(request, response);
    }

    public void destroy() {
        //何もしない
    }

}
