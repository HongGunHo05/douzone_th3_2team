package com.hwf.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwf.dao.CartDAO;
import com.hwf.dao.HealthFoodDAO;
import com.hwf.dao.HealthGoodsDAO;
import com.hwf.dao.NutrientsDAO;
import com.hwf.dao.PurchaseDAO;
import com.hwf.model.CartDTO;
import com.hwf.model.HealthFoodDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.NutrientsDTO;
import com.hwf.model.PurchaseDTO;

@WebServlet("/cart")
public class CartController extends HttpServlet {

	public CartController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		System.out.println("cmd : " + cmd);

		if (cmd.equals("insertCart")) { // 영양제 장바구니에 담기
			insertCart(request, response);
		} else if (cmd.equals("insertbottleCart")) { // 영양제 장바구니에 담기
			insertbottleCart(request, response);
		} else if (cmd.equals("healthGoodsInsertCart")) { // 헬스용품 장바구니에 담기
			healthGoodsInsertCart(request, response);
		} else if (cmd.equals("healthFoodInsertCart")) { // 헬스식품 장바구니에 담기
			healthFoodInsertCart(request, response);
		} else if (cmd.equals("deleteSelete")) { // 장바구니에서 '삭제' 버튼 클릭시
			deleteSelete(request, response);
		} else if (cmd.equals("purchase")) { // 장바구니에서 '카카오페이 구매' 버튼 클릭시
			purchase(request, response);
		} else if (cmd.equals("creditpurchase")) { // 장바구니에서 '신용카드 구매' 버튼 클릭시
			creditpurchase(request, response);
		} else if (cmd.equals("success")) { // 결제 성공시
			success(request, response);
		} else if (cmd.equals("fail")) { // 결제 실패시
			fail(request, response);
		} else if (cmd.equals("gobasket")) { // 장바구니 바로가기
			gobasket(request, response);
		}
	}

	
	// 영양제 장바구니에 담기
	public void insertCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cusId = "";

		try {
			HttpSession session;
			session = request.getSession();
			cusId = session.getAttribute("memberid").toString(); // 고객 id

			if (cusId.equals("")) {
				throw new Exception();
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		String productId = request.getParameter("hiddenid"); // 제품 아이디 번호
		String totalPrice = request.getParameter("onetotal"); // 총 가격
		String totalCount = request.getParameter("countone"); // 총 수량
		String getMethod = request.getParameter("getnu"); // 받는 방법

		String n;

		if (getMethod.equals("onetime")) {
			n = "1";
		} else {
			n = "2";
		}

		String selectGetDay = request.getParameter("selectgetday"); // 받는 날짜
		String finishDay = request.getParameter("finishnutr"); // 끝나는 날짜

		NutrientsDAO nutrdao = new NutrientsDAO();
		List<NutrientsDTO> list = nutrdao.selectdetail(Integer.parseInt(productId)); // 영앙제 정보

		CartDAO cartdao = new CartDAO();
		CartDTO cartDto = new CartDTO(cusId, productId, list.get(0).getNutrientsName(), list.get(0).getNutrientsIMG(), Integer.parseInt(totalPrice), n, selectGetDay, finishDay);

		cartdao.insertData(cartDto);

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");
				} else
					i.setReservation("나눠서 받기");
			} else {
				continue;
			}
			i.setPurchasetime(i.getPurchasetime().substring(2, 10));
			i.setEndtime(i.getEndtime().substring(2, 10));
		} // end for

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
	}

	
	// 영양제 장바구니에 담기
	public void insertbottleCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cusId = "";

		try {
			HttpSession session;
			session = request.getSession();
			cusId = session.getAttribute("memberid").toString(); // 고객 id

			if (cusId.equals("")) {
				throw new Exception();
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		
		String productId = request.getParameter("hiddenid"); // 제품 아이디 번호
		String totalPrice = request.getParameter("total"); // 총 가격
		String totalCount = request.getParameter("countnum"); // 총 수량
		String getMethod = request.getParameter("getnuall"); // 받는 방법

		String n;

		if (getMethod.equals("onetime")) {
			n = "1";
		} else {
			n = "2";
		}

		String selectGetDay = request.getParameter("selectgetday2"); // 받는 날짜
		String finishDay = request.getParameter("finishnutr2"); // 끝나는 날짜

		NutrientsDAO nutrdao = new NutrientsDAO();
		List<NutrientsDTO> list = nutrdao.selectdetail(Integer.parseInt(productId)); // 영앙제 정보

		CartDAO cartdao = new CartDAO();
		CartDTO cartDto = new CartDTO(cusId, productId, list.get(0).getNutrientsName(), list.get(0).getNutrientsIMG(), Integer.parseInt(totalPrice), n, selectGetDay, finishDay);

		cartdao.insertData(cartDto);

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");
				} else
					i.setReservation("나눠서 받기");
			} else {
				continue;
			}
			i.setPurchasetime(i.getPurchasetime().substring(2, 10));
			i.setEndtime(i.getEndtime().substring(2, 10));
		} // end for

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}

	}
	

	// 헬스용품 장바구니에 담기
	public void healthGoodsInsertCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cusId = "";

		try {
			HttpSession session;
			session = request.getSession();
			cusId = session.getAttribute("memberid").toString(); // 고객 id

			if (cusId.equals("")) {
				throw new Exception();
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}

		String productsId = request.getParameter("healthGoodsId"); // 제품번호
		System.out.println(productsId);
		String productsPrice = request.getParameter("onetotal"); // 총 가격

		HealthGoodsDAO dao = new HealthGoodsDAO();
		List<HealthGoodsDTO> list = dao.healthGoodsDetail(Integer.parseInt(productsId));

		CartDAO cartdao = new CartDAO();
		CartDTO cartDto = new CartDTO(cusId, productsId, list.get(0).getHealthGoodsName(), list.get(0).getHealthGoodsImg(), Integer.parseInt(productsPrice));
		cartdao.insertDataExcept(cartDto);

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");				
				} else
					i.setReservation("나눠서 받기");
			} else {
				continue;
			}
			i.setPurchasetime(i.getPurchasetime().substring(2, 10));
			i.setEndtime(i.getEndtime().substring(2, 10));
		} // end for
		
		
		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
	}
	

	// 헬스식품 장바구니에 담기
	public void healthFoodInsertCart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cusId = "";

		try {
			HttpSession session;
			session = request.getSession();
			cusId = session.getAttribute("memberid").toString(); // 고객 id

			if (cusId.equals("")) {
				throw new Exception();
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}

		String productsId = request.getParameter("hfid"); // 제품번호
		String productsPrice = request.getParameter("onetotal"); // 총 가격

		HealthFoodDAO dao = new HealthFoodDAO();
		List<HealthFoodDTO> list = dao.healthFoodDetail(Integer.parseInt(productsId));

		CartDAO cartdao = new CartDAO();
		CartDTO cartDto = new CartDTO(cusId, productsId, list.get(0).getHfName(), list.get(0).getHfIMG(),
				Integer.parseInt(productsPrice));
		cartdao.insertDataExcept(cartDto);

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");	
				} else
					i.setReservation("나눠서 받기");
			} else {
				continue;
			}
			i.setPurchasetime(i.getPurchasetime().substring(2, 10));
			i.setEndtime(i.getEndtime().substring(2, 10));
		} // end for
		
		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
	}

	
	// 장바구니에서 '삭제' 버튼 클릭시
	public void deleteSelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CartDAO cartdao = new CartDAO();

		String[] arr = request.getParameter("hiddenid").split(",");

		for (int i = 0; i < arr.length; i++) {
			int deleteNum = cartdao.deleteData(Integer.parseInt(arr[i]));
		}

		HttpSession session;
		session = request.getSession();
		String cusId = session.getAttribute("memberid").toString();

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");
				} else
					i.setReservation("나눠서 받기");
			} else {
				continue;
			}
			i.setPurchasetime(i.getPurchasetime().substring(2, 10));
			i.setEndtime(i.getEndtime().substring(2, 10));
		} // end for

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		}
	}

	
	// 장바구니에서 '카카오페이 구매' 버튼 클릭시
	public void purchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String[] idarr = id.split(",");

		CartDAO cartdao = new CartDAO();

		int price = 0; // 총 가격

		for (int i = 0; i < idarr.length; i++) {
			List<CartDTO> searchPriceDto = cartdao.selectPrice(Integer.parseInt(idarr[i]));
			price += searchPriceDto.get(0).getProductsPrice();

		}

		HttpSession session;
		session = request.getSession();
		session.setMaxInactiveInterval(20 * 60);

		session.setAttribute("cartId", id);
		request.setAttribute("totalPrice", price);
		request.getRequestDispatcher("/views/jsp/cart/kakaopay.jsp").forward(request, response);

	}

	
	// 장바구니에서 '신용카드 구매' 버튼 클릭시
	public void creditpurchase(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String[] idarr = id.split(",");

		CartDAO cartdao = new CartDAO();

		int price = 0; // 총 가격

		for (int i = 0; i < idarr.length; i++) {
			List<CartDTO> searchPriceDto = cartdao.selectPrice(Integer.parseInt(idarr[i]));
			price += searchPriceDto.get(0).getProductsPrice();

		}

		HttpSession session;
		session = request.getSession();
		session.setMaxInactiveInterval(20 * 60);
		session.setAttribute("cartId", id);
		request.setAttribute("totalPrice", price);
		request.getRequestDispatcher("/views/jsp/cart/creditcard.jsp").forward(request, response);

	}

	
	// 결제 성공시
	public void success(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session;
		session = request.getSession();
		String cusId = session.getAttribute("memberid").toString(); // 고객 id
		String[] idarr = session.getAttribute("cartId").toString().split(","); // id 배열

		CartDAO cartdao = new CartDAO();

		HealthFoodDAO healthfooddao = new HealthFoodDAO();
		HealthGoodsDAO healthgoodsdao = new HealthGoodsDAO();
		PurchaseDAO purchasedao = new PurchaseDAO();
		PurchaseDTO purchasedto;

		for (int i = 0; i < idarr.length; i++) {
			
			// 장바구니 cartId로 조회
			List<CartDTO> searchPriceDto = cartdao.selectPrice(Integer.parseInt(idarr[i]));
			String memberid = searchPriceDto.get(0).getMemberId(); // 회원 id
			int price = searchPriceDto.get(0).getProductsPrice(); // 총 가격
			String number = searchPriceDto.get(0).getProductsId(); // 제품 아이디

			// id 첫 글자로 insert 구별
			int num = Integer.parseInt(searchPriceDto.get(0).getProductsId().substring(0, 1));

			switch (num) {
			
			case 3: // 영양제

				// 수령 방식
				String getMethod = searchPriceDto.get(0).getReservation();

				// 수령시작날짜
				String selectGetDay = searchPriceDto.get(0).getPurchasetime().substring(0, 10);
				
				// 수령 기간 -- > 끝나는 날짜에서 시작 날짜 빼야 함
				LocalDate selectGetDate = LocalDate.parse(selectGetDay);
				LocalDate finishDay = LocalDate.parse(searchPriceDto.get(0).getEndtime().substring(0, 10));

				Period period = Period.between(selectGetDate, finishDay);
				int difference = period.getDays(); // 수령 기간

				String nutrid = searchPriceDto.get(0).getProductsId();

				purchasedto = new PurchaseDTO(price, getMethod, selectGetDay, difference, nutrid, memberid);
				purchasedao.purchaseNutr(purchasedto);

				break;

			case 2: // 식품

				List<HealthFoodDTO> healthfooddto = healthfooddao.healthFoodDetail(Integer.parseInt(number));
				int thisprice = price / healthfooddto.get(0).getHfPrice(); // --> 갯수

				// 식품 아이디
				String foodid = searchPriceDto.get(0).getProductsId();

				purchasedto = new PurchaseDTO(thisprice, price, foodid, memberid);

				purchasedao.purchaseHealthFood(purchasedto);

				break;

			case 1: // 용품

				List<HealthGoodsDTO> healthgoodsdto = healthgoodsdao.healthGoodsDetail(Integer.parseInt(number));
				int subprice = price / healthgoodsdto.get(0).getHealthGoodsPrice(); // --> 갯수

				// 용품 아이디
				String goodsid = searchPriceDto.get(0).getProductsId();

//				String reservation = searchPriceDto.get(0).getReservation();
				String diff = null;
//				purchasedto = new PurchaseDTO(subprice, price, reservation, goodsid, memberid);
//				purchasedto = new PurchaseDTO(subprice, price, " ", goodsid, memberid);
				purchasedto = new PurchaseDTO(subprice, price, diff, goodsid, memberid);
				System.out.println(purchasedto.toString());
				purchasedao.purchaseGoods(purchasedto);

				break;

			}

		}

		purchasedao.deleteData(cusId);

		request.getRequestDispatcher("/views/jsp/cart/purchaseSuccess.jsp").forward(request, response);
	}
	

	// 결제 실패시
	public void fail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartDAO cartdao = new CartDAO();

		HttpSession session;
		session = request.getSession();
		String cusId = session.getAttribute("memberid").toString();

		List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

		for (CartDTO i : cartsearchDto) {
			if (i.getReservation() != null) {
				if (i.getReservation().equals("1")) {
					i.setReservation("한번에 받기");
				} else
					i.setReservation("나눠서 받기");
			} else {
				continue;
			}
			i.setPurchasetime(i.getPurchasetime().substring(2, 10));
			i.setEndtime(i.getEndtime().substring(2, 10));
		} // end for

		if (cartsearchDto != null) {
			request.setAttribute("cartList", cartsearchDto);
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
		}
	}
	

	// 장바구니 바로 가기
	public void gobasket(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			CartDAO cartdao = new CartDAO();

			HttpSession session;
			session = request.getSession();
			String cusId = session.getAttribute("memberid").toString();

			List<CartDTO> cartsearchDto = cartdao.selectcartall(cusId);

			for (CartDTO i : cartsearchDto) {
				if (i.getReservation() != null) {
					if (i.getReservation().equals("1")) {
						i.setReservation("한번에 받기");
					} else
						i.setReservation("나눠서 받기");
				} else {
					continue;
				}
				i.setPurchasetime(i.getPurchasetime().substring(2, 10));
				i.setEndtime(i.getEndtime().substring(2, 10));
			} // end for

			if (cartsearchDto != null) {
				request.setAttribute("cartList", cartsearchDto);
				request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/jsp/cart/basket.jsp").forward(request, response);
			}

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);

		}

	}

}