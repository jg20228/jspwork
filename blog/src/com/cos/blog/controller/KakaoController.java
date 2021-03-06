package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.action.board.BoardDeleteProcAction;
import com.cos.blog.action.board.BoardDetailAction;
import com.cos.blog.action.board.BoardHomeAction;
import com.cos.blog.action.board.BoardSearchAction;
import com.cos.blog.action.board.BoardUpdateAction;
import com.cos.blog.action.board.BoardUpdateProcAction;
import com.cos.blog.action.board.BoardWriteAction;
import com.cos.blog.action.board.BoardWriteProcAction;
import com.cos.blog.action.kakao.KakaoCallbackAction;
import com.cos.blog.action.user.UsersJoinAction;
import com.cos.blog.action.user.UsersJoinProcAction;
import com.cos.blog.action.user.UsersLoginAction;


// http://localhost:8000/blog/board/oauth/kakao
// 뒤에 주소를 붙여서 분기를 시킴
@WebServlet("/oauth/kakao")
public class KakaoController extends HttpServlet {
	
	private final static String TAG = "BoardController : ";
	
	private static final long serialVersionUID = 1L;

    public KakaoController() {
        super();

    }

    //종류가 4가지인데 두개만 쓴다. Get, Post
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SELECT 는 doGet
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DML 은 doPost
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("path", request.getContextPath());
		
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "router() : "+cmd );
		
		//팩토리 패턴
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		if(cmd.equals("callback")) {
			return new KakaoCallbackAction();
		}
		return null;
	}	
}
