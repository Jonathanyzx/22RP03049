
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
public class Add_item extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String item = request.getParameter("item");
        if (item != null && !item.isEmpty()) {
            Cookie cookie = new Cookie("cartItem_" + item, item);
            cookie.setMaxAge(30 * 30 * 24); 
            response.addCookie(cookie);
        }
        response.sendRedirect("view_cart");
        }
    }


