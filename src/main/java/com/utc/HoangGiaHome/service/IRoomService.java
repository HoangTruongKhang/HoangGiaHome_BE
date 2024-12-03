package com.utc.HoangGiaHome.service;

import com.utc.HoangGiaHome.entity.Room;
import com.utc.HoangGiaHome.form.CreatingRoomForm;
import com.utc.HoangGiaHome.form.RoomFilterForm;
import com.utc.HoangGiaHome.form.UpdatingRoomForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRoomService {
    Page<Room> getAllRooms(Pageable pageable, RoomFilterForm form);

    Room getRoomById(int room_id);

    void updateRoom(UpdatingRoomForm form);

    void createRoom(CreatingRoomForm form);
}
