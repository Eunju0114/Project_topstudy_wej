package com.wej.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wej.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public void writeArticle(@Param("memberId") int memberID,@Param("boardId") int boardId,  @Param("title") String title,@Param("body") String body);
	
	public Article getForPrintArticle(@Param("id") int id);
	
	public List<Article> getForPrintArticles(int boardId, int limitStart, int limitTake , String searchKeyword, String searchKeywordTypeCode);

	public void deleteArticle(@Param("id") int id);
	
	public void modifyArticle(@Param("id") int id,@Param("title") String title,@Param("body") String body);

	public int getLastInsertId();

	public int getArticlesCount(int boardId, String searchKeywordTypeCode, String searchKeyword);

	public Article getArticle(int id);

	public List<Article> getForArticleTitleBoardId1();
	
	public List<Article> getForArticleTitleBoardId2();

}
