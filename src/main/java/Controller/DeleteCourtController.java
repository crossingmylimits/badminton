package Controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.CourtDAO;

@WebServlet("/DeleteCourtController")
public class DeleteCourtController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourtDAO dao;

    public DeleteCourtController() {
        super();
        dao = new CourtDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courtID = Integer.parseInt(request.getParameter("CourtID"));
        dao.deleteCourt(courtID);;;
        request.setAttribute("court", CourtDAO.getAllCourts());
        RequestDispatcher view = request.getRequestDispatcher("listcourt.jsp");
        view.forward(request, response);
    }
}


