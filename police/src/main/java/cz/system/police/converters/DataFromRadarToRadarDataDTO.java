package cz.system.police.converters;

import cz.system.police.data.RadarData;
import cz.system.police.data.RadarDataDTO;
import cz.system.police.domain.DataFromRadar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DataFromRadarToRadarDataDTO  implements Converter<DataFromRadar, RadarDataDTO> {

    @Override
    public RadarDataDTO convert(DataFromRadar dataFromRadar) {
        final RadarDataDTO radarDataDTO = new RadarDataDTO();
        radarDataDTO.setCarSpeed(dataFromRadar.getCarSpeed());
        radarDataDTO.setDriverName(dataFromRadar.getDriverName());
        radarDataDTO.setExceedSpeedLimit(dataFromRadar.getExceedSpeedLimit());
        radarDataDTO.setId(dataFromRadar.getId());
        radarDataDTO.setPictureDate(dataFromRadar.getPictureDate());
        radarDataDTO.setSpz(dataFromRadar.getSpz());
        radarDataDTO.setState(dataFromRadar.getState());
        radarDataDTO.setMaxSpeedLimit(dataFromRadar.getMaxSpeedLimit());
        return radarDataDTO;
    }
}
