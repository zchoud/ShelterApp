package com.app.dashboard;

import com.app.dashboard.models.DataAnalyticsResponse;
import com.app.dashboard.models.FiltersListResponse;
import com.app.dashboard.models.LocationAnalyticsResponse;
import com.app.dashboard.models.Shelter;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ShelterRepository extends MongoRepository<Shelter,String> {


    @Aggregation(pipeline = {
            "{ '$skip' : ?0 }",
            "{ '$limit' : ?1 }"
    })
    List<Shelter> getSheltersPaganeted(int skip, int limit);

    @Aggregation(pipeline = {
            "{ '$group' : { '_id' : 0, 'totalBeds' : { '$sum' : { '$add' : [ '$OCCUPIED_BEDS', '$UNOCCUPIED_BEDS', '$UNAVAILABLE_BEDS' ] } }, 'unavaliableBeds' : { '$sum' : { '$add' : [ '$UNAVAILABLE_BEDS' ] } }, 'avaliableBeds' : { '$sum' : { '$add' : [ '$UNOCCUPIED_BEDS' ] } }, 'occupiedBed' : { '$sum' : { '$add' : [ '$OCCUPIED_BEDS' ] } } } }"
    })
    DataAnalyticsResponse getDataAnalytics();

    @Aggregation(pipeline = {
            "{ '$group' : { " +
                    "'_id' : 0, " +
                    "'uniqueOrganizationNames' : { " +
                    "'$addToSet' : '$ORGANIZATION_NAME' }, " +
                    "'uniqueShelterGroups' : { '$addToSet' : '$SHELTER_GROUP' }, " +
                    "'uniqueCities' : { '$addToSet' : '$LOCATION_CITY' }, " +
                    "'uniqueProvinces' : { '$addToSet' : '$LOCATION_PROVINCE' }, " +
                    "'uniqueSectors' : { '$addToSet' : '$SECTOR' }, " +
                    "'uniqueProgramModels' : { '$addToSet' : '$PROGRAM_MODEL' }, " +
                    "'uniqueServiceTypes' : { '$addToSet' : '$OVERNIGHT_SERVICE_TYPE' }, " +
                    "'uniqueProgramAreas' : { '$addToSet' : '$PROGRAM_AREA' }, " +
                    "'uniqueCapacityTypes' : { '$addToSet' : '$CAPACITY_TYPE' } } }"
    })
    FiltersListResponse getShelterFilters();

    @Aggregation(pipeline = {
            "{ '$group' : {\n" +
                    "  _id: \"$LOCATION_CITY\",\n" +
                    "  location: {\n" +
                    "    $first: \"$LOCATION_CITY\",\n" +
                    "  },\n" +
                    "  totalUnoccupiedBeds: {\n" +
                    "    $sum: \"$UNOCCUPIED_BEDS\",\n" +
                    "  },\n" +
                    "  totalOccupiedRooms: { $sum: \"$OCCUPIED_BEDS\" },\n" +
                    "}}"
    })
    List<LocationAnalyticsResponse> getLocationAnalytics();
}
