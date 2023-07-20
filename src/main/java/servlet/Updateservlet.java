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

import model.Todo;
import model.UpdateLogic;

/**
 * Servlet implementation class Updateservlet
 */
@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Updateservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		String rank = request.getParameter("rank");
		String content = request.getParameter("content");
		String deadline = request.getParameter("deadline");
		HttpSession session = request.getSession();

		List<Todo> todoList = (List<Todo>) session.getAttribute("todoList");
		if (todoList == null) {
			todoList = new ArrayList<Todo>();
		}

		Todo todo = todoList.get(no);

		if (rank != null && rank.length() >= 1) {

			todo.setRank(rank);
		}
		if (content == null || content.length() >= 1) {
			todo.setContent(content);
		}
		if (deadline == null || deadline.length() >= 1) {
			todo.setDeadline(deadline);
		}
		UpdateLogic updateLogic = new UpdateLogic();
		updateLogic.execute(todoList, todo, no);
		session.setAttribute("todoList", todoList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}

}
