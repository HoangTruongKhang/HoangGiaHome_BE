package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IReplyRepository extends JpaRepository<Reply, Integer>, JpaSpecificationExecutor<Reply> {
    Reply findById(int reply_id);
}
