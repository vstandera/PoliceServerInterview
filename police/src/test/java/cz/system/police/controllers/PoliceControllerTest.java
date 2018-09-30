package cz.system.police.controllers;

import cz.system.police.data.RadarDataDTO;
import cz.system.police.services.FinesService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PoliceControllerTest {

    @Mock
    FinesService finesService;

    PoliceController policeController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        policeController = new PoliceController(finesService);
        mockMvc = MockMvcBuilders.standaloneSetup(policeController).build();
    }

    @Test
    public void getAllFines() {
        RadarDataDTO radarData = new RadarDataDTO();
        radarData.setDriverName("Pavel Kasr");
        radarData.setCarSpeed(120);
        radarData.setPictureDate(new Date());
        radarData.setMaxSpeedLimit(90);
        List<RadarDataDTO> radarDataList = new ArrayList<>();
        radarDataList.add(radarData);

        when(finesService.getAllFines()).thenReturn(radarDataList);
        try {
            mockMvc.perform(get("/getAllFines")).andExpect(status().isOk())
                    .andExpect(view().name("fines/finesAll"))
                    .andExpect(model().attributeExists("fines"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}