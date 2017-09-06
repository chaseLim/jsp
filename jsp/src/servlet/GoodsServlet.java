package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.BoardService;
import service.BoardServiceImpl;

public class GoodsServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
	private Gson g =new Gson();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		System.out.println(id);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("입력하신 ID: " + id);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		
	request.setCharacterEncoding("utf-8");
	String command = request.getParameter("command");
	
	if(command.equals("list")) {
		request.setAttribute("test", "test kkekek");
		String url ="/goods/goods_list.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(url);		
		rd.forward(request, response);		
	  }
	}
	
	public void doProcess(HttpServletResponse response,String result)throws ServletException,IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(result);
		
	}

}
