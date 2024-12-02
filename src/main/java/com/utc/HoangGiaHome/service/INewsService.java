package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.News;
import com.utc.HoangGiaHome.form.NewsFilterForm;

import java.util.List;

public interface INewsService {
    List<News> getAllNews(NewsFilterForm form);
    News getNewsById(int new_id);
}
