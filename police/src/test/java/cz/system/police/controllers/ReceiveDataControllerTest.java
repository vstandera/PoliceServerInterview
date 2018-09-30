package cz.system.police.controllers;

import cz.system.police.data.RadarData;
import cz.system.police.services.ReceiveDataService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReceiveDataControllerTest {

    @Mock
    ReceiveDataService receiveDataService;

    ReceiveDataController receiveDataController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        receiveDataController = new ReceiveDataController(receiveDataService);
        mockMvc = MockMvcBuilders.standaloneSetup(receiveDataController).build();
    }

    @Test
    public void storeDataFromRadar(){

        RadarData radarData = new RadarData();
        radarData.setDriverName("Pavel Kasr");
        radarData.setCarSpeed(120);
        Date date = new Date();
        date.setTime(1540730040129L);
        radarData.setPictureDate(date);
        radarData.setMaxSpeedLimit(90);
        radarData.setSpz("2AM653");

        when(receiveDataService.checkAndStoreDataFromRadar(radarData)).thenReturn(5L);
        try {
            mockMvc.perform(post("/radar/data").contentType(MediaType.APPLICATION_JSON)
                    .content("{  \"driverName\": \"Pavel Kasr\",\"spz\": \"2AM653\", \"maxSpeedLimit\": \"90\", \"carSpeed\": \"120\", \"pictureDate\":\"2018-09-28T13:34:00.000\" }")
            ).andExpect(status().isCreated());
            verify(receiveDataService, times(1)).checkAndStoreDataFromRadar(any());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}