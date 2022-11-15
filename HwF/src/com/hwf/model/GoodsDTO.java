//package com.hwf.model;
//
//import java.sql.Date;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//public class GoodsDTO { // model
//
//	/*************** HealthGoodsDTO (헬스용품) ***************/
//	
//	private int healthGoodsId;			//헬스용품 id
//	private String healthGoodsName;		//헬스용품 이름
//	private int healthGoodsPrice;		//헬스용품 가격
//	private int healthGoodsCategory;	//헬스용품 카테고리
//	private String healthGoodsImg;		//헬스용품 이미지
//	private String healthGoodsDetail;	//헬스용품 상세설명
//	private String healthGoodsLink; 	//인바디,설문 연결값
//
//	
//	//AdminController - AdminHealthGoodsUpdate()에서 필요한 생성자
//	public GoodsDTO (int healthGoodsId, String healthGoodsName, int healthGoodsPrice, int healthGoodsCategory, String healthGoodsImg, String healthGoodsDetail, String healthGoodsLink) {
//		super();
//		this.healthGoodsId = healthGoodsId;
//		this.healthGoodsName = healthGoodsName;
//		this.healthGoodsPrice = healthGoodsPrice;
//		this.healthGoodsCategory = healthGoodsCategory;
//		this.healthGoodsImg = healthGoodsImg;
//		this.healthGoodsDetail = healthGoodsDetail;
//		this.healthGoodsLink = healthGoodsLink;
//	}
//	
//	//AdminController - AdminHealthGoodsInsert()에서 필요한 생성자
//	public GoodsDTO(String healthGoodsName, int healthGoodsPrice, int healthGoodsCategory, String healthGoodsImg, String healthGoodsDetail, String healthGoodsLink) {
//		super();
//		this.healthGoodsName = healthGoodsName;
//		this.healthGoodsPrice = healthGoodsPrice;
//		this.healthGoodsCategory = healthGoodsCategory;
//		this.healthGoodsImg = healthGoodsImg;
//		this.healthGoodsDetail = healthGoodsDetail;
//		this.healthGoodsLink = healthGoodsLink;
//	}
//	
//	
//	
//	/*************** HealthFoodDTO (헬스식품) ***************/
//	
//	private int hfId;			    //헬스식품 id
//	private String hfName;			//헬스식품 이름
//	private int hfPrice;			//헬스식품 가격
//	private int hfCategory;			//헬스식품 카테고리
//	private String hfImg;			//헬스식품 이미지
//	private String hfDetail;		//헬스식품 상세설명
////	private java.sql.Date hfDom;    //헬스식품 제조날짜
////	private java.util.Date hfDom;   //헬스식품 제조날짜
////	private Date hfDom;				//헬스식품 제조날짜
//	private String hfDom;			//헬스식품 제조날짜
//	private String hfLink; 			//인바디,설문 연결값
//	
//	
//	//AdminController - AdminHealthFoodUpdate()에서 필요한 생성자
//	public GoodsDTO(int hfId, String hfName, int hfPrice, int hfCategory, String hfImg, String hfDetail, String hfDom, String hfLink) {
//		super();
//		this.hfId = hfId;
//		this.hfName = hfName;
//		this.hfPrice = hfPrice;
//		this.hfCategory = hfCategory;
//		this.hfImg = hfImg;
//		this.hfDetail = hfDetail;
//		this.hfDom = hfDom;
//		this.hfLink = hfLink;
//	}
//	
//	
//	//AdminController - AdminHealthFoodInsert()에서 필요한 생성자
//	public GoodsDTO(String hfName, int hfPrice, int hfCategory, String hfImg, String hfDetail, String hfDom, String hfLink) {
//		super();
//		this.hfName = hfName;
//		this.hfPrice = hfPrice;
//		this.hfCategory = hfCategory;
//		this.hfImg = hfImg;
//		this.hfDetail = hfDetail;
//		this.hfDom = hfDom;
//		this.hfLink = hfLink;
//	}
//	
//	
//	
//	
//	/*************** NutrientsDTO (영양제) ***************/
//	
//	private int nutrientsID; 		//영양제 id
//	private String nutrientsName;	//영양제 이름
//	private int nutrientsPrice;		//영양제 가격
//	private int nutrientsCategory;	//영양제 카테고리
//	private String nutrientsImg;	//영양제 이미지
//	private String nutrientsDetail;	//영양제 상세설명
//	private Date nutrientsDoM;		//영양제 제조날짜
//	private String dailyIntake;		//1일 섭취 갯수
//	private int numPerBottle;		//1통 당 갯수
//	private int remainingNum; 		//현재 잔여 갯수
//	private String nutrientsLink; 	//인바디,설문 연결값 (Link -> nutrientsLink로 변경)
//}
