package com.wej.exam.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wej.exam.demo.service.MemberService;
import com.wej.exam.demo.utill.Ut;
import com.wej.exam.demo.vo.Member;

@Controller
public class UsrMemberController {

	private MemberService memberService;

	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		if (Ut.empty(loginId)) {
			return "loginId(을)를 입력해주세요.";
		}

		if (Ut.empty(loginPw)) {
			return "loginPw(을)를 입력해주세요.";
		}

		if (Ut.empty(name)) {
			return "name(을)를 입력해주세요.";
		}

		if (Ut.empty(nickname)) {
			return "nickname(을)를 입력해주세요.";
		}

		if (Ut.empty(cellphoneNo)) {
			return "cellphoneNo(을)를 입력해주세요.";
		}

		if (Ut.empty(email)) {
			return "email(을)를 입력해주세요.";
		}

		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

		if (id == -1) {
			return Ut.f("해당 로그인아이디(%s)는 이미 사용중입니다.", loginId);
		}
		
		if (id == -2) {
			return Ut.f("해당 이름(%s)과 이메일(%s)은 이미 사용중입니다.", name, email);
		}

		Member member = memberService.getMemberById(id);

		return member;
	}
	
	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public Object doLogin(HttpSession httpsession, String loginId, String loginPw) {
		
		boolean isLogined = false;
		
		if(httpsession.getAttribute("loginedMemberId") != null) {
			isLogined = true;
		}
		
		if(isLogined) {
			return "이미 로그인되었습니다.";
		}
		

		if ( Ut.empty(loginId) ) {
			return "loginId(을)를 입력해주세요.";
		}
		
		if ( Ut.empty(loginPw) ) {
			return "loginPw(을)를 입력해주세요.";
		}
		
		Member member = memberService.getMemberByLoginId(loginId);
		
		if(member == null ) {
			return "존재하지 않은 로그인 아이디입니다.";
		}
		
		if(member.getLoginPw().equals(loginPw) == false) {
			return "비밀번호가 일치하지 않습니다.";
		}
		
		httpsession.setAttribute("loginedMemberId", member.getId());
		
		return Ut.f("%s님 환영합니다.", member.getNickname());
	}

}
