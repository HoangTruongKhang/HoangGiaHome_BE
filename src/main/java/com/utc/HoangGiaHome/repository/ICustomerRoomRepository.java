package com.utc.HoangGiaHome.repository;

import com.utc.HoangGiaHome.entity.CustomerRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICustomerRoomRepository extends JpaRepository<CustomerRoom, Integer>, JpaSpecificationExecutor<CustomerRoom> {
    CustomerRoom findById(int customerRoom_id);
}
