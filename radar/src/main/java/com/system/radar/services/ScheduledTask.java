package com.system.radar.services;

import com.system.radar.data.GeneratedRadarData;
import com.system.radar.data.RadarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

@Component
public class ScheduledTask {

    @Autowired
    RadarService radarService;

    @Scheduled(fixedRate = 60000)
    public void sendRadarData(){
        final RadarData radarData = getRadarData();
        System.out.println("Job was scheduled" + new Date().toString() + " and ID: "+ radarService.storeDataFromRadar(radarData));
    }

    private RadarData getRadarData() {
        Random rand = new Random();
        int radarDataRandomInt = rand.nextInt(14);
        final RadarData radarData = GeneratedRadarData.radarDataList.get(radarDataRandomInt);
        Random rand2 = new Random();
        int carSpeedRandomInt = rand2.nextInt(150);
        radarData.setCarSpeed(GeneratedRadarData.carSpeed.get(carSpeedRandomInt));
        Random rand3 = new Random();
        int maxSpeedLimitRandomInt = rand3.nextInt(5);
        radarData.setMaxSpeedLimit(GeneratedRadarData.maxSpeedLimit.get(maxSpeedLimitRandomInt));
        radarData.setPictureDate(new Date());
        return radarData;
    }
}
