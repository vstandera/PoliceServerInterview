package com.system.radar.services;

import com.system.radar.data.RadarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RadarServiceImpl implements RadarService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Long storeDataFromRadar(RadarData data) {
        final Long storedId  = restTemplate.postForObject("http://localhost:8080/radar/data", data, Long.class);
        return storedId;
    }
}

