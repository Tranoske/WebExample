package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Kban;
import model.KbanDAO;

/**
 * Servlet implementation class KbanServlet
 */
@WebServlet("/kban")
public class KbanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public KbanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KbanDAO kdao = new KbanDAO();
		ArrayList<Kban> klist = kdao.findAll();

		request.setAttribute("klist", klist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kban.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = (String) request.getParameter("name");
		String bun = (String) request.getParameter("bun");

		Kban k = new Kban(0, null, name, bun);

		KbanDAO kdao = new KbanDAO();
		kdao.insert(k);

		response.sendRedirect("kban");
	}

}
