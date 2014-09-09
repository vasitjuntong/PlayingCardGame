package com.asevensoft.a7002;

/**
 * Created by BEEEEE on 8/16/2014.
 */
public class FormatMessage {

    String title;
    Integer value1, value2;

    public FormatMessage(String title, Integer value1, Integer value2) {
        this.value2 = value2;
        this.title = title;
        this.value1 = value1;
    }

    public String getTitle(){
        return this.title + " " + value1 + " / " + value2;
    }
}
