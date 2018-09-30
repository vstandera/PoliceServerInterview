package cz.system.police.services;

import cz.system.police.converters.DataFromRadarToRadarDataDTO;
import cz.system.police.data.RadarDataDTO;
import cz.system.police.repositories.DataFromRadarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FinesServiceImpl implements FinesService{
    @Autowired
    DataFromRadarRepository dataFromRadarRepository;

    @Autowired
    DataFromRadarToRadarDataDTO dataFromRadarToRadarDataDTO;


    @Override
    public List<RadarDataDTO> getAllFines(){
       return StreamSupport.stream(dataFromRadarRepository.findAll().spliterator(), false).map(dataFromRadarToRadarDataDTO::convert).collect(Collectors.toList());
    }

}
