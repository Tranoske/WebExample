package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Kban;
import model.KbanDAO;

/**
 * Servlet implementation class KdelServlet
 */
@WebServlet("/kdel")
public class KdelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KdelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int kid = Integer.parseInt(request.getParameter("kid"));

		KbanDAO kdao = new KbanDAO();
		Kban k = kdao.findBykid(kid);

		request.setAttribute("k", k);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kdel.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int kid = Integer.parseInt(request.getParameter("kid"));

		KbanDAO kdao = new KbanDAO();
		kdao.delete(kid);

		response.sendRedirect("kban");
	}

}
