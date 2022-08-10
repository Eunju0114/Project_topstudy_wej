package com.wej.exam.demo.reporsitory;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wej.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	public Article writeArticle(String title, String body);
	
	@Select("select * from article where id = #{id}")
	public Article getArticle(@Param("id") int id);
	
	@Select("select * from article")
	public List<Article> getArticles();

	public void deleteArticle(int id);
	
	public void modifyArticle(int id, String title, String body);

}
