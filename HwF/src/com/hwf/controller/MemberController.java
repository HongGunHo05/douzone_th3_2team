package com.hwf.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwf.dao.InbodyDAO;
import com.hwf.dao.MemberDAO;
import com.hwf.dao.PurchaseDAO;
import com.hwf.dao.QnaDAO;
import com.hwf.dao.RecommendDAO;
import com.hwf.dao.SurveyDAO;
import com.hwf.model.HealthFoodDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.InbodyDTO;
import com.hwf.model.MemberDTO;
import com.hwf.model.NutrientsDTO;
import com.hwf.model.PurchaseDTO;
import com.hwf.model.QnaDTO;
import com.hwf.model.SurveyDTO;

@WebServlet("/Member")
public class MemberController extends HttpServlet {
	@Inject
	MemberDAO MemberDao;

	public MemberController() {
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");

		System.out.println("cmd : " + cmd);
		if (cmd.equals("login")) {
			login(request, response);
		} else if (cmd.equals("logincheck")) {
			logincheck(request, response);
		} else if (cmd.equals("join")) {
			join(request, response);
		} else if (cmd.equals("self")) {
			self(request, response);
		} else if (cmd.equals("mypage")) {
			mypage(request, response);
		} else if (cmd.equals("insertmember")) {
			insertmember(request, response);
		} else if (cmd.equals("logout")) {
			logout(request, response);
		} else if (cmd.equals("purchaselist")) {
			purchaselist(request, response);
		} else if (cmd.equals("survey")) {
			survey(request, response);
		} else if (cmd.equals("surveylist")) {
			surveylist(request, response);
		} else if (cmd.equals("surveyresult")) {
			surveyresult(request, response);
		} else if (cmd.equals("surveyDelete")) {
			surveyDelete(request, response);
		} else if (cmd.equals("inbody")) {
			inbody(request, response);
		} else if (cmd.equals("inbodylist")) {
			inbodylist(request, response);
		} else if (cmd.equals("inbodyDelete")) {
			inbodyDelete(request, response);
		} else if (cmd.equals("inbodyresult")) {
			inbodyresult(request, response);
		} else if (cmd.equals("membersearch")) { // 고객 게시글 조회
			membersearch(request, response);
		} else if (cmd.equals("membersearchboard")) { // 고객 게시글 내용 검색
			membersearchboard(request, response);
		} else if (cmd.equals("memberwriteboard")) { // 고객 게시글 작성
			memberwriteboard(request, response);
		} else
			System.out.println("service code error");
	}

