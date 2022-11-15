package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class InbodyDTO {
	private int inbodyid;	     //인바디 id
	private int memberheight ;   //키
	private int memberweight;    //몸무게
	private String bodymuscle;   //근육량
	private String bodyfat;	     //체지방량
	private String inbodyresult; //상태 결과 bmi
	private String link;		 //결과 제품 추천용
	private String memberid;	 //회원id (외래키)

	public InbodyDTO(int memberheight,int memberweight,String bodymuscle,String bodyfat,String inbodyresult,String link,String memberid) {
		this.memberheight=memberheight;
		this.memberweight=memberweight;
		this.bodymuscle=bodymuscle;
		this.bodyfat=bodyfat;
		this.inbodyresult=inbodyresult;
		this.link=link;
		this.memberid=memberid;
	}
	
}
