package com.app.dashboard.services;

import com.app.dashboard.models.CreateShelterRequest;
import com.app.dashboard.models.Shelter;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ShelterService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Shelter findById(String id) {
        Assert.notNull(id, "ID must not be null");
        return mongoTemplate.findById(new ObjectId(id), Shelter.class);
    }

    public List<Shelter> getSheltersFiltered(int skip, int limit, String capacityType, String city, String organizationName, String programArea, String programModel, String provence, String sector, String serviceType, String shelterGroup) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.skip(skip),
                Aggregation.limit(limit)
        );

        List<AggregationOperation> matchOperations = new ArrayList<>();

        if (!StringUtils.isEmpty(capacityType)) {
            matchOperations.add(Aggregation.match(Criteria.where("CAPACITY_TYPE").is(capacityType)));
        }

        if (!StringUtils.isEmpty(city)) {
            matchOperations.add(Aggregation.match(Criteria.where("LOCATION_CITY").is(city)));
        }

        if (!StringUtils.isEmpty(organizationName)) {
            matchOperations.add(Aggregation.match(Criteria.where("ORGANIZATION_NAME").is(organizationName)));
        }

        if (!StringUtils.isEmpty(programArea)) {
            matchOperations.add(Aggregation.match(Criteria.where("PROGRAM_AREA").is(programArea)));
        }

        if (!StringUtils.isEmpty(programModel)) {
            matchOperations.add(Aggregation.match(Criteria.where("PROGRAM_MODEL").is(programModel)));
        }

        if (!StringUtils.isEmpty(provence)) {
            matchOperations.add(Aggregation.match(Criteria.where("LOCATION_PROVINCE").is(provence)));
        }

        if (!StringUtils.isEmpty(sector)) {
            matchOperations.add(Aggregation.match(Criteria.where("SECTOR").is(sector)));
        }

        if (!StringUtils.isEmpty(serviceType)) {
            matchOperations.add(Aggregation.match(Criteria.where("OVERNIGHT_SERVICE_TYPE").is(serviceType)));
        }

        if (!StringUtils.isEmpty(shelterGroup)) {
            matchOperations.add(Aggregation.match(Criteria.where("SHELTER_GROUP").is(shelterGroup)));
        }

        if (matchOperations.size() > 0) {
            aggregation = Aggregation.newAggregation(matchOperations);
        }

        AggregationResults<Shelter> results = mongoTemplate.aggregate(aggregation, "Shelter", Shelter.class);
        return results.getMappedResults();
    }

    public Shelter createShelter(CreateShelterRequest shelterRequest) {
        if (shelterRequest.getLocationId() == 0){
            shelterRequest.setLocationId(getMaxId("LOCATION_ID") + 1);
        }
        if (shelterRequest.getOrganizationId() == 0){
            shelterRequest.setOrganizationId(getMaxId("ORGANIZATION_ID") + 1);
        }
        if (shelterRequest.getShelterId() == 0){
            shelterRequest.setShelterId(getMaxId("SHELTER_ID") + 1);
        }
        if (shelterRequest.getProgramId() == 0){
            shelterRequest.setProgramId(getMaxId("PROGRAM_ID") + 1);
        }
        Document document = shelterRequest.toDocument();
        mongoTemplate.insert(document, "Shelter");
        return mongoTemplate.getConverter().read(Shelter.class, document);
    }

    private int getMaxId(String field_name) {
        Document result = mongoTemplate.getCollection("Shelter")
                .find()
                .sort(new Document(field_name, -1))
                .limit(1)
                .projection(new Document(field_name, 1))
                .first();

        return (result != null) ? result.getInteger(field_name, 0) : 0;
    }

    public Shelter patchShelter(Shelter updatedShelter) {
        Query query = Query.query(Criteria.where("_id").is(new ObjectId(updatedShelter.getId())));

        Update update = new Update();
        update.set("OCCUPANCY_DATE", updatedShelter.getOccupancyDate());
        update.set("ORGANIZATION_ID", updatedShelter.getOrganizationId());
        update.set("ORGANIZATION_NAME", updatedShelter.getOrganizationName());
        update.set("SHELTER_ID", updatedShelter.getShelterId());
        update.set("SHELTER_GROUP", updatedShelter.getShelterGroup());
        update.set("LOCAgggTION_ID", updatedShelter.getLocationId());
        update.set("LOCATION_NAME", updatedShelter.getLocationName());
        update.set("LOCATION_ADDRESS", updatedShelter.getLocationAddress());
        update.set("LOCATION_POSTAL_CODE", updatedShelter.getLocationPostalCode());
        update.set("LOCATION_CITY", updatedShelter.getLocationCity());
        update.set("LOCATION_PROVINCE", updatedShelter.getLocationProvince());
        update.set("PROGRAM_ID", updatedShelter.getProgramId());
        update.set("PROGRAM_NAME", updatedShelter.getProgramName());
        update.set("SECTOR", updatedShelter.getSector());
        update.set("PROGRAM_MODEL", updatedShelter.getProgramModel());
        update.set("OVERNIGHT_SERVICE_TYPE", updatedShelter.getOvernightServiceType());
        update.set("PROGRAM_AREA", updatedShelter.getProgramArea());
        update.set("SERVICE_USER_COUNT", updatedShelter.getServiceUserCount());
        update.set("CAPACITY_TYPE", updatedShelter.getCapacityType());
        update.set("CAPACITY_ACTUAL_BED", updatedShelter.getCapacityActualBed());
        update.set("CAPACITY_FUNDING_BED", updatedShelter.getCapacityFundingBed());
        update.set("OCCUPIED_BEDS", updatedShelter.getOccupiedBeds());
        update.set("UNOCCUPIED_BEDS", updatedShelter.getUnoccupiedBeds());
        update.set("UNAVAILABLE_BEDS", updatedShelter.getUnavailableBeds());
        update.set("CAPACITY_ACTUAL_ROOM", updatedShelter.getCapacityActualRoom());
        update.set("CAPACITY_FUNDING_ROOM", updatedShelter.getCapacityFundingRoom());
        update.set("OCCUPIED_ROOMS", updatedShelter.getOccupiedRooms());
        update.set("UNOCCUPIED_ROOMS", updatedShelter.getUnoccupiedRooms());
        update.set("UNAVAILABLE_ROOMS", updatedShelter.getUnavailableRooms());
        update.set("OCCUPANCY_RATE_BEDS", updatedShelter.getOccupancyRateBeds());
        update.set("OCCUPANCY_RATE_ROOMS", updatedShelter.getOccupancyRateRooms());

        mongoTemplate.updateFirst(query, update, Shelter.class);
        return updatedShelter;
    }
}

