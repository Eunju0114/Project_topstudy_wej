package com.wej.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wej.exam.demo.repository.ArticleRepository;
import com.wej.exam.demo.vo.Article;

@Service
public class ArticleService {

	private ArticleRepository articleRepository;

	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public int writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		
		return articleRepository.getLastInsertId();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

}
