package cz.system.police.services;

import cz.system.police.converters.RadarDataToDataFromRadar;
import cz.system.police.data.RadarData;
import cz.system.police.domain.DataFromRadar;
import cz.system.police.repositories.DataFromRadarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiveDataServiceImpl implements ReceiveDataService{

    DataFromRadarRepository dataFromRadarRepository;

    RadarDataToDataFromRadar radarDataToDataFromRadar;

    public ReceiveDataServiceImpl(DataFromRadarRepository dataFromRadarRepository, RadarDataToDataFromRadar radarDataToDataFromRadar) {
        this.dataFromRadarRepository = dataFromRadarRepository;
        this.radarDataToDataFromRadar = radarDataToDataFromRadar;
    }

    @Override
    public Long checkAndStoreDataFromRadar(RadarData data){
        if (checkSpeedLimitData(data)){
            final DataFromRadar dataFromRadar = radarDataToDataFromRadar.convert(data);
            final DataFromRadar savedDataFromRadar = dataFromRadarRepository.save(dataFromRadar);
            return savedDataFromRadar.getId();
        }

        throw new  RuntimeException("Data was not saved.");
    }

    private boolean checkSpeedLimitData(RadarData data){
        if (data.getCarSpeed()!=null && data.getMaxSpeedLimit() !=null && data.getCarSpeed() > data.getMaxSpeedLimit()){
            return true;
        }
        return false;
    }

}
