package com.example.test2.controller;

import com.example.test2.domain.Article;
import com.example.test2.dto.ArticleRequestDto;
import com.example.test2.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/articles")
    public Article createArticle(@RequestBody ArticleRequestDto requestDto){
        Article article = articleService.createArticle(requestDto);
        return article;
    }

    @GetMapping("/articles")
    public List<Article> getArticle(){
        return articleService.getArticle();
    }

    @DeleteMapping("/articles/{id}")
    public Long deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
        return id;
    }
}
