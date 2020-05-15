package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class formServlet
 */
@WebServlet("/form")
public class formServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public formServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>フォぉぉぉおおム</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>手ミー、フォームをゲッツ！</h1>");
		out.println("<p>"+name+"</p>");
		out.println("<p>"+gender+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>フォぉぉぉおおム</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>手ミー、フォームをポスツ！</h1>");
		out.println("<p>"+name+"</p>");
		out.println("<p>"+gender+"</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
