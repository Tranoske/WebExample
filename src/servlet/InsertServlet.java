package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shohin;
import model.ShohinDAO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));

			Shohin s = new Shohin(0, name, price);

			HttpSession session = request.getSession();
			session.setAttribute("s", s);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/kakunin.jsp");
			dispatcher.forward(request, response);

		}catch(NumberFormatException e) {
			request.setAttribute("errMsg", "たんかには すうじを いれてね。");
			request.setAttribute("url", "insert.html");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Shohin s = (Shohin) session.getAttribute("s");

			if(s.getName().length() == 0) {
				request.setAttribute("errMsg", "しょうひんめいを いれてね。");
				request.setAttribute("url", "insert.html");

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				dispatcher.forward(request, response);
				return;
			}

		ShohinDAO sdao = new ShohinDAO();
		sdao.insert(s);

		response.sendRedirect("slist");

		}catch(NumberFormatException e){
			request.setAttribute("errMsg", "きんがくを いれてね。");
			request.setAttribute("url", "insert.html");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}
//		request.setAttribute("shohin", s);
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/insert.jsp");
//		dispatcher.forward(request, response);
	}

}
