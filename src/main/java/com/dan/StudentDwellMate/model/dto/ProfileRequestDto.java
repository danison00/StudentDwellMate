package com.dan.StudentDwellMate.model.dto;

public record ProfileRequestDto(
                String name,
                String faculty,
                String course,
                int age,
                String email,
                String instagram,
                String facebook,
                String whatsapp,
                String profilePhotoUrl,
                boolean hasRentedProperty,
                String cityOrigin,
                boolean wantsToSharedProperty,
                PropertyDto property) {
}
