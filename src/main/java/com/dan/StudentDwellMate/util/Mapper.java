package com.dan.StudentDwellMate.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.dan.StudentDwellMate.model.dto.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.PropertyDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.model.entities.Property;

public class Mapper {

    public static Profile getProfile(ProfileRequestDto dto) {
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

    public static ProfileResponseDto getProfileDto(Profile profile) {

        var p = profile.getProperty();

        var propertyDto = new PropertyDto(p.getCity(),
                p.getState(),
                p.getStreet(),
                p.getNeighborhood(),
                p.getAdditionalDetails(),
                p.getHouseNumber(),
                p.getPostalCode(),
                p.getPropertyPhoto());

        return new ProfileResponseDto(
                profile.getId(),
                profile.getName(),
                profile.getFaculty(),
                profile.getCourse(),
                profile.getAge(),
                profile.getInstagram(),
                profile.getFacebook(),
                profile.getProfilePhotoUrl(),
                profile.isHasRentedProperty(),
                profile.getCityOrigin(),
                profile.isWantsToSharedProperty(),
                propertyDto);
    }

    public static List<ProfileResponseDto> getProfileDto(List<Profile> profiles) {


        List<ProfileResponseDto> profilesDto = new ArrayList<>();

        profiles.forEach((Profile p)->{
            profilesDto.add(
                getProfileDto(p)
            );
        });

        return profilesDto;
    }

    public static List<ProfileResponseDto> getProfileDto(Set<Profile> profiles) {


        List<ProfileResponseDto> profilesDto = new ArrayList<>();

        profiles.forEach((Profile p)->{
            profilesDto.add(
                getProfileDto(p)
            );
        });

        return profilesDto;
    }
}
