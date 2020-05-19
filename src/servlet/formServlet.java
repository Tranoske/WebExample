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
		String mail = request.getParameter("mail");
		String ken = request.getParameter("ken");
		String body = request.getParameter("body");
		String gamen = request.getParameter("gamen");

		String errorMsg = "";
		if (name == null || name.length() == 0) {
			errorMsg += "なまぇ、ﾄﾞｼﾀ？<br>";
		}
		if(gender == null || gender.length() == 0) {
			errorMsg += "性別、ぇらんﾃﾞ!!";
		}

		String mailMsg = "メールマガジン登録：";
		if (mail != null) {
			mailMsg += "する";
		}else {
			mailMsg += "しない<br>申し訳ございません。<br>ハハ...メルマガを登録<br>されていないお客様との<br>会話は禁じられております。";

		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>フォぉぉぉおおム</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>手ミー、フォームをゲッツ！</h1>");
		out.println("<p>*こにちわ！<br>*手ミーむら・・・<br>*ょこそ！！</p>");
		out.println("<p>"+errorMsg+"</p>");
		out.println("<p>"+name+"</p>");
		out.println("<p>ホィ！あちし、手ミーだぉ！</p>");
		out.println("<p>"+gender+"</p>");
		out.println("<p>"+mailMsg+"</p>");
		out.println("<p>"+ken+"</p>");
		out.println("<p>"+gamen+"</p>");
		out.println("<p>"+body+"</p>");
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
