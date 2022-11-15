package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NutrientsDTO {
	
/*************** NutrientsDTO (영양제) ***************/
	
	private int nutrientsID; 			//영양제 id
	private String nutrientsName;		//영양제 이름
	private int nutrientsPrice;			//영양제 가격
	private String nutrientsCategory;	//영양제 카테고리
	private String nutrientsIMG;		//영양제 이미지
	private String nutrientsDetail;		//영양제 상세설명
	private String nutrientsDOM;		//영양제 제조날짜
	private String dailyInTake;			//1일 섭취 갯수
	private int numperbottle;			//1통 당 갯수
	private int remainingNum; 			//현재 잔여 갯수
	private String link; 				//인바디,설문 연결값
	
	
	//AdminController - AdminNutrientsInsert()에서 필요한 생성자
	public NutrientsDTO(String nutrientsName, int nutrientsPrice, String nutrientsCategory, String nutrientsIMG, String nutrientsDetail, String nutrientsDOM, String dailyInTake, int numperbottle, int remainingNum, String link) {
		super();
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
