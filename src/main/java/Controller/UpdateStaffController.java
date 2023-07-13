package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.StaffDAO;
import model.StaffBean;

/**
 * Servlet implementation class UpdateStaffController
 */
@WebServlet("/UpdateStaffController")
public class UpdateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StaffDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaffController() {
        super();
        dao = new StaffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int staffID = Integer.parseInt(request.getParameter("StaffID"));
        request.setAttribute("c", StaffDAO.getStaffByID(staffID));
        RequestDispatcher view = request.getRequestDispatcher("updateStaff.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StaffBean staff = new StaffBean();
		staff.setStaffID(Integer.parseInt(request.getParameter("StaffID")));
		staff.setStaffName(request.getParameter("StaffName"));
		staff.setStaffRole(request.getParameter("StaffRole"));
		staff.setStaffPhoneNum(Integer.parseInt(request.getParameter("StaffPhoneNum")));
		staff.setStaffEmail(request.getParameter("StaffEmail"));
		staff.setStaffPass(request.getParameter("StaffPass"));
		staff.setManagerID(Integer.parseInt(request.getParameter("ManagerID")));
		
		dao.updateStaff(staff);
		
		request.setAttribute("staffs", StaffDAO.getAllStaff());
        RequestDispatcher view = request.getRequestDispatcher("listStaff.jsp");
        view.forward(request, response);
		
	}

}
