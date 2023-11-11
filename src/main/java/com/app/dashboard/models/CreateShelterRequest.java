package com.app.dashboard.models;

import org.bson.Document;

public class CreateShelterRequest {

    private String occupancyDate;
    private int organizationId;
    private String organizationName;
    private int shelterId;
    private String shelterGroup;
    private int locationId;
    private String locationName;
    private String locationAddress;
    private String locationPostalCode;
    private String locationCity;
    private String locationProvince;
    private int programId;
    private String programName;
    private String sector;
    private String programModel;
    private String overnightServiceType;
    private String programArea;
    private int serviceUserCount;
    private String capacityType;
    private int capacityActualBed;
    private int capacityFundingBed;
    private int occupiedBeds;
    private int unoccupiedBeds;
    private int unavailableBeds;
    private int capacityActualRoom;
    private int capacityFundingRoom;
    private int occupiedRooms;
    private int unoccupiedRooms;
    private int unavailableRooms;
    private double occupancyRateBeds;
    private double occupancyRateRooms;

    public CreateShelterRequest(String occupancyDate, int organizationId, String organizationName, int shelterId,
                          String shelterGroup, int locationId, String locationName, String locationAddress,
                          String locationPostalCode, String locationCity, String locationProvince, int programId,
                          String programName, String sector, String programModel, String overnightServiceType,
                          String programArea, int serviceUserCount, String capacityType, int capacityActualBed,
                          int capacityFundingBed, int occupiedBeds, int unoccupiedBeds, int unavailableBeds,
                          int capacityActualRoom, int capacityFundingRoom, int occupiedRooms, int unoccupiedRooms,
                          int unavailableRooms, double occupancyRateBeds, double occupancyRateRooms) {
        this.occupancyDate = occupancyDate;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.shelterId = shelterId;
        this.shelterGroup = shelterGroup;
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.locationPostalCode = locationPostalCode;
        this.locationCity = locationCity;
        this.locationProvince = locationProvince;
        this.programId = programId;
        this.programName = programName;
        this.sector = sector;
        this.programModel = programModel;
        this.overnightServiceType = overnightServiceType;
        this.programArea = programArea;
        this.serviceUserCount = serviceUserCount;
        this.capacityType = capacityType;
        this.capacityActualBed = capacityActualBed;
        this.capacityFundingBed = capacityFundingBed;
        this.occupiedBeds = occupiedBeds;
        this.unoccupiedBeds = unoccupiedBeds;
        this.unavailableBeds = unavailableBeds;
        this.capacityActualRoom = capacityActualRoom;
        this.capacityFundingRoom = capacityFundingRoom;
        this.occupiedRooms = occupiedRooms;
        this.unoccupiedRooms = unoccupiedRooms;
        this.unavailableRooms = unavailableRooms;
        this.occupancyRateBeds = occupancyRateBeds;
        this.occupancyRateRooms = occupancyRateRooms;
    }

    public Document toDocument() {
        return new Document("OCCUPANCY_DATE", occupancyDate)
                .append("ORGANIZATION_ID", organizationId)
                .append("ORGANIZATION_NAME", organizationName)
                .append("SHELTER_ID", shelterId)
                .append("SHELTER_GROUP", shelterGroup)
                .append("LOCATION_ID", locationId)
                .append("LOCATION_NAME", locationName)
                .append("LOCATION_ADDRESS", locationAddress)
                .append("LOCATION_POSTAL_CODE", locationPostalCode)
                .append("LOCATION_CITY", locationCity)
                .append("LOCATION_PROVINCE", locationProvince)
                .append("PROGRAM_ID", programId)
                .append("PROGRAM_NAME", programName)
                .append("SECTOR", sector)
                .append("PROGRAM_MODEL", programModel)
                .append("OVERNIGHT_SERVICE_TYPE", overnightServiceType)
                .append("PROGRAM_AREA", programArea)
                .append("SERVICE_USER_COUNT", serviceUserCount)
                .append("CAPACITY_TYPE", capacityType)
                .append("CAPACITY_ACTUAL_BED", capacityActualBed)
                .append("CAPACITY_FUNDING_BED", capacityFundingBed)
                .append("OCCUPIED_BEDS", occupiedBeds)
                .append("UNOCCUPIED_BEDS", unoccupiedBeds)
                .append("UNAVAILABLE_BEDS", unavailableBeds)
                .append("CAPACITY_ACTUAL_ROOM", capacityActualRoom)
                .append("CAPACITY_FUNDING_ROOM", capacityFundingRoom)
                .append("OCCUPIED_ROOMS", occupiedRooms)
                .append("UNOCCUPIED_ROOMS", unoccupiedRooms)
                .append("UNAVAILABLE_ROOMS", unavailableRooms)
                .append("OCCUPANCY_RATE_BEDS", occupancyRateBeds)
                .append("OCCUPANCY_RATE_ROOMS", occupancyRateRooms);
    }

