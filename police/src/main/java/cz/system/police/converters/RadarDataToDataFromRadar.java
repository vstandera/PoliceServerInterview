package cz.system.police.converters;

import cz.system.police.data.RadarData;
import cz.system.police.domain.DataFromRadar;
import cz.system.police.domain.PenaltyState;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RadarDataToDataFromRadar  implements Converter<RadarData, DataFromRadar> {

    @Override
    @Synchronized
    @Nullable
    public DataFromRadar convert(RadarData radarData) {
        if (radarData == null){
            return null;
        }
        final DataFromRadar dataFromRadar = new DataFromRadar();
        dataFromRadar.setCarSpeed(radarData.getCarSpeed());
        dataFromRadar.setDriverName(radarData.getDriverName());
        dataFromRadar.setMaxSpeedLimit(radarData.getMaxSpeedLimit());
        dataFromRadar.setPictureDate(radarData.getPictureDate());
        dataFromRadar.setSpz(radarData.getSpz());
        dataFromRadar.setState(PenaltyState.NEW);
        dataFromRadar.setExceedSpeedLimit(radarData.getCarSpeed() - radarData.getMaxSpeedLimit());

        return dataFromRadar;
    }
}
