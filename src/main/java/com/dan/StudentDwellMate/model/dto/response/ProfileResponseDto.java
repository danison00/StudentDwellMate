package com.dan.StudentDwellMate.model.dto.response;

import com.dan.StudentDwellMate.model.dto.PropertyDto;

public record ProfileResponseDto(
                Long id,
                String name,
                String faculty,
                String course,
                int age,
                String instagram,
                String facebook,
                String profilePhotoUrl,
                boolean hasRentedProperty,
                String cityOrigin,
                boolean wantsToSharedProperty,
                PropertyDto property
) {
    
}
