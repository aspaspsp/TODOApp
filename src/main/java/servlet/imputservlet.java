package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Todo;
import model.User;

@WebServlet("/InputServlet")
public class imputservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public imputservlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ログインしているか確認するため
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) { // ログインしていない場合
			// リダイレクト
			response.sendRedirect("input.jsp");
		} else { // ログイン済みの場合
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメーターを取得
		request.setCharacterEncoding("UTF-8");
		String rank = request.getParameter("rank");
		String content = request.getParameter("content");
		String deadline = request.getParameter("deadline");

		String errorMsg = "";
		if (content == null || content.length() == 0) {
			errorMsg += "内容が入力されていません<br>";
		}
		if (deadline == null || deadline.length() == 0) {
			errorMsg += "期日が入力されていません<br>";
		}
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>TODOアプリ出力画面</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>TODOアプリケーション</h1>");
		out.println("<h2>村田遥夢のTODOリスト</h2>");
		out.println("<p>" + errorMsg + "</p>");
		out.println("<table class=\" table\">");
		out.println("<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>");
		out.println("<tr><td>1</td><td>" + rank + "</td><td>" + content + "</td><td>" + deadline + "</td></tr>");
		out.println("</table>");
		out.println("</head>");
		out.println("</html>");
		//入力値をBeansのプロパティに設定
		Todo todo = new Todo();
		//文字を数字に変換
		todo.setRank(Integer.parseInt(rank));
		todo.setContent(content);
		todo.setDeadline(deadline);

		//リクエストスコープに保存
		request.setAttribute("todo", todo);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}