import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class view_cart extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<h1> Shopping Cart</h1>");
        out.println("<ul>");
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().startsWith("cartItem_")) {
                    out.println("<li>" + cookie.getValue() + " <a href='Remove_cart?item=" + cookie.getValue() + "'>Remove</a></li>");
                }
            }
        }
        
        out.println("</ul>");
        out.println("<a href='clear_cart'>Clear Cart</a>");
        out.println("<a href='index.html'>Add next item</a>");
    }

}
