package com.hwf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwf.dao.NutrientsDAO;
import com.hwf.model.NutrientsDTO;

@WebServlet("/nutrients")
public class NutrientsController extends HttpServlet {
	public NutrientsController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");

		String choicenutr = "";

		if (cmd.contains("3")) {
			String[] arr = cmd.split("");
			cmd = "";

			for (int i = 15; i < 20; i++) {
				choicenutr += arr[i];
			}

			for (int i = 0; i < 15; i++) {
				cmd += arr[i];
			}

			System.out.println("choicenutr : " + choicenutr);

		}

		System.out.println("cmd : " + cmd);

		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("vitaminList")) {
			vitaminList(request, response);

		} else if (cmd.equals("proteinList")) {
			proteinList(request, response);
		} else if (cmd.equals("dietList")) {
			dietList(request, response);
		} else if (cmd.equals("nutrientsDetail")) {
			nutrientsDetail(request, response, choicenutr);
		}
	}

	////////////////////////////////////////////////////////////////////
	// 전체조회
	////////////////////////////////////////////////////////////////////
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NutrientsDAO dao = new NutrientsDAO();

		List<NutrientsDTO> list = dao.selectAll();
		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/jsp/nutr/allList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	public void vitaminList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NutrientsDAO dao = new NutrientsDAO();
		List<NutrientsDTO> list = dao.selectvitamin();

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/jsp/nutr/allList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	public void proteinList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NutrientsDAO dao = new NutrientsDAO();
		List<NutrientsDTO> list = dao.selectprotein();

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/jsp/nutr/allList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	public void dietList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NutrientsDAO dao = new NutrientsDAO();
		List<NutrientsDTO> list = dao.selectdiet();

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/jsp/nutr/allList.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}
	////////////////////////////////////////////////////////////////////
	// 전체조회 끝
	////////////////////////////////////////////////////////////////////

	public void nutrientsDetail(HttpServletRequest request, HttpServletResponse response, String choicenutr)
			throws ServletException, IOException {

		int num = Integer.parseInt(choicenutr);

		NutrientsDAO dao = new NutrientsDAO();
		List<NutrientsDTO> list = dao.selectdetail(num);

		if (list != null) {
			request.setAttribute("list", list); // data save
			request.getRequestDispatcher("/views/jsp/nutr/detailnutrients.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

}
