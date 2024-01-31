package com.dan.StudentDwellMate.model.dto;

import java.util.List;

public record PropertyDto(

        String city,
        String state,
        String street,
        String neighborhood,
        String additionalDetails,
        String houseNumber,
        String postalCode,
        List<String> propertyPhoto) {

}
