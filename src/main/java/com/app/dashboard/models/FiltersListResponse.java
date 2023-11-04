package com.app.dashboard.models;

import java.util.List;

public class FiltersListResponse {
    private List<String> uniqueOrganizationNames;
    private List<String> uniqueShelterGroups;
    private List<String> uniqueCities;
    private List<String> uniqueProvinces;
    private List<String> uniqueSectors;
    private List<String> uniqueProgramModels;
    private List<String> uniqueServiceTypes;
    private List<String> uniqueProgramAreas;
    private List<String> uniqueCapacityTypes;

    public List<String> getUniqueOrganizationNames() {
        return uniqueOrganizationNames;
    }

    public void setUniqueOrganizationNames(List<String> uniqueOrganizationNames) {
        this.uniqueOrganizationNames = uniqueOrganizationNames;
    }

    public List<String> getUniqueShelterGroups() {
        return uniqueShelterGroups;
    }

    public void setUniqueShelterGroups(List<String> uniqueShelterGroups) {
        this.uniqueShelterGroups = uniqueShelterGroups;
    }

    public List<String> getUniqueCities() {
        return uniqueCities;
    }

    public void setUniqueCities(List<String> uniqueCities) {
        this.uniqueCities = uniqueCities;
    }

    public List<String> getUniqueProvinces() {
        return uniqueProvinces;
    }

    public void setUniqueProvinces(List<String> uniqueProvinces) {
        this.uniqueProvinces = uniqueProvinces;
    }

    public List<String> getUniqueSectors() {
        return uniqueSectors;
    }

    public void setUniqueSectors(List<String> uniqueSectors) {
        this.uniqueSectors = uniqueSectors;
    }

    public List<String> getUniqueProgramModels() {
        return uniqueProgramModels;
    }

    public void setUniqueProgramModels(List<String> uniqueProgramModels) {
        this.uniqueProgramModels = uniqueProgramModels;
    }

    public List<String> getUniqueServiceTypes() {
        return uniqueServiceTypes;
    }

    public void setUniqueServiceTypes(List<String> uniqueServiceTypes) {
        this.uniqueServiceTypes = uniqueServiceTypes;
    }

    public List<String> getUniqueProgramAreas() {
        return uniqueProgramAreas;
    }

    public void setUniqueProgramAreas(List<String> uniqueProgramAreas) {
        this.uniqueProgramAreas = uniqueProgramAreas;
    }

    public List<String> getUniqueCapacityTypes() {
        return uniqueCapacityTypes;
    }

    public void setUniqueCapacityTypes(List<String> uniqueCapacityTypes) {
        this.uniqueCapacityTypes = uniqueCapacityTypes;
    }
}
