package cz.system.police.controllers;


import cz.system.police.data.RadarData;
import cz.system.police.services.ReceiveDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api(description = "This is Controller for receive data from radars.")
public class ReceiveDataController {


    ReceiveDataService receiveDataService;

    public ReceiveDataController(ReceiveDataService receiveDataService) {
        this.receiveDataService = receiveDataService;
    }

    @PostMapping("/radar/data")
    @ApiOperation(value = "This will store Radar data", notes="If there was no exceed speed. The data didn't stored.")
    public ResponseEntity<Long> saveDataFromRadar(@RequestBody RadarData data) {
        try {
        return new ResponseEntity<>(receiveDataService.checkAndStoreDataFromRadar(data), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(0L,HttpStatus.ACCEPTED);
        }
    }


}
