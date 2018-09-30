package com.system.radar.bootstrap;

import com.system.radar.data.GeneratedRadarData;
import com.system.radar.data.RadarData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class RaradDataBootstrap  implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        storeData();
    }

    private void storeData(){
        List<Integer> maxSpeedLimit = new ArrayList<>();
        maxSpeedLimit.add(30);
        maxSpeedLimit.add(40);
        maxSpeedLimit.add(50);
        maxSpeedLimit.add(70);
        maxSpeedLimit.add(80);
        maxSpeedLimit.add(90);
        GeneratedRadarData.maxSpeedLimit = maxSpeedLimit;

        List<Integer> carSpeed = new ArrayList<>();
        for(int i=1 ;i < 151; i++){
            carSpeed.add(i);
        }
        GeneratedRadarData.carSpeed = carSpeed;


        List<RadarData> radarDataList = new ArrayList<>();
        RadarData radarData = new RadarData();
        radarData.setDriverName("Karel Pokorny");
        radarData.setSpz("9AK1234");
        radarDataList.add(radarData);

        RadarData radarData2= new RadarData();
        radarData2.setDriverName("Petr Ohrablo");
        radarData2.setSpz("3PQ5222");
        radarDataList.add(radarData2);

        RadarData radarData3= new RadarData();
        radarData3.setDriverName("Jindra Kral");
        radarData3.setSpz("A007SQ");
        radarDataList.add(radarData3);

        RadarData radarData4= new RadarData();
        radarData4.setDriverName("Michal Cervenka");
        radarData4.setSpz("PW23M6");
        radarDataList.add(radarData4);

        RadarData radarData5= new RadarData();
        radarData5.setDriverName("Petr Chvojka");
        radarData5.setSpz("OO23SD");
        radarDataList.add(radarData5);

        RadarData radarData6= new RadarData();
        radarData6.setDriverName("Jirka Ohen");
        radarData6.setSpz("US28MM");
        radarDataList.add(radarData6);

        RadarData radarData7= new RadarData();
        radarData7.setDriverName("Pavel Kriz");
        radarData7.setSpz("WW257KL");
        radarDataList.add(radarData7);

        RadarData radarData8= new RadarData();
        radarData8.setDriverName("Ondra Smrk");
        radarData8.setSpz("TT0MS3");
        radarDataList.add(radarData8);

        RadarData radarData9= new RadarData();
        radarData9.setDriverName("Lukas Krbon");
        radarData9.setSpz("DS32OP4");
        radarDataList.add(radarData9);

        RadarData radarData10= new RadarData();
        radarData10.setDriverName("Martin Cesky");
        radarData10.setSpz("E257KL");
        radarDataList.add(radarData10);

        RadarData radarData11= new RadarData();
        radarData11.setDriverName("Ondra Kopr");
        radarData11.setSpz("QPL32M");
        radarDataList.add(radarData11);

        RadarData radarData12= new RadarData();
        radarData12.setDriverName("Pavel Hnizdo");
        radarData12.setSpz("OLMS321");
        radarDataList.add(radarData12);

        RadarData radarData13= new RadarData();
        radarData13.setDriverName("Jan Prokop");
        radarData13.setSpz("AS45B6");
        radarDataList.add(radarData13);

        RadarData radarData14= new RadarData();
        radarData14.setDriverName("Oman Sharif");
        radarData14.setSpz("BIM35Q");
        radarDataList.add(radarData14);

        RadarData radarData15= new RadarData();
        radarData15.setDriverName("Jan Smejkal");
        radarData15.setSpz("ROU235");
        radarDataList.add(radarData15);


        GeneratedRadarData.radarDataList = radarDataList;


    }


}
