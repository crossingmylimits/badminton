package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.StaffDAO;


@WebServlet("/ListStaffController")
public class ListStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StaffDAO dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStaffController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("staffs", StaffDAO.getAllStaff() );
		RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
        view.forward(request, response);
	}
}
