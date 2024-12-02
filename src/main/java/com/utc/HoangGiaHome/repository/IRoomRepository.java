package com.utc.HoangGiaHome.repository;


import com.utc.HoangGiaHome.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRoomRepository extends JpaRepository<Room, Integer>, JpaSpecificationExecutor<Room> {
    Room findById(int room_id);
}
