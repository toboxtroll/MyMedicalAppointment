package com.mymedicalappointment.model;

import java.util.Date;

public interface ISchedulable {
    void schedule(Date date, String time);
}