    public String getOccupancyDate() {
        return occupancyDate;
    }

    public void setOccupancyDate(String occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getShelterId() {
        return shelterId;
    }

    public void setShelterId(int shelterId) {
        this.shelterId = shelterId;
    }

    public String getShelterGroup() {
        return shelterGroup;
    }

    public void setShelterGroup(String shelterGroup) {
        this.shelterGroup = shelterGroup;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationPostalCode() {
        return locationPostalCode;
    }

    public void setLocationPostalCode(String locationPostalCode) {
        this.locationPostalCode = locationPostalCode;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationProvince() {
        return locationProvince;
    }

    public void setLocationProvince(String locationProvince) {
        this.locationProvince = locationProvince;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getProgramModel() {
        return programModel;
    }

    public void setProgramModel(String programModel) {
        this.programModel = programModel;
    }

    public String getOvernightServiceType() {
        return overnightServiceType;
    }

    public void setOvernightServiceType(String overnightServiceType) {
        this.overnightServiceType = overnightServiceType;
    }

    public String getProgramArea() {
        return programArea;
    }

    public void setProgramArea(String programArea) {
        this.programArea = programArea;
    }

    public int getServiceUserCount() {
        return serviceUserCount;
    }

    public void setServiceUserCount(int serviceUserCount) {
        this.serviceUserCount = serviceUserCount;
    }

    public String getCapacityType() {
        return capacityType;
    }

    public void setCapacityType(String capacityType) {
        this.capacityType = capacityType;
    }

    public int getCapacityActualBed() {
        return capacityActualBed;
    }

    public void setCapacityActualBed(int capacityActualBed) {
        this.capacityActualBed = capacityActualBed;
    }

    public int getCapacityFundingBed() {
        return capacityFundingBed;
    }

    public void setCapacityFundingBed(int capacityFundingBed) {
        this.capacityFundingBed = capacityFundingBed;
    }

    public int getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(int occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    public int getUnoccupiedBeds() {
        return unoccupiedBeds;
    }

    public void setUnoccupiedBeds(int unoccupiedBeds) {
        this.unoccupiedBeds = unoccupiedBeds;
    }

    public int getUnavailableBeds() {
        return unavailableBeds;
    }

    public void setUnavailableBeds(int unavailableBeds) {
        this.unavailableBeds = unavailableBeds;
    }

    public int getCapacityActualRoom() {
        return capacityActualRoom;
    }

    public void setCapacityActualRoom(int capacityActualRoom) {
        this.capacityActualRoom = capacityActualRoom;
    }

    public int getCapacityFundingRoom() {
        return capacityFundingRoom;
    }

    public void setCapacityFundingRoom(int capacityFundingRoom) {
        this.capacityFundingRoom = capacityFundingRoom;
    }

    public int getOccupiedRooms() {
        return occupiedRooms;
    }

    public void setOccupiedRooms(int occupiedRooms) {
        this.occupiedRooms = occupiedRooms;
    }

    public int getUnoccupiedRooms() {
        return unoccupiedRooms;
    }

    public void setUnoccupiedRooms(int unoccupiedRooms) {
        this.unoccupiedRooms = unoccupiedRooms;
    }

    public int getUnavailableRooms() {
        return unavailableRooms;
    }

    public void setUnavailableRooms(int unavailableRooms) {
        this.unavailableRooms = unavailableRooms;
    }

    public double getOccupancyRateBeds() {
        return occupancyRateBeds;
    }

    public void setOccupancyRateBeds(double occupancyRateBeds) {
        this.occupancyRateBeds = occupancyRateBeds;
    }

    public double getOccupancyRateRooms() {
        return occupancyRateRooms;
    }

    public void setOccupancyRateRooms(double occupancyRateRooms) {
        this.occupancyRateRooms = occupancyRateRooms;
    }
}

