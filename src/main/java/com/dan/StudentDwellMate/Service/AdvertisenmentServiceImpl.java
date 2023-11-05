package com.dan.StudentDwellMate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.interfaces.AdversementService;
import com.dan.StudentDwellMate.model.entities.Advertisement;
import com.dan.StudentDwellMate.repository.AdvertisementRepository;

@Service
public class AdvertisenmentServiceImpl implements AdversementService

{
    
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Override
    public Advertisement saveAndFlush(Advertisement advertisement) {
        
        return this.advertisementRepository.save(advertisement);
    }


}
