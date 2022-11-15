package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseDTO {

	private int purchaseId; 		 // 구매 id
	private int purchaseNum; 		 // 구매 갯수
	private int purchasePrice; 		 // 구매 가격
	private String purchaseMethod;   // 결제 방식
	private String purchaseReceipt;  // 수령 방식 (즉시/예약)
	private String purchaseDate; 	 // 구매(결제) 날짜
	private String receiptStartDate; // 수령(픽업) 시작일
	private int receiptPeriod;		 // 수령(픽업) 기간
	private String healthgoodsID; 	 // 헬스용품 id (외래키)
	private String hfid; 			 // 식품 id (외래키)
	private String nutrientsID;		 // 영양제 id (외래키)
	private String memberID; 		 // 회원id (외래키)

	//영양제 구매
	public PurchaseDTO(int purchasePrice, String purchaseReceipt, String receiptStartDate, int receiptPeriod, String nutrientsID, String memberID) {
		super();
		this.purchasePrice = purchasePrice;
		this.purchaseReceipt = purchaseReceipt;
		this.receiptStartDate = receiptStartDate;
		this.receiptPeriod = receiptPeriod;
		this.nutrientsID = nutrientsID;
		this.memberID = memberID;
	}

	//헬스식품 구매
	public PurchaseDTO(int purchaseNum, int purchasePrice, String hfid, String memberID) {
		super();
		this.purchaseNum = purchaseNum;
		this.purchasePrice = purchasePrice;
		this.hfid = hfid;
		this.memberID = memberID;
	}

	//헬스용품 구매
	public PurchaseDTO(int purchaseNum, int purchasePrice, String purchaseReceipt, String healthgoodsID, String memberID) {
		super();
		this.purchaseNum = purchaseNum;
		this.purchasePrice = purchasePrice;
		this.purchaseReceipt = purchaseReceipt;
		this.healthgoodsID = healthgoodsID;
		this.memberID = memberID;
	}
}
