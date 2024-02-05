package com.dan.StudentDwellMate.model.dto.response;

import com.dan.StudentDwellMate.model.dto.request.PropertyDto;

public record ProfilePrivateResponseDto(
        Long id,
        String name,
        String faculty,
        String course,
        int age,
        String instagram,
        String facebook,
        String email,
        String whatsapp,
        String profilePhotoUrl,
        boolean hasRentedProperty,
        String cityOrigin,
        boolean wantsToSharedProperty,
        PropertyDto property) {

}
