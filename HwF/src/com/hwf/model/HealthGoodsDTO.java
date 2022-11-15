package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthGoodsDTO { // model

	/*************** HealthGoodsDTO (헬스용품) ***************/
	
	private int healthGoodsId;			//헬스용품 id
	private String healthGoodsName;		//헬스용품 이름
	private int healthGoodsPrice;		//헬스용품 가격
	private String healthGoodsCategory;	//헬스용품 카테고리
	private String healthGoodsImg;		//헬스용품 이미지
	private String healthGoodsDetail;	//헬스용품 상세설명
	private String link; 				//인바디,설문 연결값


	// AdminController - AdminHealthGoodsInsert()에서 필요한 생성자
	public HealthGoodsDTO(String healthGoodsName, int healthGoodsPrice, String healthGoodsCategory, String healthGoodsImg, String healthGoodsDetail, String link) {	
		super();
		this.healthGoodsName = healthGoodsName;
		this.healthGoodsPrice = healthGoodsPrice;
		this.healthGoodsCategory = healthGoodsCategory;
		this.healthGoodsImg = healthGoodsImg;
		this.healthGoodsDetail = healthGoodsDetail;
		this.link = link;
	}
}