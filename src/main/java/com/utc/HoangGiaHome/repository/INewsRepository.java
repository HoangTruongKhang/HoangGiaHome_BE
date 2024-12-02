package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface INewsRepository extends JpaRepository<News, Integer>, JpaSpecificationExecutor<News> {
    News findById(int new_id);
}
