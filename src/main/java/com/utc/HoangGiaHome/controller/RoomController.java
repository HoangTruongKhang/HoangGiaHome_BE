package com.utc.HoangGiaHome.controller;

import com.utc.HoangGiaHome.dto.RoomDTO;
import com.utc.HoangGiaHome.entity.Room;
import com.utc.HoangGiaHome.form.CreatingRoomForm;
import com.utc.HoangGiaHome.form.RoomFilterForm;
import com.utc.HoangGiaHome.form.UpdatingRoomForm;
import com.utc.HoangGiaHome.service.IRoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    @Autowired
    private IRoomService roomService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<RoomDTO> getAllRooms(Pageable pageable, RoomFilterForm form){
        Page<Room> roomPage = roomService.getAllRooms(pageable, form);
        List<Room> rooms = roomPage.getContent();
        List<RoomDTO> roomDTOS = rooms.stream().map(room -> modelMapper.map(room, RoomDTO.class)).collect(Collectors.toList());
        return  new PageImpl<>(roomDTOS, pageable, roomPage.getTotalElements());
    }

    @GetMapping("{room_id}")
    public RoomDTO getRoomById(@PathVariable int room_id){
        Room room = roomService.getRoomById(room_id);
        return modelMapper.map (room, RoomDTO.class);
    }

    @PostMapping
    public void  createRoom(@RequestBody CreatingRoomForm form){
        roomService.createRoom(form);
    }

    @PutMapping("{room_id}")
    public void updateRoom(@PathVariable int room_id, @RequestBody UpdatingRoomForm form){
        form.setRoom_id(room_id);
        roomService.updateRoom(form);
    }
}
