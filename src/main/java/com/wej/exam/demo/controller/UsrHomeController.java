package com.wej.exam.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wej.exam.demo.service.ArticleService;
import com.wej.exam.demo.service.BoardService;
import com.wej.exam.demo.vo.Article;
import com.wej.exam.demo.vo.Board;
import com.wej.exam.demo.vo.Rq;

@Controller
public class UsrHomeController {

	@Autowired
	private ArticleService articleService;
	private BoardService boardService;
	private Rq rq;

	public UsrHomeController(ArticleService articleService, BoardService boardService, Rq rq) {
		this.articleService = articleService;
		this.boardService = boardService;
		this.rq = rq;

	}

	@RequestMapping("/usr/home/main")
	public String showMain(Model model) {

		List<Article> articles1 = articleService.getForArticleTitleBoardId1();
		List<Article> articles2 = articleService.getForArticleTitleBoardId2();

		model.addAttribute("articles1", articles1);
		model.addAttribute("articles2", articles2);

		return "usr/home/main";
	}

	@RequestMapping("/")
	public String showRoot() {
		return "redirect:/usr/home/main";
	}
}
