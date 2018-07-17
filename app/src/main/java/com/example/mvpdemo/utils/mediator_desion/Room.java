package com.example.mvpdemo.utils.mediator_desion;

/**
 * Created by aiyang on 2018/7/16.
 * 房间
 */

public class Room {
    public float area;
    public float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room [area ="+area+",price="+price+"]";
    }
}
