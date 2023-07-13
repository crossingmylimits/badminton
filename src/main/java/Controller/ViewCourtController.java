package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.CourtDAO;

/**
 * Servlet implementation class ViewCourtController
 */
@WebServlet("/ViewCourtController")
public class ViewCourtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CourtDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCourtController() {
        super();
        dao = new CourtDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int courtID = Integer.parseInt(request.getParameter("CourtID"));
        request.setAttribute("c", CourtDAO.getCourtByID(courtID));
        RequestDispatcher view = request.getRequestDispatcher("viewcourt.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
}
