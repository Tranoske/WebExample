package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shohin;
import model.ShohinDAO;
import model.Uriage;
import model.UriageDAO;

/**
 * Servlet implementation class UriageInsertServlet
 */
@WebServlet("/uinsert")
public class UriageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UriageInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ShohinDAO sdao = new ShohinDAO();
			ArrayList<Shohin> slist = sdao.findAll();

			request.setAttribute("list", slist);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/uinsert.jsp");
			dispatcher.forward(request, response);
		}catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			int sid = Integer.parseInt(request.getParameter("sid"));
			int kosu = Integer.parseInt(request.getParameter("kosu"));
			java.util.Date ud = new java.util.Date();
			java.sql.Date sd = new java.sql.Date(ud.getTime());

			UriageDAO udao = new UriageDAO();
			udao.insert(new Uriage(0, sid, kosu, sd));

			response.sendRedirect("ulist");

		}catch (NumberFormatException e) {
			request.setAttribute("errMsg", "こすうには すうじを いれてね。");
			request.setAttribute("url", "uinsert");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}

}
