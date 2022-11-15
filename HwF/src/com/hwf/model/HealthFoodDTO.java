package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthFoodDTO {
	
	/*************** HealthFoodDTO (헬스식품) ***************/
	
	private int hfid;			    //헬스식품 id
	private String hfName;			//헬스식품 이름
	private int hfPrice;			//헬스식품 가격
	private String hfCategory;		//헬스식품 카테고리
	private String hfIMG;			//헬스식품 이미지
	private String hfDetail;		//헬스식품 상세설명
	private String hfDoM;			//헬스식품 제조날짜
	private String link; 			//인바디,설문 연결값
	
	
	//AdminController - AdminHealthFoodInsert()에서 필요한 생성자
	public HealthFoodDTO(String hfName, int hfPrice, String hfCategory, String hfIMG, String hfDetail, String hfDoM, String link) {
		super();
		this.hfName = hfName;
		this.hfPrice = hfPrice;
		this.hfCategory = hfCategory;
		this.hfIMG = hfIMG;
		this.hfDetail = hfDetail;
		this.hfDoM = hfDoM;
		this.link = link;
	}

}
