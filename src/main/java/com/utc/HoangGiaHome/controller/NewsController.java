package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.NewsDTO;
import com.utc.HoangGiaHome.entity.News;
import com.utc.HoangGiaHome.form.NewsFilterForm;
import com.utc.HoangGiaHome.service.INewsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {
    @Autowired
    private INewsService newsService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<NewsDTO> getAllNews(NewsFilterForm form){
        List<News> news = newsService.getAllNews(form );
        return modelMapper.map(news, new TypeToken<List<NewsDTO>>(){}.getType());
    }

    @GetMapping("{new_id}")
    public NewsDTO  getNewsById(@PathVariable int new_id){
        News news = newsService.getNewsById(new_id);
        return modelMapper.map(news, NewsDTO.class);
    }

}
