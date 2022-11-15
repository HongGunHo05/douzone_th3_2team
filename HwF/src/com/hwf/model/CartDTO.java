package com.hwf.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDTO {
	
	private int cartId; 		 // 장바구니 아이디
	private String memberId;	 // 고객 아이디
	private String productsId;	 // 물품 아이디
	private String productsName; // 물품 이름
	private String productsIMG;  // 물품 사진
	private int productsPrice;	 // 물품 가격
	private String reservation;  // 구매 방식 (즉시/예약)
	private String purchasetime; // 구매 날짜
	private String endtime; 	 // 수령이 끝나는 날짜

	public CartDTO(String memberId, String productsId, String productsName, String productsIMG, int productsPrice, String reservation, String purchasetime, String endtime) {
		super();
		this.memberId = memberId;
		this.productsId = productsId;
		this.productsName = productsName;
		this.productsIMG = productsIMG;
		this.productsPrice = productsPrice;
		this.reservation = reservation;
		this.purchasetime = purchasetime;
		this.endtime = endtime;
	}

	public CartDTO(String memberId, String productsId, String productsName, String productsIMG, int productsPrice) {
		super();
		this.memberId = memberId;
		this.productsId = productsId;
		this.productsName = productsName;
		this.productsIMG = productsIMG;
		this.productsPrice = productsPrice;
	}
	
}