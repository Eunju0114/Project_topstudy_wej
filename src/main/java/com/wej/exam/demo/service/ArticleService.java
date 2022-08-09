package com.wej.exam.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wej.exam.demo.vo.Article;

@Service
public class ArticleService {
	
	private int articlesLastId;
	private List<Article> articles;
	
	public ArticleService() {
		articlesLastId = 0;
		articles = new ArrayList<>();
		
		makeTestData();
	}
	
	
	public void makeTestData() {
		for(int i =1; i<=10; i++) {
			String title = "제목" + i;
			String body = "내용" + i;
			
			writeArticle(title, body);
		}
	}

	public Article writeArticle(String title, String body) {
		int id = articlesLastId + 1;
		Article article = new Article(id, title, body);
		
		articles.add(article);
		articlesLastId = id;
		
		return article;
	}


	public List<Article> getArticles() {
		return articles;
	}
	


}
