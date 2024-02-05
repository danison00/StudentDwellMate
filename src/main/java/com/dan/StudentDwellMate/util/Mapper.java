package com.dan.StudentDwellMate.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.dan.StudentDwellMate.model.dto.request.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.request.PropertyDto;
import com.dan.StudentDwellMate.model.dto.request.UserDto;
import com.dan.StudentDwellMate.model.dto.response.ConnectionRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfilePrivateResponseDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.ConnectionRequest;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.model.entities.Property;
import com.dan.StudentDwellMate.model.entities.User;

public class Mapper {

    public static Profile getProfile(ProfileRequestDto dto) {

        Property property = getpProperty(dto.property());

        var profile = Profile.builder()
                .name(dto.name())
                .age(dto.age())
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
                .user(getUser(dto.user()))
                .build();

        if (property != null)
            property.setProfile(profile);

        return profile;
    }

    public static User getUser(UserDto userDto){
        return new User(userDto.username(), userDto.password());
    }

    public static ProfileResponseDto getProfileDto(Profile profile) {

        PropertyDto propertyDto = getPropertyDto(profile.getProperty());

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

        profiles.forEach((Profile p) -> {
            profilesDto.add(
                    getProfileDto(p));
        });

        return profilesDto;
    }

    public static ProfilePrivateResponseDto getProfilePrivateDto(Profile profile) {

        return new ProfilePrivateResponseDto(
                profile.getId(),
                profile.getName(),
                profile.getFaculty(),
                profile.getCourse(),
                profile.getAge(),
                profile.getInstagram(),
                profile.getFacebook(),
                profile.getEmail(),
                profile.getWhatsapp(),
                profile.getProfilePhotoUrl(),
                profile.isHasRentedProperty(),
                profile.getCityOrigin(),
                profile.isWantsToSharedProperty(),
                getPropertyDto(profile.getProperty()));

    }

    public static List<ProfilePrivateResponseDto> getProfilePrivateDto(Set<Profile> profiles) {

        List<ProfilePrivateResponseDto> profilesDto = new ArrayList<>();

        profiles.forEach((Profile p) -> {
            profilesDto.add(
                    getProfilePrivateDto(p));
        });

        return profilesDto;
    }

    public static List<ProfileResponseDto> getProfileDto(Set<Profile> profiles) {

        List<ProfileResponseDto> profilesDto = new ArrayList<>();

        profiles.forEach((Profile p) -> {
            profilesDto.add(getProfileDto(p));
        });

        return profilesDto;
    }

    public static PropertyDto getPropertyDto(Property p) {

        if (p == null)
            return null;

        return new PropertyDto(
                p.getCity(),
                p.getState(),
                p.getStreet(),
                p.getNeighborhood(),
                p.getAdditionalDetails(),
                p.getHouseNumber(),
                p.getPostalCode(),
                p.getPropertyPhoto());
    }

    public static Property getpProperty(PropertyDto dto) {

        if (dto == null)
            return null;

        return Property.builder()
                .city(dto.city())
                .state(dto.state())
                .street(dto.street())
                .houseNumber(dto.houseNumber())
                .neighborhood(dto.neighborhood())
                .postalCode(dto.postalCode())
                .propertyPhoto(dto.propertyPhoto())
                .additionalDetails(dto.additionalDetails())
                .build();

    }
}
