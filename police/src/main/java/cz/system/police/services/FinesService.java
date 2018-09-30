package cz.system.police.services;

import cz.system.police.data.RadarDataDTO;

import java.util.List;

public interface FinesService {
    public List<RadarDataDTO> getAllFines();
}
