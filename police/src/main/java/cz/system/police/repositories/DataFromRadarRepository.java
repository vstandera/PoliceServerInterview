package cz.system.police.repositories;

import cz.system.police.domain.DataFromRadar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DataFromRadarRepository extends CrudRepository<DataFromRadar, Long> {

    List<DataFromRadar> findByDriverName(String driverName);

    @Query("select d from DataFromRadar d where d.exceedSpeedLimit> :limit")
    List<DataFromRadar> findByExceedSpeedLimitMoreThen(@Param("limit") Integer limit);

}
