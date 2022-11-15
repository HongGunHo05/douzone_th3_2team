package com.hwf.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwf.dao.HealthFoodDAO;
import com.hwf.model.HealthFoodDTO;

@WebServlet("/healthfood")
public class HealthFoodController extends HttpServlet {
	
	// 디폴트 생성자
	public HealthFoodController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		System.out.println("cmd : " + cmd); // Console창 출력테스트

		// 헬스식품 - 전체 조회
		if (cmd.equals("healthFoodList")) {
			healthFoodList(request, response);
		}

		// 헬스식품 - 카테고리 '음식' 조회
		else if (cmd.equals("selectFood")) {
			selectFood(request, response);
		}

		// 헬스식품 - 카테고리 '음료' 조회
		else if (cmd.equals("selectCafe")) {
			selectCafe(request, response);
		}

		// 헬스식품 - 상세보기
		else if (cmd.equals("healthFoodDetail")) {
			healthFoodDetail(request, response);
		}
	}

	// healthFoodList (헬스식품 전체 조회)
	public void healthFoodList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HealthFoodDAO dao = new HealthFoodDAO();
		List<HealthFoodDTO> healthFoodList = dao.healthFoodList();

		for(HealthFoodDTO i : healthFoodList) {
			i.setHfDoM(i.getHfDoM().substring(2, 10));
		}
		
		if (healthFoodList != null) {
			request.setAttribute("healthFoodList", healthFoodList); // data save
			request.getRequestDispatcher("/views/jsp/healthFood/allListHealthFood.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}

	// selectFood (헬스식품 - 카테고리 '음식' 조회)
	public void selectFood(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HealthFoodDAO dao = new HealthFoodDAO();
		List<HealthFoodDTO> selectFood = dao.selectFood();

		for(HealthFoodDTO i : selectFood) {
			i.setHfDoM(i.getHfDoM().substring(2, 10));
		}
		
		if (selectFood != null) {
			request.setAttribute("healthFoodList", selectFood); // data save
			request.getRequestDispatcher("/views/jsp/healthFood/allListHealthFood.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}

	// selectCafe (헬스식품 - 카테고리 '음료' 조회)
	public void selectCafe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HealthFoodDAO dao = new HealthFoodDAO();
		List<HealthFoodDTO> selectCafe = dao.selectCafe();

		for(HealthFoodDTO i : selectCafe) {
			i.setHfDoM(i.getHfDoM().substring(2, 10));
		}
		
		if (selectCafe != null) {
			request.setAttribute("healthFoodList", selectCafe); // data save
			request.getRequestDispatcher("/views/jsp/healthFood/allListHealthFood.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}

	// healthFoodDetail (헬스식품 - 상세보기)
	public void healthFoodDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int hfid = Integer.parseInt(request.getParameter("hfid"));

		HealthFoodDAO dao = new HealthFoodDAO();
		List<HealthFoodDTO> healthFoodDetail = dao.healthFoodDetail(hfid);
		
		healthFoodDetail.get(0).setHfDoM(healthFoodDetail.get(0).getHfDoM().substring(2, 10));

		if (healthFoodDetail != null) {
			request.setAttribute("healthFoodList", healthFoodDetail); // data save
			request.getRequestDispatcher("/views/jsp/healthFood/detailHealthFood.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/jsp/error.jsp");
		}
	}

}
