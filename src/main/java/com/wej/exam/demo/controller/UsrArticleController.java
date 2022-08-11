package com.wej.exam.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wej.exam.demo.service.ArticleService;
import com.wej.exam.demo.utill.Ut;
import com.wej.exam.demo.vo.Article;

@Controller
public class UsrArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping("usr/article/doAdd")
	@ResponseBody
	public Object doAdd(HttpSession httpSession, String title, String body) {
		boolean isLogined = false;
		int loginedMemberId = 0;

		if ( httpSession.getAttribute("loginedMemberId") != null ) {
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}

		if ( isLogined == false ) {
			return "로그인 후 이용해주세요.";
		}
		
		if ( Ut.empty(title) ) {
			return "title(을)를 입력해주세요.";
		}
		
		if ( Ut.empty(body) ) {
			return "body(을)를 입력해주세요.";
		}
		
		int id = articleService.writeArticle(loginedMemberId, title, body);
		
		Article article = articleService.getArticle(id);
		
		return article;
	}

	@RequestMapping("usr/article/getArticle")
	@ResponseBody
	public Object getArticle(int id) {

		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물은 존재하지 않습니다.";
		}

		return article;
	}

	@RequestMapping("usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}

	@RequestMapping("usr/article/doDelete")
	@ResponseBody
	public String doDelete(HttpSession httpSession, int id) {
		
		boolean isLogined = false;
		int loginedMemberId = 0;

		if ( httpSession.getAttribute("loginedMemberId") != null ) {
			isLogined = true;
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}
		
		if( isLogined == false ) {
			return "로그인 후 이용해주세요.";
		}

		Article article = articleService.getArticle(id);
		
		if(article.getMemberId() != loginedMemberId) {
			return "권한이 없습니다.";
		}

		if (article == null) {
			return id + "번 게시물이 존재하지 않습니다.";
		}

		articleService.deleteArticle(id);

		return id + "번 게시물을 삭제하였습니다.";
	}

	@RequestMapping("usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);

		if (article == null) {
			return id + "번 게시물이 존재하지 않습니다.";
		}

		articleService.modifyArticle(id, title, body);

		return id + "번 게시물을 수정하였습니다.";
	}
}
