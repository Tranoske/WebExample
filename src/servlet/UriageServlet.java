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
 * Servlet implementation class UriageServlet
 */
@WebServlet("/uriage")
public class UriageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UriageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		UriageDAO udao = new UriageDAO();
		ShohinDAO sdao = new ShohinDAO();

		Shohin s = sdao.findBySid(sid);
		ArrayList<Uriage> ulist = udao.FindBySid(sid);

		request.setAttribute("s",s);
		request.setAttribute("list", ulist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/uriage.jsp");
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
