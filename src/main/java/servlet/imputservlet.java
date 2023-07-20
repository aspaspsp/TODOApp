package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.InputLogic;
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
			errorMsg += "期日が入力されていません";
		}
		if (errorMsg.length() >= 1) {
			request.setAttribute("errorMsg", errorMsg);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEF-INF/jsp/input.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//入力値をBeansのプロパティに設定
		Todo todo = new Todo(rank, content, deadline);

		HttpSession session = request.getSession();
		List<Todo> todoList = (List<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			todoList = new ArrayList<Todo>();
		}
		InputLogic inputLogic = new InputLogic();
		inputLogic.execute(todoList, todo);
		session.setAttribute("todoList", todoList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}
