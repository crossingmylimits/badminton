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
 * Servlet implementation class ListCourtController
 */
@WebServlet("/ListCourtController")
public class ListCourtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourtDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCourtController() {
        super();
        dao = new CourtDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("court", CourtDAO.getAllCourts() );
		RequestDispatcher view = request.getRequestDispatcher("listcourt.jsp");
        view.forward(request, response);
	}

}
