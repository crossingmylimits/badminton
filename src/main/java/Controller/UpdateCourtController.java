package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import dao.CourtDAO;
import model.CourtBean;

/**
 * Servlet implementation class UpdateCourtController
 */
@WebServlet("/UpdateCourtController")
public class UpdateCourtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourtDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourtController() {
        super();
        dao = new CourtDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int courtID = Integer.parseInt(request.getParameter("CourtID"));
		request.setAttribute("c", CourtDAO.getCourtByID(courtID));
        RequestDispatcher view = request.getRequestDispatcher("updateCourt.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourtBean court = new CourtBean();
		court.setCourtID(Integer.parseInt(request.getParameter("CourtID")));
		court.setCourtName(request.getParameter("CourtName"));
		
		dao.updateCourt(court);
		
		request.setAttribute("court", CourtDAO.getAllCourts());
        RequestDispatcher view = request.getRequestDispatcher("listcourt.jsp");
        view.forward(request, response);
	}

}
