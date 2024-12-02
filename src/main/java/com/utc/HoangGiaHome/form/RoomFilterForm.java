package com.utc.HoangGiaHome.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomFilterForm {
    private String search;
    private Integer minPrice;
    private Integer maxPrice;
    private Integer minArea;
    private Integer maxArea;
}