	//로그인 이전에 했는지 안했는지 확인
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session;
			session = request.getSession();
			session.setAttribute("logincheck", true);
			String name = session.getAttribute("membername1").toString();
			System.out.println(name);
			if (name.equalsIgnoreCase("환영합니다. 고객님"))
				request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		} catch (Exception e) {
			//null 이면 에러 발생 = 로그인 기록 없음
			//System.out.println("login 기록 없음");
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/views/jsp/member/mypage.jsp").forward(request, response);
	}

	//로그인 정보 확인
	public void logincheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		session = request.getSession();
		String memberid = request.getParameter("memberid");
		String memberpwd = request.getParameter("memberpwd");

		MemberDTO dto = new MemberDTO(memberid, memberpwd); // 회원 id와 pwd를 세팅
		MemberDAO dao = new MemberDAO();

		// boolean check = dao.checkMemberb(dto);
		// List<MemberDTO> list = dao.checkMember(dto);
		try {
			MemberDTO dto2 = dao.checkMember(dto);

		} catch (Exception e) {
			session.setAttribute("logincheck", false);
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		MemberDTO dto2 = dao.checkMember(dto);

		//비밀번호 체크
		if (memberpwd.equals(dto2.getMemberpwd()))
			
			// 관리자 로그인
			if (dto2.getMemberid().equals("admin")) {
				request.getRequestDispatcher("/AdminMain.jsp").forward(request, response);
			}
		{

		//비밀번호 체크
		if (memberpwd.equals(dto2.getMemberpwd()))
		{	
			String membersex = "";

			if (dto2.getMembersex().equals("1"))
				membersex = "남자";
			else
				membersex = "여자";

			// data save
			session.setAttribute("memberid", memberid);
			session.setAttribute("membername", dto2.getMembername());
			session.setAttribute("membername1", dto2.getMembername() + "님 환영합니다.");
			session.setAttribute("membersex", membersex);
			session.setAttribute("logincheck", true);

			// 세션 유지시간 설정(초단위) 20분
			session.setMaxInactiveInterval(20 * 60);

			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		} else {
			session.setAttribute("logincheck", false);
			session.setMaxInactiveInterval(20 * 60);
			System.out.println("비밀번호가 틀렸습니다.");
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
	}}

	//회원가입 인증으로 이동
	public void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		session = request.getSession();
		session.setAttribute("joincheck", true);
		request.getRequestDispatcher("/views/jsp/member/join.jsp").forward(request, response);

	}

	//회원가입 가기전 본인인증
	public void self(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session;
		session = request.getSession();
		session.setAttribute("joincheck", true);
		request.getRequestDispatcher("/views/jsp/member/self.jsp").forward(request, response);

	}

	//회원가입 + 정규 표현식
	public void insertmember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session;
		session = request.getSession();

		System.out.println("회원 가입 실행");
		String memberid = request.getParameter("userid");
		String memberpwd = request.getParameter("passwd");
		String membername = request.getParameter("name");
		String membersex = request.getParameter("sex");

		String pattern = "^[\\uac00-\\ud7a3]*$"; // 숫자만 등장하는지

		boolean result0 = Pattern.matches(pattern, membername);
		System.out.println("이름" + result0); // true

		pattern = "^[a-z][a-z0-9_$@#]{4,9}$";
		boolean result1 = Pattern.matches(pattern, memberid);
		System.out.println("아이디" + result1); // true

		pattern = "^(?=.*[a-z])(?=.*[_!@#$%^&*]|.*[0-9]).{4,9}$";
		boolean result2 = Pattern.matches(pattern, memberpwd);
		System.out.println("비번" + result2); // true

		if (result0 == false || result1 == false || result2 == false) {
			request.getRequestDispatcher("/views/jsp/member/join.jsp").forward(request, response);
		} else {

			MemberDTO dto = new MemberDTO(memberid, memberpwd, membername, membersex); // 회원 id와 pwd를 세팅

			MemberDAO dao = new MemberDAO();

			int rowcount = dao.insert(dto);

			if (rowcount > 0) {
				System.out.println("회원가입 성공");
				session.setAttribute("joincheck", true);
				// 성공
				request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
			} else {
				System.out.println("회원가입 실패");
				// 있는 아이디면 오류
				session.setAttribute("joincheck", false);
				request.getRequestDispatcher("/views/jsp/member/join.jsp").forward(request, response);

			}
		}
	}

	//구매 목록 가기
	public void purchaselist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session;
			session = request.getSession();

			String name = session.getAttribute("membername1").toString();
			System.out.println(name);
			if (name.equalsIgnoreCase("환영합니다. 고객님")) {
				request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);

			}
		} catch (Exception e) {
			// null 이면 에러 발생 = 로그인 기록 없음
			System.out.println("login error");
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		HttpSession session;
		session = request.getSession();
		String memberid = session.getAttribute("memberid").toString();

		PurchaseDAO dao = new PurchaseDAO();

		System.out.println("구매 목록 : " + memberid);
		List<PurchaseDTO> PurchaseSelectMemberid = dao.selectmemberid(memberid);

		if (PurchaseSelectMemberid != null) {

			request.setAttribute("PurchaseSelectMemberid", PurchaseSelectMemberid);
			request.getRequestDispatcher("/views/jsp/member/purchaselist.jsp").forward(request, response);
		} else

		{
			// 구매 목록이 없습니다.
			mypage(request, response);
		}

	}

	//설문조사 페이지로 이동
	public void survey(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/member/survey.jsp").forward(request, response);

	}

	//설문조사 결과 삭제
	public void surveyDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int surveyid = Integer.parseInt(request.getParameter("surveyid"));
		SurveyDAO dao = new SurveyDAO();
		int resultSurveyDelete = dao.SurveyDelete(surveyid);
		if (resultSurveyDelete > 0) {
			HttpSession session;
			session = request.getSession();

			String memberid = session.getAttribute("memberid").toString();
			System.out.println(memberid);
			List<SurveyDTO> SurveyserachAll = dao.serachAll(memberid);

			if (SurveyserachAll != null) {
				request.setAttribute("SurveyserachAll", SurveyserachAll);
				// System.out.println(SurveyserachAll.get(0).toString());

				request.getRequestDispatcher("/views/jsp/member/surveylist.jsp").forward(request, response);
			} else {

				response.sendRedirect("views/error.jsp");
			}
		}
	}

	//설문조사 리스트
	public void surveylist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session;
			session = request.getSession();

			String name = session.getAttribute("membername1").toString();
			System.out.println(name);
			if (name.equalsIgnoreCase("환영합니다. 고객님")) {
				request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);

			}
		} catch (Exception e) {
			// null 이면 에러 발생 = 로그인 기록 없음
			System.out.println("login error");
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
		HttpSession session;
		session = request.getSession();
		String memberid = session.getAttribute("memberid").toString();

		SurveyDAO dao = new SurveyDAO();

		System.out.println(memberid);
		List<SurveyDTO> SurveyserachAll = dao.serachAll(memberid);

		if (SurveyserachAll != null) {
			request.setAttribute("SurveyserachAll", SurveyserachAll);
			// System.out.println(SurveyserachAll.get(0).toString());

			request.getRequestDispatcher("/views/jsp/member/surveylist.jsp").forward(request, response);
		} else {

			response.sendRedirect("views/error.jsp");
		}

	}

	//설문조사 결과조회
	public void surveyresult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session;
		session = request.getSession();

		session.setMaxInactiveInterval(20 * 60);

		String goal = request.getParameter("goal");
		String currentstate = request.getParameter("currentstate");
		String currentintke = request.getParameter("currentintke");
		String memberid = session.getAttribute("memberid").toString();
		String link = "";

		if (goal.equals("1")) {
			link = "증량";
			goal = "증량";
			session.setAttribute("link", link);
			session.setAttribute("goal", goal);
		} else if (goal.equals("2")) {
			link = "다이어트";
			goal = "감량";
			session.setAttribute("link", link);
			session.setAttribute("goal", goal);
		}

		if (currentstate.equals("1")) {
			currentstate = "비만";
			session.setAttribute("currentstate", currentstate);
		} else if (currentstate.equals("2")) {
			currentstate = "정상";
			session.setAttribute("currentstate", currentstate);
		} else if (currentstate.equals("3")) {
			currentstate = "왜소";
			session.setAttribute("currentstate", currentstate);
		}

		if (currentintke.equals("1")) {
			currentintke = "과다";
			session.setAttribute("currentintke", currentintke);
		} else if (currentintke.equals("2")) {
			currentintke = "정상";
			session.setAttribute("currentintke", currentintke);
		} else if (currentintke.equals("3")) {
			currentintke = "부족";
			session.setAttribute("currentintke", currentintke);
		}
		memberid = session.getAttribute("memberid").toString();
		System.out.println(goal);
		System.out.println(currentstate);
		System.out.println(currentintke);
		System.out.println(memberid);

		SurveyDTO dto = new SurveyDTO(goal, currentstate, currentintke, link, memberid);
		SurveyDAO dao = new SurveyDAO();

		int rowcount = dao.insert(dto);

		// 컬럼명
		String column = "";
		String keyvalue = link;
		System.out.println(column + " / " + keyvalue);

		Map<String, String> map = new HashMap<>(); // collection
		map.put("column", column); // column : title or writer or contnet
		map.put("keyvalue", keyvalue); // keyvalue : 김연아

		RecommendDAO dao1 = new RecommendDAO();

		List<HealthGoodsDTO> HealthGoodsSelect = dao1.suverysearchingHealthGoods(map);
		List<HealthFoodDTO> HealthFoodSelect = dao1.suverysearchingHealthFood(map);
		List<NutrientsDTO> NutrientsSelect = dao1.suverysearchingNutrients(map);

		System.out.println("왔습니다 컨트롤러 survey");

		if (rowcount > 0) {
			if (HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {
				request.setAttribute("HealthGoodsSelect", HealthGoodsSelect);
				request.setAttribute("HealthFoodSelect", HealthFoodSelect);
				request.setAttribute("NutrientsSelect", NutrientsSelect);

				request.getRequestDispatcher("/views/jsp/recommend/recommendpage.jsp").forward(request, response);

			}
			System.out.println("데베에 들어가고 검색값은 없음");
		} else {

			request.getRequestDispatcher("/views/jsp/member/survey.jsp").forward(request, response);
		}

	}

	//인바디 페이지로 이동
	public void inbody(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/member/inbody.jsp").forward(request, response);

	}

	//인바디 결과 삭제
	public void inbodyDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int inbodyid = Integer.parseInt(request.getParameter("inbodyid"));
		InbodyDAO dao = new InbodyDAO();
		System.out.println("인바디 삭제");
		int resultInbodyDelete = dao.InbodyDelete(inbodyid);

		if (resultInbodyDelete > 0) {
			HttpSession session;
			session = request.getSession();

			String memberid = session.getAttribute("memberid").toString();
			System.out.println(memberid);
			List<InbodyDTO> InbodyserachAll = dao.serachAll(memberid);

			if (InbodyserachAll != null) {
				request.setAttribute("InbodyserachAll", InbodyserachAll);

				request.getRequestDispatcher("/views/jsp/member/inbodylist.jsp").forward(request, response);
			} else {

				response.sendRedirect("views/error.jsp");
			}
		}
	}

	//인바디 결과 조회
	public void inbodylist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session;
			session = request.getSession();

			String name = session.getAttribute("membername1").toString();
			System.out.println(name);
			if (name.equalsIgnoreCase("환영합니다. 고객님")) {
				request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);

			}
		} catch (Exception e) {
			// null 이면 에러 발생 = 로그인 기록 없음
			System.out.println("login error");
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}

		HttpSession session;
		session = request.getSession();
		String memberid = session.getAttribute("memberid").toString();

		InbodyDAO dao = new InbodyDAO();

		System.out.println(memberid);
		List<InbodyDTO> InbodyserachAll = dao.serachAll(memberid);

		if (InbodyserachAll != null) {
			request.setAttribute("InbodyserachAll", InbodyserachAll);

			request.getRequestDispatcher("/views/jsp/member/inbodylist.jsp").forward(request, response);
		} else {

			response.sendRedirect("views/error.jsp");
		}

	}

	//인바디 시 제품 추천
	public void inbodyresult(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session;
		session = request.getSession();

		session.setMaxInactiveInterval(20 * 60);

		String memberheight = request.getParameter("memberheight"); // 키
		String memberweight = request.getParameter("memberweight"); // 몸무게
		String bodymuscle = request.getParameter("bodymuscle"); // 근육량
		String bodyfat = request.getParameter("bodyfat"); // 체지방량
		String inbodyresult = "";// 상태 결과 bmi
		String link = "";
		double iresult = Double.parseDouble(memberweight)
				/ ((Double.parseDouble(memberheight) / 100) * (Double.parseDouble(memberheight) / 100));

		inbodyresult = String.format("%.2f", iresult);

		int ir = (int) (iresult * 10);
		System.out.println("ir" + ir);

		if (ir < 185) {// 저체중
			link = "증량";
		} else if (185 <= ir && ir < 229) {// 정상
			link = "둘다";
		} else {// 과체중
			link = "다이어트";
		}
		if (20 < Integer.parseInt(bodyfat)) {
			link = "다이어트";
		}
		String memberid = session.getAttribute("memberid").toString();

		InbodyDTO dto = new InbodyDTO(Integer.parseInt(memberheight), Integer.parseInt(memberweight), bodymuscle,
				bodyfat, inbodyresult, link, memberid);
		InbodyDAO dao = new InbodyDAO();
		int rowcount = dao.insert(dto);

		// 컬럼명
		String column = "";
		String keyvalue = link;
		System.out.println(column + " / " + keyvalue);

		Map<String, String> map = new HashMap<>(); // collection
		map.put("column", column); // column : title or writer or contnet
		map.put("keyvalue", keyvalue); // keyvalue : 김연아

		RecommendDAO dao1 = new RecommendDAO();
		List<HealthGoodsDTO> HealthGoodsSelect = dao1.inbodysearchingHealthGoods(map);
		List<HealthFoodDTO> HealthFoodSelect = dao1.inbodysearchingHealthFood(map);
		List<NutrientsDTO> NutrientsSelect = dao1.inbodysearchingNutrients(map);

		System.out.println("왔습니다 컨트롤러 inbody : " + HealthGoodsSelect);
		if (rowcount > 0) {
			if (HealthGoodsSelect != null || HealthFoodSelect != null || NutrientsSelect != null) {

				session.setAttribute("memberheight", memberheight);
				session.setAttribute("memberweight", memberweight);
				session.setAttribute("bodymuscle", bodymuscle);
				session.setAttribute("bodyfat", bodyfat);
				session.setAttribute("inbodyresult", inbodyresult);
				session.setAttribute("link", link);
				session.setAttribute("memberid", memberid);

				request.setAttribute("HealthGoodsSelect", HealthGoodsSelect);
				request.setAttribute("HealthFoodSelect", HealthFoodSelect);
				request.setAttribute("NutrientsSelect", NutrientsSelect);
				request.getRequestDispatcher("/views/jsp/recommend/inbodyrecommend.jsp").forward(request, response);
//				
			}
			System.out.println("인바디 저장 완료 추천 없음");
		} else {

			request.getRequestDispatcher("/views/jsp/member/inbody.jsp").forward(request, response);
		}

	}

	public void mypage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/views/jsp/member/mypage.jsp").forward(request, response);

	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session;
			session = request.getSession();
			session.setAttribute("membername1", "환영합니다. 고객님");
			session.setAttribute("membername", "");
			session.setAttribute("memberid", "");
			session.setAttribute("membersex", "");
			session.setAttribute("logincheck", true);

		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}

		request.getRequestDispatcher("/Main.jsp").forward(request, response);
	}

	// membersearch - 고객 1:1 문의 게시글
	public void membersearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session;
			session = request.getSession();
	
			session.setMaxInactiveInterval(20 * 60);
			String memberid = session.getAttribute("memberid").toString();
	
			String column = "memberid";
			String keyvalue = memberid;
	
			Map<String, String> map = new HashMap<>();
			map.put("column", column);
			map.put("keyvalue", keyvalue);
	
			QnaDAO dao = new QnaDAO();
	
			List<QnaDTO> list = dao.getSearchList(map);
			if (list != null) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("/views/jsp/qna/list.jsp").forward(request, response);
			} else {
				response.sendRedirect("views/error.jsp");
			}
			
		} catch (Exception e) {
			request.getRequestDispatcher("/views/jsp/member/login.jsp").forward(request, response);
		}
	}

	// 고객 게시글 부분 조회(본인이 작성한 게시물 중 특정 단어 검색)
	public void membersearchboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 컬럼명

		HttpSession session;
		session = request.getSession();

		session.setMaxInactiveInterval(20 * 60);
		String memberid = session.getAttribute("memberid").toString();

		String column = request.getParameter("column");
		String keyvalue = request.getParameter("keyvalue");

		System.out.println("column : " + column);
		System.out.println("keyvalue : " + keyvalue);
		System.out.println("memberid : " + memberid);
		System.out.println(column + " / " + keyvalue + " / " + memberid);

		Map<String, String> map = new HashMap<>();
		map.put("column", column);
		map.put("keyvalue", keyvalue);
		map.put("memberid", memberid);

		QnaDAO dao = new QnaDAO();

		List<QnaDTO> list = dao.getMemberSearchList(map);
		if (list != null) {
			request.setAttribute("list", list);

			System.out.println("list : " + list);
			request.getRequestDispatcher("/views/jsp/qna/list.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/error.jsp");
		}
	}

	// 고객 게시판에 글 작성
	public void memberwriteboard(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session;
		session = request.getSession();

		session.setMaxInactiveInterval(20 * 60);
		String memberid = session.getAttribute("memberid").toString();

		String qnatitle = request.getParameter("qnatitle");
		String qnacontent = request.getParameter("qnacontent");

		QnaDAO dao = new QnaDAO();
		QnaDTO dto = new QnaDTO(qnatitle, qnacontent, memberid);
		System.out.println(dto);
		int rowcount = dao.insert(dto);
		System.out.println(dao);

		if (rowcount > 0) {
			response.sendRedirect("Member?cmd=membersearch");
		} else {
			response.sendRedirect("/views/jsp/error.jsp");
		}
	} // write end

}