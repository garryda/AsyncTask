package com.example.asynctask;

/**
 * Created by 刘鹏达 on 2017/10/4.
 */

public class DelayOperator {

    public void delay()
    {
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
