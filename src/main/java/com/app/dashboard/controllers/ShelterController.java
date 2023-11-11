package com.app.dashboard.controllers;

import com.app.dashboard.ShelterRepository;
import com.app.dashboard.models.*;
import com.app.dashboard.services.ShelterService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class ShelterController {
    private <T> T defaultIfNull(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    @Autowired
    ShelterService service;

    @Autowired
    ShelterRepository repository;

    @ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/shelters")
    @CrossOrigin
    @ApiOperation(value = "Get all Shelters", notes = "Get a list of all Shelters optionally giving a limit and offset, default is first 50.")
    public List<Shelter> getAllShelters(
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer skip,
            @RequestParam(required = false) String capacityType,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String organizationName,
            @RequestParam(required = false) String programArea,
            @RequestParam(required = false) String programModel,
            @RequestParam(required = false) String provence,
            @RequestParam(required = false) String sector,
            @RequestParam(required = false) String serviceType,
            @RequestParam(required = false) String shelterGroup
    ) {
        int limitValue = defaultIfNull(limit, 50);
        int skipValue = defaultIfNull(skip, 0);
        String capacityTypeValue = defaultIfNull(capacityType, "");
        String cityValue = defaultIfNull(city, "");
        String organizationNameValue = defaultIfNull(organizationName, "");
        String programAreaValue = defaultIfNull(programArea, "");
        String programModelValue = defaultIfNull(programModel, "");
        String provenceValue = defaultIfNull(provence, "");
        String sectorValue = defaultIfNull(sector, "");
        String serviceTypeValue = defaultIfNull(serviceType, "");
        String shelterGroupValue = defaultIfNull(shelterGroup, "");

        return service.getSheltersFiltered(
                skipValue,
                limitValue,
                capacityTypeValue,
                cityValue,
                organizationNameValue,
                programAreaValue,
                programModelValue,
                provenceValue,
                sectorValue,
                serviceTypeValue,
                shelterGroupValue
        );
    }


    @GetMapping("/shelter/{id}")
    @ApiOperation(value = "Get Shelter by ID", notes = "Get shelter details by ID.")
    public Shelter getShelterById(@PathVariable String id) {
        Shelter shelter = service.findById(id);
        if(shelter == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter not found");
        }
        return shelter;
    }

    @GetMapping("/analytics/occupancy")
    @CrossOrigin
    @ApiOperation(value = "Get shelter analytic data", notes = "Get data on beds and occupation.")
    public DataAnalyticsResponse getOccupancyData() {
        return repository.getDataAnalytics();
    }

    @GetMapping("/filters")
    @CrossOrigin
    @ApiOperation(value = "Get shelter filters data", notes = "Get filters available and the list of items.")
    public FiltersListResponse getFiltersData() {
        return repository.getShelterFilters();
    }

    @GetMapping("/analytics/cities")
    @CrossOrigin
    @ApiOperation(value = "Get city analytics", notes = "Get city analytics on occupied and unocupied beds.")
    public List<LocationAnalyticsResponse> getLocationAnalytics() {
        return repository.getLocationAnalytics();
    }


    @PostMapping("/shelter")
    @CrossOrigin
    @ApiOperation(value = "Add shelter", notes = "Add shelter to DB with required data.")
    public Shelter addShelter(
            @RequestBody(required = true) CreateShelterRequest request
    ) {
        return service.createShelter(request);
    }

    @PatchMapping ("/shelter")
    @CrossOrigin
    @ApiOperation(value = "Update a shelter", notes = "Update one or more fields of a shelter using the ID.")
    public Shelter updateShelter(
            @RequestBody(required = true) Shelter request
    ) {
        Shelter existingShelter = service.findById(request.getId());
        if(existingShelter == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter not found");
        }
        existingShelter.mergeShelters(request);
        return service.patchShelter(existingShelter);
    }
    @DeleteMapping("/shelter/{id}")
    @CrossOrigin
    @ApiOperation(value="Delete a shelter entry by ID", notes="Delete a shelter by ID returns if successful.")
    public ResponseEntity deleteShelter(
            @PathVariable(required = true) String id
    ){
        Shelter existingShelter = service.findById(id);
        if(existingShelter == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter not found");
        }
        repository.deleteById(id);
        return new ResponseEntity("Shelter deleted.", HttpStatus.ACCEPTED);
    }
}
