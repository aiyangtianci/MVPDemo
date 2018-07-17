package com.example.mvpdemo.utils.mediator_desion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aiyang on 2018/7/16.
 * 中介
 */

public class Mediator {
    List<Room> rooms =new ArrayList<Room>();//所有房源

    public Mediator() {
        for (int i =0 ; i<5 ;i++){
            rooms.add(new Room(14+i,(14+i)*150));//14+i平方，每平方150元
        }
    }

    public  List<Room> getAllRooms(){
        return rooms;
    }

    public Room rentRoom(float area,float price){
        for (Room room :rooms){
            if (isSuitable(room,price,area)){
                // 想要的房间
                return room;
            }
        }
        return null;
    }

    private boolean isSuitable(Room room ,float roomPrice,float roomArea) {
        return Math.abs(room.price -roomPrice)<Tenant.diffPrice
                && Math.abs(room.area -roomArea)<Tenant.diffArea;
    }
}
