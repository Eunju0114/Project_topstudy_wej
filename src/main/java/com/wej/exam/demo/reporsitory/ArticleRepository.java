package com.wej.exam.demo.reporsitory;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wej.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {

	// @Insert("insert into article set regDate = now(), updateDate = now(), title = #{title}, `body`=#{body}")
	public Article writeArticle(@Param("title") String title,@Param("body") String body);
	
	@Select("select * from article where id = #{id}")
	public Article getArticle(@Param("id") int id);
	
	@Select("select * from article")
	public List<Article> getArticles();

	@Delete("delete from article where id = #{id}")
	public void deleteArticle(@Param("id") int id);
	
	@Update("update article set title = #{title}, `body`= #{body}, updateDate = now()  where id = #{id}")
	public void modifyArticle(@Param("id") int id,@Param("title") String title,@Param("body") String body);

}
