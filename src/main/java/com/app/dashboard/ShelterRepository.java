package com.app.dashboard;

import com.app.dashboard.models.Shelter;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ShelterRepository extends MongoRepository<Shelter,String> {

    @Aggregation(pipeline = {
            "{ '$skip' : ?0 }",
            "{ '$limit' : ?1 }"
    })
    List<Shelter> getSheltersPaganeted(int skip, int limit);
}
