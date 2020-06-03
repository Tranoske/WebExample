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
import model.Uriage;
import model.UriageDAO;

/**
 * Servlet implementation class UriageInfoServlet
 */
@WebServlet("/uinfo")
public class UriageInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UriageInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		UriageDAO udao = new UriageDAO();
		ShohinDAO sdao = new ShohinDAO();

		Uriage u = udao.FindByUid(uid);
		Shohin s = sdao.findBySid(u.getSid());

		request.setAttribute("uinfo", u);
		request.setAttribute("sinfo", s);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/uinfo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
