package com.app.dashboard.models;

public class LocationAnalyticsResponse {

        private String location;

    private int totalUnoccupiedBeds;

    private int totalOccupiedRooms;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalUnoccupiedBeds() {
        return totalUnoccupiedBeds;
    }

    public void setTotalUnoccupiedBeds(int totalUnoccupiedBeds) {
        this.totalUnoccupiedBeds = totalUnoccupiedBeds;
    }

    public int getTotalOccupiedRooms() {
        return totalOccupiedRooms;
    }

    public void setTotalOccupiedRooms(int totalOccupiedRooms) {
        this.totalOccupiedRooms = totalOccupiedRooms;
    }
}
