package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//TODOリストの内容
		String[] todoList = { "Linuxテスト対策", "paiza", "TODOアプリ作成", "履歴書" };
		Random rand = new Random();
		int num = rand.nextInt(todoList.length);
		String todo = todoList[num];

		//DateインスタンスからStringを生成する
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
		String today = sdf.format(date);

		//HTMLを出力(タグの外側を""で囲む)
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\" />");
		out.println("<title>TODOアプリ出力画面</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>TODOアプリケーション</h1>");
		out.println("<h2>村田遥夢のTODOリスト<h2>");
		out.println("<table border=1>");
		out.println("<tr><th>No</th><th>重要度</th><th>内容</th><th>期日</th></tr>");
		out.println("<tr><td>1</td><td>" + (num + 1) + "</td><td>" + todo + "</td><td>" + today + "</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
