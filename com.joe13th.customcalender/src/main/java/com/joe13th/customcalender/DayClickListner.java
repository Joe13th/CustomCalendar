package com.joe13th.customcalender;

public class DayClickListner {
    public DayClickListner(DayModel dayModel) {
        this.dayModel = dayModel;
    }

    private DayModel dayModel;

    public DayModel getDayModel() {
        return dayModel;
    }

    public void setDayModel(DayModel dayModel) {
        this.dayModel = dayModel;
    }
}
