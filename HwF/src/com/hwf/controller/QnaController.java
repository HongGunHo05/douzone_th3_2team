package com.hwf.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import com.hwf.dao.QnaDAO;
import com.hwf.model.QnaDTO;

@WebServlet("/board")
public class QnaController extends HttpServlet {

	@Autowired
	public QnaController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); // 한글로 데이터를 받고 내려가야함

		String cmd = request.getParameter("cmd"); // ~~?cmd=list
		System.out.println("cmd : " + cmd);
		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("update")) {
			update(request, response);
		} else if (cmd.equals("delete")) {
			delete(request, response);
		} else if (cmd.equals("detail")) {
			detail(request, response);
		} else if (cmd.equals("write")) {
			write(request, response);
		} else if (cmd.equals("search")) {
			search(request, response);
		} else if (cmd.equals("updateform")) {
			updateform(request, response);
		}

	} // service end

	// select
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		QnaDAO dao = new QnaDAO();
		List<QnaDTO> list = dao.selectAll();
		System.out.println("list : " + list);

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/jsp/qna/list.jsp").forward(request, response);
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	} // list end

	// client write
	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String memberid = request.getParameter("memberid");
		String qnacontent = request.getParameter("qnacontent");
		String qnatitle = request.getParameter("qnatitle");

		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO(qnatitle, qnacontent, memberid);
		System.out.println(dto);
		int rowcount = dao.insert(dto);
		System.out.println(dao);

		if (rowcount > 0) {
			response.sendRedirect("board?cmd=list");
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	} // write end

	// search -> 고객이 게시글 접속할 때 해당 메서드로 진입
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 컬럼명
		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");
		System.out.println(column + " / " + keyvalue);

		Map<String, String> map = new HashMap<>(); // collection
		map.put("column", column); 
		map.put("keyvalue", keyvalue); 

		QnaDAO dao = new QnaDAO();

		List<QnaDTO> list = dao.getSearchList(map);
		if (list != null) {
			request.setAttribute("list", list);

			System.out.println("list : " + list);
			request.getRequestDispatcher("/views/jsp/qna/list.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	// 세부사항(내용 자세히 보기)
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String qnaid = request.getParameter("qnaid");
		System.out.println("번호는 ? " + qnaid);
		QnaDAO dao = new QnaDAO();
		QnaDTO dto = dao.detailList(Integer.parseInt(qnaid));

		if (dto != null) {
			request.setAttribute("dto", dto);
			System.out.println("controller dto : " + dto);
			request.getRequestDispatcher("/views/jsp/qna/detail.jsp").forward(request, response);

		} else {
			response.sendRedirect("views/error.jsp");
		}
	} // detail end

	// 삭제(관리자만 할 수 있게 차후에 수정필요)
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String qnaid = request.getParameter("qnaid");
		QnaDAO dao = new QnaDAO();
		int rowcount = dao.delete(Integer.parseInt(qnaid));
		if (rowcount > 0) {
			list(request, response); // response.sendRedirect("board?cmd=list"); 이렇게 해도 된다.
		}
	} // delete end

	public void updateform(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String qnaid = request.getParameter("qnaid");
		System.out.println("번호는 ? " + qnaid);
		QnaDAO dao = new QnaDAO();
		QnaDTO dto = dao.detailList(Integer.parseInt(qnaid));

		if (dto != null) {
			request.setAttribute("dto", dto);
			System.out.println("controller dto : " + dto);
			request.getRequestDispatcher("/views/jsp/qna/update.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	} // updateform end

	// update (내용 수정 / 관리자만 필요할듯?)
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String qnatitle = request.getParameter("qnatitle");
		String qnacontent = request.getParameter("qnacontent");
		String qnaanswer = request.getParameter("qnaanswer");

		QnaDTO dto = new QnaDTO(qnatitle, qnacontent, qnaanswer);
		QnaDAO dao = new QnaDAO();

		int rowcount = dao.update(dto);
		if (rowcount > 0) {
			response.sendRedirect("board?cmd=list"); // list(request, response);
		}
	} // end update

	// 게시글 항목 별 검색(관리자만 필요)
	public void search2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String qnatitle = request.getParameter("qnatitle");
		String qnacontent = request.getParameter("qnacontent");
		String memberid = request.getParameter("memberid");
		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<>(); // collection
		map.put("qnatitle", qnatitle);
		map.put("qnacontent", qnacontent);
		map.put("memberid", memberid);
		map.put("keyvalue", keyvalue);

		QnaDAO dao = new QnaDAO();
		List<QnaDTO> list = dao.getSearchList2(map);

		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/jsp/qna/searchList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}
}