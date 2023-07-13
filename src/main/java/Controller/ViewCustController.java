package Controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.CustDAO;

@WebServlet("/ViewCustController")
public class ViewCustController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustDAO dao;

    public ViewCustController() {
        super();
        dao = new CustDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int custID = Integer.parseInt(request.getParameter("CustID"));
        request.setAttribute("c", CustDAO.getCustomerByID(custID));
        RequestDispatcher view = request.getRequestDispatcher("ViewCustomer.jsp");
        view.forward(request, response);
    }
}
