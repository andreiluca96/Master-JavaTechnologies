package com.andrluc.javatech.courseallocation.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Date;

@ManagedBean(name = "TimeBean")
@SessionScoped
public class TimeBean implements Serializable {
    public long currentTime;

    public void fetchTime() {
        this.currentTime = System.currentTimeMillis();
    }

    public String getCurrentTime() {
        return "Current Date: " + new Date(currentTime).toString();
    }
}
