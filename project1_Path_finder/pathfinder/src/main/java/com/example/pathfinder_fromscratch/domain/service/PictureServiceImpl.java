package com.example.pathfinder_fromscratch.domain.service;

import com.example.pathfinder_fromscratch.domain.repositories.PictureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService{

    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }


    @Override
    public List<String> findAllUrls() {
        return pictureRepository.findAllUrls();
    }
}
