package com.dan.StudentDwellMate.model.dto;

import java.util.List;


public record AdvertisementDto(
    String title,
    String description,
    double price,
    String propertyType,
    String neighbors,
    List<String> houseRules,
    String advertiserInfo,
    boolean seekingCoTenant,
    Long idProfile
) { }
