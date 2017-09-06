package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.BoardService;
import service.BoardServiceImpl;

public class BoardServlet extends HttpServlet {
	
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
	String inputStr = "";
	Map<String,String>rqHm = null;
	if(command==null) {
		BufferedReader br = request.getReader();
		String s = null;
		while((s=br.readLine())!=null) {
			inputStr+=s;
		}
		rqHm = g.fromJson(inputStr, HashMap.class);
		command = rqHm.get("command");
	}
	if(command.equals("list")) {
		List<Map<String,String>>boardList=bs.selectBoardList(null);
		Map<String, Object> rHm = new HashMap<String, Object>();
		rHm.put("list", boardList);
		String result = g.toJson(rHm);
		doProcess(response,result);
	 }else if(command.equals("write")) {
		 String param = request.getParameter("param");
		 Map<String, String> hm = g.fromJson(param, HashMap.class);
		 HttpSession session = request.getSession();
		 Map<String,String>user = (Map<String, String>)session.getAttribute("user");
		 hm.put("writer", user.get("user_no"));
		 int row = bs.insertBoard(hm);
		 Map<String,String> rHm = new HashMap<String, String>();
		 rHm.put("msg", "저장에 실패하였습니다.");
		 rHm.put("url", "/board/board_write.jsp");
		 
		 if(row==1) {
			 //저장 성공.
			 rHm.put("msg", "저장에 성공하였습니다.");
			 rHm.put("url", "/board/board_list.jsp");
		 }
		 String result = g.toJson(rHm);
		 doProcess(response,result);
	 }else if(command.equals("view")) {
		 String param = request.getParameter("param");
		 Map<String,String> hm = g.fromJson(param, HashMap.class);
		 Map<String,String> rHm = bs.selectBoard(hm);
		 String result = g.toJson(rHm);
		 doProcess(response, result);
	 }else if(command.equals("modify")) {
		 String param = request.getParameter("param");
		 if(rqHm==null) {
			 rqHm = g.fromJson(param, HashMap.class);
		 }
		 int rCnt = bs.updateBoard(rqHm);
		 Map<String,String> rHm = new HashMap<String,String>();
		 rHm.put("msg", "게시물 수정이 실패하였습니다.");
		 rHm.put("url", "");
		 if(rCnt==1) {
			 rHm.put("msg", "수정에 성공하였습니다.");
			 rHm.put("url", "/board/board_list.jsp");
		 }
		 String result = g.toJson(rHm);
		 doProcess(response, result);
	 }else if(command.equals("delete")) {

		 String param = request.getParameter("param");
		 if(rqHm==null) {
			 rqHm = g.fromJson(param, HashMap.class);
		 }
		 int rCnt = bs.deleteBoard(rqHm);
		 Map<String,String> rHm = new HashMap<String,String>();
		 rHm.put("msg", "게시물 삭제에 실패하였습니다.");
		 rHm.put("url", "");
		 if(rCnt==1) {
			 rHm.put("msg", "게시물 삭제가 성공하였습니다.");
			 rHm.put("url", "/board/board_list.jsp");
		 }
		 String result = g.toJson(rHm);
		 doProcess(response, result);
	 }
		
	}
	
	public void doProcess(HttpServletResponse response,String result)throws ServletException,IOException{
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println(result);
		
	}
}
