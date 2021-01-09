import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount = Float.parseFloat(request.getParameter("discount"));


        float amount = price * discount * 0.01f;
        float discount_price = price - amount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Product Name: "+product+ " </h1>");
        writer.println("<h1> Discount Amount: "+ amount +"</h1>");
        writer.println("<h1> Discount Price: "+ discount_price +"</h1>");
        writer.println("</html>");
    }
}
