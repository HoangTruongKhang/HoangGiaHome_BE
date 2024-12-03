package com.utc.HoangGiaHome.form;

import com.utc.HoangGiaHome.entity.Branch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreatingRoomForm {
    private String room_name;
    private String image_media_url;
    private int price;
    private int area;
    private String description;
    private int branchBranch_id;
}
