package com.app.dashboard.models;

public class DataAnalyticsResponse {
    private int totalBeds;
    private int avaliableBeds;
    private int occupiedBed;
    private int unavaliableBeds;

    public int getTotalBeds() {
        return totalBeds;
    }

    public void setTotalBeds(int totalBeds) {
        this.totalBeds = totalBeds;
    }

    public int getAvaliableBeds() {
        return avaliableBeds;
    }

    public void setAvaliableBeds(int avaliableBeds) {
        this.avaliableBeds = avaliableBeds;
    }

    public int getOccupiedBed() {
        return occupiedBed;
    }

    public void setOccupiedBed(int occupiedBed) {
        this.occupiedBed = occupiedBed;
    }

    public int getUnavaliableBeds() {
        return unavaliableBeds;
    }

    public void setUnavaliableBeds(int unavaliableBeds) {
        this.unavaliableBeds = unavaliableBeds;
    }
}

