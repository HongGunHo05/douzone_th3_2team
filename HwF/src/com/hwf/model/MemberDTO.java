package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO { // model

	private String memberid; 	// 회원 id
	private String memberpwd;   // 회원 pw
	private String membername;  // 회원 이름
	private String membersex;   // 회원 성별

	public MemberDTO(String memberid, String membername) {
		this.memberid = memberid;
		this.membername = membername;
	}

	public MemberDTO(String memberid, String membername, String membersex) {
		this.memberid = memberid;
		this.membername = membername;
		this.membersex = membersex;
	}
	
}
