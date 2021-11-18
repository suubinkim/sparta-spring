package com.example.test2.service;

import com.example.test2.domain.Article;
import com.example.test2.dto.ArticleRequestDto;
import com.example.test2.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> getArticle(){
        return articleRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public Article createArticle(ArticleRequestDto requestDto){
        Article article = new Article(requestDto);
        articleRepository.save(article);
        return article;
    }

    @Transactional
    public Long deleteArticle(Long id){
        articleRepository.deleteById(id);
        return id;
    }
}
