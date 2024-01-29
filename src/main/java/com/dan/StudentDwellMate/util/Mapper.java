package com.dan.StudentDwellMate.util;

import com.dan.StudentDwellMate.model.dto.ProfileDto;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.model.entities.Property;

public class Mapper {

    public static Profile getProfile(ProfileDto dto) {
        var propertyDto = dto.property();

        var property = Property.builder()
        .city(propertyDto.city())
        .state(propertyDto.state())
        .street(propertyDto.street())
        .houseNumber(propertyDto.houseNumber())    
        .neighborhood(propertyDto.neighborhood())
        .postalCode(propertyDto.postalCode())
        .propertyPhoto(propertyDto.propertyPhoto())
        .additionalDetails(propertyDto.additionalDetails())    
        .build();

        return Profile.builder()
                .name(dto.name())
                .age(dto.age())
                .email(dto.email())
                .facebook(dto.facebook())
                .instagram(dto.instagram())
                .whatsapp(dto.whatsapp())
                .cityOrigin(dto.cityOrigin())
                .course(dto.course())
                .faculty(dto.faculty())
                .hasRentedProperty(dto.hasRentedProperty())
                .profilePhotoUrl(dto.profilePhotoUrl())
                .property(property)
                .wantsToSharedProperty(dto.wantsToSharedProperty())
                .build();
    }
}
