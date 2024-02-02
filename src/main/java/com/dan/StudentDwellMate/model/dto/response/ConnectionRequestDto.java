package com.dan.StudentDwellMate.model.dto.response;

import java.time.LocalDateTime;

public record ConnectionRequestDto(Long id, ProfileResponseDto profile, LocalDateTime date) {
    
}
