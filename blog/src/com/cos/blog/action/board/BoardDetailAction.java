package com.cos.blog.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cos.blog.action.Action;
import com.cos.blog.dto.DetailResponseDto;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.util.HtmlParser;
import com.cos.blog.util.Script;

public class BoardDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
			Script.back("잘못된 접근입니다.", response);
			return;
		}
		// 스트링->int
		int id = Integer.parseInt(request.getParameter("id"));

		BoardRepository boardRepository = BoardRepository.getInstance();
		DetailResponseDto dto = boardRepository.findById(id);
		if (dto != null) {
			String content = dto.getBoard().getContent();
			content = HtmlParser.youtube(content);
			dto.getBoard().setContent(content);
			
			
			// 데이터를 담고 갈때도 사용 RequestDispatcher
			// SendRedirect랑 똑같은데 request와 response를 유지하는 기법
			request.setAttribute("dto", dto);
			RequestDispatcher dis = request.getRequestDispatcher("board/detail.jsp");
			dis.forward(request, response);
		} else {
			Script.back("잘못된 접근입니다.", response);
		}
	}
}
