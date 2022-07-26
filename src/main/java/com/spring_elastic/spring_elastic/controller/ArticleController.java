package com.spring_elastic.spring_elastic.controller;

import com.spring_elastic.spring_elastic.model.Article;
import com.spring_elastic.spring_elastic.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping
    public ResponseEntity<Article> save(@RequestBody Article article){
        return ResponseEntity.ok(articleService.save(article));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> findById(@PathVariable int id){
        return ResponseEntity.ok(articleService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Article>> findAll(){
        return ResponseEntity.ok(articleService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return ResponseEntity.ok(articleService.deleteById(id));
    }

    @PutMapping
    public ResponseEntity<Article> update(@RequestBody Article article){
        return ResponseEntity.ok(articleService.update(article));
    }

    @GetMapping("/title/{title}")
    public Page<Article> getPageByTitle(@PathVariable String title, Pageable pg){
        return articleService.getPageByTitle(title, pg);
    }
}
