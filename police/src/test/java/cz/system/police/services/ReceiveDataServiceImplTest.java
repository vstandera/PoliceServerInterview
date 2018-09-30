package cz.system.police.services;

import cz.system.police.converters.RadarDataToDataFromRadar;
import cz.system.police.data.RadarData;
import cz.system.police.domain.DataFromRadar;
import cz.system.police.repositories.DataFromRadarRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ReceiveDataServiceImplTest {

    @Mock
    DataFromRadarRepository dataFromRadarRepository;

    @Mock
    RadarDataToDataFromRadar radarDataToDataFromRadar;

    ReceiveDataService receiveDataService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        receiveDataService = new ReceiveDataServiceImpl(dataFromRadarRepository, radarDataToDataFromRadar);
    }

    @Test
    public void checkAndStoreDataFromRadar() {
        Date date = new Date();
        date.setTime(1540730040129L);

        RadarData radarData = new RadarData();
        radarData.setDriverName("Pavel Kasr");
        radarData.setCarSpeed(120);
        radarData.setPictureDate(date);
        radarData.setMaxSpeedLimit(90);
        radarData.setSpz("2AM653");


        final Long id = new Long(3L);
        DataFromRadar savedData = new DataFromRadar();
        savedData.setDriverName("Pavel Kasr");
        savedData.setCarSpeed(120);
        savedData.setPictureDate(date);
        savedData.setMaxSpeedLimit(90);
        savedData.setSpz("2AM653");
        savedData.setId(id);

        when(dataFromRadarRepository.save(any())).thenReturn(savedData);
        final Long result = receiveDataService.checkAndStoreDataFromRadar(radarData);
        assertEquals(result.longValue(), id.longValue());
    }
}