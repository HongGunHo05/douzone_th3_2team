package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QnaDTO { // model

	private int qnaid;
	private String qnadate;
	private String qnatitle, qnacontent, qnaanswer, memberid;

	public QnaDTO(String qnatitle, String qnacontent, String memberid) {
		super();
		this.qnatitle = qnatitle;
		this.qnacontent = qnacontent;
		this.memberid = memberid;
	}

	public QnaDTO(String qnatitle, String qnacontent) {
		super();
		this.qnatitle = qnatitle;
		this.qnacontent = qnacontent;

	}
	
	public QnaDTO(String qnaanswer, int qnaid) {
		this.qnaanswer = qnaanswer;
		this.qnaid = qnaid;
	}
	
}
