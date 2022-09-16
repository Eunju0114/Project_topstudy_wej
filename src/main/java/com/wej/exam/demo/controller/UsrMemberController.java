package com.wej.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wej.exam.demo.service.MemberService;
import com.wej.exam.demo.utill.Ut;
import com.wej.exam.demo.vo.Member;
import com.wej.exam.demo.vo.ResultData;
import com.wej.exam.demo.vo.Rq;

@Controller
public class UsrMemberController {

	private MemberService memberService;
	private Rq rq;

	public UsrMemberController(MemberService memberService, Rq rq) {
		this.memberService = memberService;
		this.rq = rq;
	}

	@RequestMapping("/usr/member/join")
	public String showJoin() {
		return "usr/member/join";
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public String doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email,
			@RequestParam(defaultValue = "/") String afterLoginUri) {
		if (Ut.empty(loginId)) {
			return rq.jsHistoryBack("F-1", "loginId(을)를 입력해주세요.");
		}

		if (Ut.empty(loginPw)) {
			return rq.jsHistoryBack("F-2", "loginPw(을)를 입력해주세요.");
		}

		if (Ut.empty(name)) {
			return rq.jsHistoryBack("F-3", "name(을)를 입력해주세요.");
		}

		if (Ut.empty(nickname)) {
			return rq.jsHistoryBack("F-4", "nickname(을)를 입력해주세요.");
		}

		if (Ut.empty(cellphoneNo)) {
			return rq.jsHistoryBack("F-5", "cellphoneNo(을)를 입력해주세요.");
		}

		if (Ut.empty(email)) {
			return rq.jsHistoryBack("F-6", "email(을)를 입력해주세요.");
		}

		ResultData<Integer> joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);

		if (joinRd.isFail()) {
			return rq.jsHistoryBack(joinRd.getResultCode(), joinRd.getMsg());
		}

		String afterJoinUri = "../member/login?afterLoginUri=" + Ut.getUriEncoded(afterLoginUri);

		return rq.jsReplace("회원가입이 완료되었습니다. 로그인 후 이용해주세요.", afterJoinUri);
	}

	@RequestMapping("/usr/member/doLogout")
	@ResponseBody
	public String doLogout() {

		if (!rq.isLogined()) {
			return rq.jsHistoryBack("이미 로그아웃 상태입니다.");
		}

		rq.logout();

		return rq.jsReplace("로그아웃 되었습니다.", "/");
	}

	@RequestMapping("/usr/member/login")
	public String showLogin() {
		return "usr/member/login";
	}

	@RequestMapping("/usr/member/doLogin")
	@ResponseBody
	public String doLogin(String loginId, String loginPw) {
		if (rq.isLogined()) {
			return rq.jsHistoryBack("이미 로그인되었습니다.");
		}

		if (Ut.empty(loginId)) {
			return rq.jsHistoryBack("loginId(을)를 입력해주세요.");
		}

		if (Ut.empty(loginPw)) {
			return rq.jsHistoryBack("loginPw(을)를 입력해주세요.");
		}

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			return rq.jsHistoryBack("존재하지 않은 로그인아이디 입니다.");
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			return rq.jsHistoryBack("비밀번호가 일치하지 않습니다.");
		}

		rq.login(member);

		return rq.jsReplace(Ut.f("%s님 환영합니다.", member.getNickname()), "/");
	}
}
