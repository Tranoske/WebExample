package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shohin;
import model.ShohinDAO;

/**
 * Servlet implementation class DelServlet
 */
@WebServlet("/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("sid").length() == 0) {
			response.sendRedirect("slist");
			return;
		}

		int sid = Integer.parseInt(request.getParameter("sid"));

		ShohinDAO sdao = new ShohinDAO();
		Shohin s = sdao.findBySid(sid);

		request.setAttribute("s", s);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/delck.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int sid = Integer.parseInt(request.getParameter("sid"));

		ShohinDAO sdao = new ShohinDAO();
		sdao.delete(sid);

		response.sendRedirect("slist");
	}

}
