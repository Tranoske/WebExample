package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/mlist")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO mdao = new MemberDAO();
		ArrayList<Member> mlist = mdao.findAll();

		request.setAttribute("list", mlist);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mlist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			String name = request.getParameter("name");
			String adr = request.getParameter("adr");

			if(name.length() == 0) {
				throw new IllegalArgumentException("なまえを いれようね。");
			}
			if(adr.length() == 0) {
				throw new IllegalArgumentException("じゅうしょを いれようね。");
			}

			MemberDAO mdao = new MemberDAO();
			mdao.insert(new Member(0, name, adr));

			response.sendRedirect("mlist");

		} catch (IllegalArgumentException e) {
			request.setAttribute("errMsg", e.getMessage()+e.getStackTrace());
			request.setAttribute("url", "mlist");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}



	}

}
