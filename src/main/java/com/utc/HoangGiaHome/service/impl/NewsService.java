package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Contract;
import com.utc.HoangGiaHome.entity.News;
import com.utc.HoangGiaHome.form.NewsFilterForm;
import com.utc.HoangGiaHome.repository.INewsRepository;
import com.utc.HoangGiaHome.service.INewsService;
import com.utc.HoangGiaHome.specification.ContractSpecification;
import com.utc.HoangGiaHome.specification.NewsSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsService implements INewsService {
    @Autowired
    private INewsRepository newsRepository;
    @Override
    public List<News> getAllNews(NewsFilterForm form) {
        Specification<News> where = NewsSpecification.buildWhere(form);
        return newsRepository.findAll(where);
    }

    @Override
    public News getNewsById(int new_id) {
        return newsRepository.findById(new_id);
    }
}
