package cz.system.police.services;

import cz.system.police.data.RadarData;

public interface ReceiveDataService {

    Long checkAndStoreDataFromRadar(RadarData data);
}
