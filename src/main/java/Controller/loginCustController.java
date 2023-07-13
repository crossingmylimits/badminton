package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.CustDAO;
import model.CustomerBean;

@WebServlet("/loginCustController")
public class loginCustController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustDAO dao;

    public loginCustController() {
        super();
        dao = new CustDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String CustName = request.getParameter("CustName");
        String CustPass = request.getParameter("CustPass");

        // Authenticate the customer
        CustomerBean customer = dao.authenticateCustomer(CustName, CustPass);

        if (customer != null) {
            // Customer authentication successful
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);

            // Redirect to the home page or a success page
            response.sendRedirect("index.html");
        } else {
            // Customer authentication failed
            // Redirect back to the login page with an error message
            response.sendRedirect("loginin.jsp?error=1");
        }
    }
}

