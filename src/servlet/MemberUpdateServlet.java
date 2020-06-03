package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("mid"));

		MemberDAO mdao = new MemberDAO();
		Member m = mdao.findByMid(mid);

		request.setAttribute("m", m);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mupdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String act = request.getParameter("action");

			if (act.equals("update")) {
				int mid = Integer.parseInt(request.getParameter("mid"));
				String name = request.getParameter("name");
				String adr = request.getParameter("adr");
				if(name.length() == 0) {
					throw new IllegalArgumentException("なまえを いれようね。");
				}
				if(adr.length() == 0) {
					throw new IllegalArgumentException("じゅうしょを いれようね。");
				}

				MemberDAO mdao = new MemberDAO();
				mdao.update(new Member(mid, name, adr));


			}else if(act.equals("del")) {
				int mid = Integer.parseInt(request.getParameter("mid"));

				MemberDAO mdao = new MemberDAO();
				mdao.delete(mid);
			}
			response.sendRedirect("mlist");

		} catch (IllegalArgumentException e) {
			request.setAttribute("errMsg", e.getMessage()+e.getStackTrace());
			request.setAttribute("url", "mlist");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
		}

	}

}
