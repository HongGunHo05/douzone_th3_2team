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

import com.hwf.dao.RecommendDAO;
import com.hwf.model.HealthFoodDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.NutrientsDTO;



@WebServlet("/recommend")
public class RecommendController extends HttpServlet{

	@Autowired
	public RecommendController() {}
	

	// ------------------------------

	public void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 한글로 데이터를 받고 내려가야함 
		
		String cmd = request.getParameter("cmd");  //  ~~?cmd=list
		System.out.println("cmd : " + cmd);
		if( cmd.equals("list") ) {			
			list(request, response);
		} else if( cmd.equals("surveysearching") ) {			
			surveysearching(request, response);
		} else if( cmd.equals("inbodysearching") ) {			
			inbodysearching(request, response);
		}
		
	}
	
	// 추천 상품 리스트
	public void list(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		RecommendDAO dao = new RecommendDAO(); 

		 List<HealthGoodsDTO> HealthGoodsSelect = dao.SearchHealthGoodsSelect();

		 List<HealthFoodDTO> HealthFoodSelect = dao.SearchHealthFoodSelect();

		 List<NutrientsDTO> NutrientsSelect = dao.SearchNutrientsSelect();
		
		
		System.out.println("HealthGoodsSelect : " + HealthGoodsSelect);
		System.out.println("HealthFoodSelect : " + HealthFoodSelect);
		System.out.println("NutrientsSelect : " + NutrientsSelect);
		
		if( HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect); 
			request.setAttribute("HealthFoodSelect", HealthFoodSelect);  
			request.setAttribute("NutrientsSelect", NutrientsSelect);
			request.getRequestDispatcher("/views/jsp/recommendpage.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	} // list end
		
	
	// 추천 설문 결과에 따른 상품 매칭
	public void surveysearching(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 컬럼명
		request.setCharacterEncoding("UTF-8");
		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");
		System.out.println(column + " / " + keyvalue);

		Map<String, String> map = new HashMap<>(); // collection
		map.put("column", column); // column : title or writer or contnet
		map.put("keyvalue", keyvalue); // keyvalue : 김연아

		RecommendDAO dao = new RecommendDAO();
		
		List<HealthGoodsDTO> HealthGoodsSelect = dao.suverysearchingHealthGoods(map);
		List<HealthFoodDTO> HealthFoodSelect = dao.suverysearchingHealthFood(map);
		List<NutrientsDTO> NutrientsSelect = dao.suverysearchingNutrients(map);
		
		System.out.println("왔습니다 컨트롤러 survey");
		
		if( HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect); 
			request.setAttribute("HealthFoodSelect", HealthFoodSelect);  
			request.setAttribute("NutrientsSelect", NutrientsSelect);
			
			request.getRequestDispatcher("/views/jsp/recommendpage.jsp").forward(request, response);

		} else {
	
			response.sendRedirect("views/error.jsp");
		}
	}
	
	// 추천 인바디 결과에 따른 상품 매칭
	public void inbodysearching(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");
		System.out.println(column + " / " + keyvalue);

		Map<String, String> map = new HashMap<>(); 
		map.put("column", column); 
		map.put("keyvalue", keyvalue); 

		RecommendDAO dao = new RecommendDAO();
		List<HealthGoodsDTO> HealthGoodsSelect = dao.inbodysearchingHealthGoods(map);
		List<HealthFoodDTO> HealthFoodSelect = dao.inbodysearchingHealthFood(map);
		List<NutrientsDTO> NutrientsSelect = dao.inbodysearchingNutrients(map);
		
		System.out.println("왔습니다 컨트롤러 inbody : " + HealthGoodsSelect);
		
		if( HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
			request.setAttribute("HealthGoodsSelect", HealthGoodsSelect); 
			request.setAttribute("HealthFoodSelect", HealthFoodSelect);  
			request.setAttribute("NutrientsSelect", NutrientsSelect);
			
			request.getRequestDispatcher("/views/jsp/recommendpage.jsp").forward(request, response);
		} else {
			
			response.sendRedirect("views/error.jsp");
		}
	}

	
}
