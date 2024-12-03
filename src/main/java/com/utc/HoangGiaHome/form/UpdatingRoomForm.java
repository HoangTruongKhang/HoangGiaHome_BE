package com.utc.HoangGiaHome.form;

public class UpdatingRoomForm {
    private int room_id;
    private String room_name;
    private String image_media_url;
    private int price;
    private int area;
    private String description;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getImage_media_url() {
        return image_media_url;
    }

    public void setImage_media_url(String image_media_url) {
        this.image_media_url = image_media_url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
