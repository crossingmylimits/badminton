package Controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.CourtDAO;
import model.CourtBean;

/**
 * Servlet implementation class AddCourtController
 */
@WebServlet("/AddCourtController")
public class AddCourtController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourtDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourtController() {
        super();
        dao = new CourtDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourtBean c = new CourtBean();
        c.setCourtName(request.getParameter("CourtName"));

        dao.addCourt(c);

        // Forward to a success page or redirect to a different page
        request.setAttribute("court", CourtDAO.getAllCourts());
        RequestDispatcher dispatcher = request.getRequestDispatcher("listcourt.jsp");
        dispatcher.forward(request, response);
    }
}
