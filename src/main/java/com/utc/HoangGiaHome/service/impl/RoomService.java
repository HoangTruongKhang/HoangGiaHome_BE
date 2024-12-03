package com.utc.HoangGiaHome.service.impl;

import com.utc.HoangGiaHome.entity.Branch;
import com.utc.HoangGiaHome.entity.Room;
import com.utc.HoangGiaHome.form.CreatingRoomForm;
import com.utc.HoangGiaHome.form.RoomFilterForm;
import com.utc.HoangGiaHome.form.UpdatingRoomForm;
import com.utc.HoangGiaHome.repository.IRoomRepository;
import com.utc.HoangGiaHome.service.IRoomService;
import com.utc.HoangGiaHome.specification.BranchSpecification;
import com.utc.HoangGiaHome.specification.RoomSpeciification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private IRoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Page<Room> getAllRooms(Pageable pageable, RoomFilterForm form) {
        Specification<Room> where = RoomSpeciification.buildWhere(form);
        return roomRepository.findAll(where, pageable);
    }


    @Override
    public Room getRoomById(int room_id) {
        return roomRepository.findById(room_id);
    }

    @Override
    public void updateRoom(UpdatingRoomForm form) {
        Room room = modelMapper.map(form, Room.class);
        roomRepository.save(room);
    }

    @Override
    public void createRoom(CreatingRoomForm form) {
        Room room = modelMapper.map(form, Room.class);
        room.setRoom_id(0);
        roomRepository.save(room);
    }
}
