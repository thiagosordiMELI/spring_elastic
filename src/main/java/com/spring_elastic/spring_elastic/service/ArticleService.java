package com.spring_elastic.spring_elastic.service;

import com.spring_elastic.spring_elastic.model.Article;
import com.spring_elastic.spring_elastic.repository.IArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService{

    private final IArticleRepository articleRepository;

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAllArticles();
    }

    @Override
    public String deleteById(int id) {
        articleRepository.deleteById(id);
        return "Artigo removido com sucesso";
    }

    @Override
    public Article update(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Page<Article> getPageByTitle(String title, Pageable pg) {
        return articleRepository.findByTitle(title, pg);
    }
}
