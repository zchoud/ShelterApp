package com.app.dashboard.models;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "Shelter")
public class Shelter {
    @Field("_id")
    private ObjectId id;
    @Field("OCCUPANCY_DATE")
    private String occupancyDate;

    @Field("ORGANIZATION_ID")
    private Integer organizationId;

    @Field("ORGANIZATION_NAME")
    private String organizationName;

    @Field("SHELTER_ID")
    private Integer shelterId;

    @Field("SHELTER_GROUP")
    private String shelterGroup;

    @Field("LOCATION_ID")
    private Integer locationId;

    @Field("LOCATION_NAME")
    private String locationName;

    @Field("LOCATION_ADDRESS")
    private String locationAddress;

    @Field("LOCATION_POSTAL_CODE")
    private String locationPostalCode;

    @Field("LOCATION_CITY")
    private String locationCity;

    @Field("LOCATION_PROVINCE")
    private String locationProvince;

    @Field("PROGRAM_ID")
    private Integer programId;

    @Field("PROGRAM_NAME")
    private String programName;

    @Field("SECTOR")
    private String sector;

    @Field("PROGRAM_MODEL")
    private String programModel;

    @Field("OVERNIGHT_SERVICE_TYPE")
    private String overnightServiceType;

    @Field("PROGRAM_AREA")
    private String programArea;

    @Field("SERVICE_USER_COUNT")
    private Integer serviceUserCount;

    @Field("CAPACITY_TYPE")
    private String capacityType;

    @Field("CAPACITY_ACTUAL_BED")
    private String capacityActualBed;

    @Field("CAPACITY_FUNDING_BED")
    private String capacityFundingBed;

    @Field("OCCUPIED_BEDS")
    private String occupiedBeds;

    @Field("UNOCCUPIED_BEDS")
    private String unoccupiedBeds;

    @Field("UNAVAILABLE_BEDS")
    private String unavailableBeds;

    @Field("CAPACITY_ACTUAL_ROOM")
    private Integer capacityActualRoom;

    @Field("CAPACITY_FUNDING_ROOM")
    private Integer capacityFundingRoom;

    @Field("OCCUPIED_ROOMS")
    private Integer occupiedRooms;

    @Field("UNOCCUPIED_ROOMS")
    private Integer unoccupiedRooms;

    @Field("UNAVAILABLE_ROOMS")
    private Integer unavailableRooms;

    @Field("OCCUPANCY_RATE_BEDS")
    private String occupancyRateBeds;

    @Field("OCCUPANCY_RATE_ROOMS")
    private Integer occupancyRateRooms;

    public String getId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setOccupancyDate(String occupancyDate) {
        this.occupancyDate = occupancyDate;
    }

    public String getOccupancyDate() {
        return occupancyDate;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getShelterId() {
        return shelterId;
    }

    public void setShelterId(Integer shelterId) {
        this.shelterId = shelterId;
    }

    public String getShelterGroup() {
        return shelterGroup;
    }

    public void setShelterGroup(String shelterGroup) {
        this.shelterGroup = shelterGroup;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
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

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
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

    public Integer getServiceUserCount() {
        return serviceUserCount;
    }

    public void setServiceUserCount(Integer serviceUserCount) {
        this.serviceUserCount = serviceUserCount;
    }

    public String getCapacityType() {
        return capacityType;
    }

    public void setCapacityType(String capacityType) {
        this.capacityType = capacityType;
    }

    public String getCapacityActualBed() {
        return capacityActualBed;
    }

    public void setCapacityActualBed(String capacityActualBed) {
        this.capacityActualBed = capacityActualBed;
    }

    public String getCapacityFundingBed() {
        return capacityFundingBed;
    }

    public void setCapacityFundingBed(String capacityFundingBed) {
        this.capacityFundingBed = capacityFundingBed;
    }

    public String getOccupiedBeds() {
        return occupiedBeds;
    }

    public void setOccupiedBeds(String occupiedBeds) {
        this.occupiedBeds = occupiedBeds;
    }

    public String getUnoccupiedBeds() {
        return unoccupiedBeds;
    }

    public void setUnoccupiedBeds(String unoccupiedBeds) {
        this.unoccupiedBeds = unoccupiedBeds;
    }

    public String getUnavailableBeds() {
        return unavailableBeds;
    }

    public void setUnavailableBeds(String unavailableBeds) {
        this.unavailableBeds = unavailableBeds;
    }

    public Integer getCapacityActualRoom() {
        return capacityActualRoom;
    }

    public void setCapacityActualRoom(Integer capacityActualRoom) {
        this.capacityActualRoom = capacityActualRoom;
    }

    public Integer getCapacityFundingRoom() {
        return capacityFundingRoom;
    }

    public void setCapacityFundingRoom(Integer capacityFundingRoom) {
        this.capacityFundingRoom = capacityFundingRoom;
    }

    public Integer getOccupiedRooms() {
        return occupiedRooms;
    }

    public void setOccupiedRooms(Integer occupiedRooms) {
        this.occupiedRooms = occupiedRooms;
    }

    public Integer getUnoccupiedRooms() {
        return unoccupiedRooms;
    }

    public void setUnoccupiedRooms(Integer unoccupiedRooms) {
        this.unoccupiedRooms = unoccupiedRooms;
    }

    public Integer getUnavailableRooms() {
        return unavailableRooms;
    }

    public void setUnavailableRooms(Integer unavailableRooms) {
        this.unavailableRooms = unavailableRooms;
    }

    public String getOccupancyRateBeds() {
        return occupancyRateBeds;
    }

    public void setOccupancyRateBeds(String occupancyRateBeds) {
        this.occupancyRateBeds = occupancyRateBeds;
    }

    public Integer getOccupancyRateRooms() {
        return occupancyRateRooms;
    }

    public void setOccupancyRateRooms(Integer occupancyRateRooms) {
        this.occupancyRateRooms = occupancyRateRooms;
    }
}
