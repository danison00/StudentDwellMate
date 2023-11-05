package com.dan.StudentDwellMate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dan.StudentDwellMate.model.entities.Advertisement;

/**
 * AdvertisementRepository
 */
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long>{

    
} 