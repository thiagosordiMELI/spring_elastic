package com.spring_elastic.spring_elastic.repository;

import com.spring_elastic.spring_elastic.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IArticleRepository extends ElasticsearchRepository<Article, Integer> {
    @Query("{ \"match_all\": {} }")
    List<Article> findAllArticles();

    @Query("{\"match\": {\"title\": {\"query\": \"?0\"}}}")
    Page<Article> findByTitle(String title, Pageable pg);
}
