package com.example.mvpdemo.utils.mediator_desion;

/**
 * Created by aiyang on 2018/7/16.
 * 租户
 */

public class Tenant {
    public float roomArea;
    public float roomPrice;
    public static final float diffPrice = 100.0001f;//差价
    public static final float diffArea = 0.00001f;//差值

    public void rentRoom(Mediator mediator){
        Room myRoom = mediator.rentRoom(roomArea,roomPrice);

    }
}
