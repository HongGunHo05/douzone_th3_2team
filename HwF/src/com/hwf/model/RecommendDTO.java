package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecommendDTO {

	// 헬스용품
	private int healthGoodsId, healthGoodsPrice, healthGoodsCategory;
	private String healthGoodsName, healthGoodsImg, healthGoodsDetail;

	// 식품
	private String hfname, hfimg, hfdetail, hfdom;
	private int hfid, hfprice, hecategory;

	// 영양제
	private int nutrientsID; 		  // 영양제 번호
	private String nutrientsName;	  // 영양제 이름
	private int nutrientsPrice; 	  // 영양제 가격
	private int nutrientsCategory;	  // 영양제 카테고리
	private String nutrientsIMG;	  // 영양제 사진 주소
	private String nutrientsDetail;	  // 영양제 설명
	private String nutrientsDOM;	  // 영양제 제조날짜
	private String dailyInTake;		  // 영양제 하루에 먹어야 하는 수량
	private int numperbottle; 		  // 영양제 한병에 있는 수량
	private int remainingNum;		  // 현재 잔여 갯수
	private String link;			  // 인바디, 설문 결과

	public RecommendDTO(int healthGoodsId, String healthGoodsName, int healthGoodsPrice, int healthGoodsCategory, String healthGoodsImg, String healthGoodsDetail, String link) {
		super();
		this.healthGoodsId = healthGoodsId;
		this.healthGoodsName = healthGoodsName;
		this.healthGoodsPrice = healthGoodsPrice;
		this.healthGoodsCategory = healthGoodsCategory;
		this.healthGoodsImg = healthGoodsImg;
		this.healthGoodsDetail = healthGoodsDetail;
		this.link = link;
	}

	public RecommendDTO(String hfname, String hfimg, String hfdetail, String hfdom, int hfid, int hfprice, int hecategory, String link) {
		super();
		this.hfname = hfname;
		this.hfimg = hfimg;
		this.hfdetail = hfdetail;
		this.hfdom = hfdom;
		this.hfid = hfid;
		this.hfprice = hfprice;
		this.hecategory = hecategory;
		this.link = link;
	}

	public RecommendDTO(int nutrientsID, String nutrientsName, int nutrientsPrice, int nutrientsCategory, String nutrientsIMG, String nutrientsDetail, String nutrientsDOM, String dailyInTake, int numperbottle, int remainingNum, String link) {
		super();
		this.nutrientsID = nutrientsID;
		this.nutrientsName = nutrientsName;
		this.nutrientsPrice = nutrientsPrice;
		this.nutrientsCategory = nutrientsCategory;
		this.nutrientsIMG = nutrientsIMG;
		this.nutrientsDetail = nutrientsDetail;
		this.nutrientsDOM = nutrientsDOM;
		this.dailyInTake = dailyInTake;
		this.numperbottle = numperbottle;
		this.remainingNum = remainingNum;
		this.link = link;
	}

	
}
